package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MacButtonTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestConstructorWithoutParameters() {
		Button b = new MacButton();
		
		assertEquals("",b.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringParameter() {
		Button b = new MacButton("String");
		
		assertEquals("String",b.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringAndBoundParameters() {
		Rectangle rect = new Rectangle(100,100,50,50);
		
		Button b = new MacButton("String and Bound", rect);
		
		assertEquals("String and Bound",b.getText());
		assertEquals(rect, b.getBounds());
	}
	
	@Test
	public void TestConstructorWithParentStringAndBoundParameters() {
		Window w = new MacWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		
		Button b = new MacButton(w, "String and Bound", rect);
		
		assertEquals(w, b.getParent());
		assertEquals("String and Bound",b.getText());
		assertEquals(rect, b.getBounds());
	}
	
	@Test
	public void TestSetText() {
		Button b = new MacButton();
		assertEquals("",b.getText());
		
		b.setText("Test");
		assertEquals("Test", b.getText());
		
		b.setText("Test Again");
		assertEquals("Test Again", b.getText());
	}
	
	@Test
	public void TestSetBounds() {
		Button b = new MacButton();
		assertEquals(new Rectangle(0, 0, 50, 50), b.getBounds());
		
		b.setBounds(new Rectangle(100,100,50,50));
		assertEquals(new Rectangle(100, 100, 50, 50), b.getBounds());
		
		b.setBounds(new Rectangle(1100,1100,250,250));
		assertEquals(new Rectangle(1100, 1100, 250, 250), b.getBounds());
	}
	
	@Test
	public void TestGetParent() {
		Button b = new MacButton();
		assertNull(b.getParent());
		
		Window w = new MacWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		b = new MacButton(w, "String and Bound", rect);
		assertEquals(w, b.getParent());
		
		Window w2 = new MacWindow("Text", rect);
		b = new MacButton(w2, "String and Bound", rect);
		assertEquals(w2, b.getParent());
	}

}
