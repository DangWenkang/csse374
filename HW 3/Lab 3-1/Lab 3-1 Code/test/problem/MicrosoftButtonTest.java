package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftButtonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestConstructorWithoutParameters() {
		Button b = new MicrosoftButton();
		
		assertEquals("",b.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringParameter() {
		Button b = new MicrosoftButton("String");
		
		assertEquals("String",b.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringAndBoundParameters() {
		Rectangle rect = new Rectangle(100,100,50,50);
		
		Button b = new MicrosoftButton("String and Bound", rect);
		
		assertEquals("String and Bound",b.getText());
		assertEquals(rect, b.getBounds());
	}
	
	@Test
	public void TestConstructorWithParentStringAndBoundParameters() {
		Window w = new MicrosoftWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		
		Button b = new MicrosoftButton(w, "String and Bound", rect);
		
		assertEquals(w, b.getParent());
		assertEquals("String and Bound",b.getText());
		assertEquals(rect, b.getBounds());
	}
	
	@Test
	public void TestSetText() {
		Button b = new MicrosoftButton();
		assertEquals("",b.getText());
		
		b.setText("Test");
		assertEquals("Test", b.getText());
		
		b.setText("Test Again");
		assertEquals("Test Again", b.getText());
	}
	
	@Test
	public void TestSetBounds() {
		Button b = new MicrosoftButton();
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
		
		b.setBounds(new Rectangle(100,100,50,50));
		assertEquals(new Rectangle(100, 100, 50, 50), b.getBounds());
		
		b.setBounds(new Rectangle(1100,1100,250,250));
		assertEquals(new Rectangle(1100, 1100, 250, 250), b.getBounds());
	}
	
	@Test
	public void TestGetParent() {
		Button b = new MicrosoftButton();
		assertNull(b.getParent());
		
		Window w = new MicrosoftWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		b = new MicrosoftButton(w, "String and Bound", rect);
		assertEquals(w, b.getParent());
		
		Window w2 = new MicrosoftWindow("Text", rect);
		b = new MicrosoftButton(w2, "String and Bound", rect);
		assertEquals(w2, b.getParent());
	}

}
