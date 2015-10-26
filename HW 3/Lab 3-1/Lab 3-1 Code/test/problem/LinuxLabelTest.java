package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinuxLabelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestConstructorWithStringParameter() {
		Label l = new LinuxLabel("Test");
		
		assertEquals("Test",l.getText());
		assertEquals(new Rectangle(0, 0, 50, 50), l.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringAndBoundParameters() {
		Rectangle rect = new Rectangle(100,100,50,50);
		Label l = new LinuxLabel("Test", rect);
		
		assertEquals("Test",l.getText());
		assertEquals(rect, l.getBounds());
	}
	
	@Test
	public void TestConstructorWithParentStringAndBoundParameters() {
		Window w = new LinuxWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		Label l = new LinuxLabel(w, "Test", rect);
		
		assertEquals("Test",l.getText());
		assertEquals(rect, l.getBounds());
		assertEquals(w, l.getParent());
	}
	
	@Test
	public void TestSetText() {
		Label l = new LinuxLabel("Test");
		assertEquals("Test",l.getText());
		
		l.setText("Test2");
		assertEquals("Test2", l.getText());
		
		l.setText("Test Again");
		assertEquals("Test Again", l.getText());
	}
	
	@Test
	public void TestSetBounds() {
		Label l = new LinuxLabel("Test");
		assertEquals(new Rectangle(0, 0, 50, 50), l.getBounds());
		
		l.setBounds(new Rectangle(100,100,50,50));
		assertEquals(new Rectangle(100, 100, 50, 50), l.getBounds());
		
		l.setBounds(new Rectangle(1100,1100,250,250));
		assertEquals(new Rectangle(1100, 1100, 250, 250), l.getBounds());
	}
	
	@Test
	public void TestGetParent() {
		Label l = new LinuxLabel("Test");
		assertNull(l.getParent());
		
		Window w = new MicrosoftWindow();
		Rectangle rect = new Rectangle(100,100,50,50);
		l = new LinuxLabel(w, "String and Bound", rect);
		assertEquals(w, l.getParent());
		
		Window w2 = new MicrosoftWindow("Text", rect);
		l = new LinuxLabel(w2, "String and Bound", rect);
		assertEquals(w2, l.getParent());
	}
}
