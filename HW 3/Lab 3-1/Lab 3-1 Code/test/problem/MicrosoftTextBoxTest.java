package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftTextBoxTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestConstructorWithoutParameters() {
		TextBox t = new MicrosoftTextBox();
		
		assertEquals("",t.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), t.getBounds());
	}

	@Test
	public void TestConstructorWithStringParameter() {
		TextBox t = new MicrosoftTextBox("Test");
		
		assertEquals("Test",t.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), t.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringAndBoundParameters() {
		Rectangle rect = new Rectangle(100,100,50,50);
		TextBox t = new MicrosoftTextBox("Test", rect);
		
		assertEquals("Test",t.getText());
		assertEquals(rect, t.getBounds());
	}
	
	@Test
	public void TestConstructorWithParentStringAndBoundParameters() {
		Window w = new MicrosoftWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		TextBox t = new MicrosoftTextBox(w, "Test", rect);
		
		assertEquals("Test",t.getText());
		assertEquals(rect, t.getBounds());
		assertEquals(w, t.getParent());
	}
	
	@Test
	public void TestSetText() {
		TextBox t = new MicrosoftTextBox("Test");
		assertEquals("Test",t.getText());
		
		t.setText("Test2");
		assertEquals("Test2", t.getText());
		
		t.setText("Test Again");
		assertEquals("Test Again", t.getText());
	}
	
	@Test
	public void TestSetBounds() {
		TextBox t = new MicrosoftTextBox("Test");
		assertEquals(new Rectangle(0, 0, 50, 50), t.getBounds());
		
		t.setBounds(new Rectangle(100,100,50,50));
		assertEquals(new Rectangle(100, 100, 50, 50), t.getBounds());
		
		t.setBounds(new Rectangle(1100,1100,250,250));
		assertEquals(new Rectangle(1100, 1100, 250, 250), t.getBounds());
	}
	
	@Test
	public void TestGetParent() {
		TextBox t = new MicrosoftTextBox("Test");
		assertNull(t.getParent());
		
		Window w = new MicrosoftWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		t = new MicrosoftTextBox(w, "String and Bound", rect);
		assertEquals(w, t.getParent());
		
		Window w2 = new MicrosoftWindow("Text", rect);
		t = new MicrosoftTextBox(w2, "String and Bound", rect);
		assertEquals(w2, t.getParent());
	}

}
