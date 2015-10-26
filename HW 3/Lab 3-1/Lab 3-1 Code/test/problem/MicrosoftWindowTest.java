package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftWindowTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestConstructorWithoutParameters() {
		Window w = new MicrosoftWindow();
		
		assertEquals("",w.getTitle());
		assertEquals(new Rectangle(0, 0, 50, 50), w.getBounds());
	}

	@Test
	public void TestConstructorWithStringParameter() {
		Window w = new MicrosoftWindow("Test");
		
		assertEquals("Test",w.getTitle());
		assertEquals(new Rectangle(0, 0, 50, 50), w.getBounds());
	}
	
	@Test
	public void TestConstructorWithStringAndBoundParameters() {
		Rectangle rect = new Rectangle(100,100,50,50);
		Window w = new MicrosoftWindow("Test", rect);
		
		assertEquals("Test",w.getTitle());
		assertEquals(rect, w.getBounds());
	}
	
	@Test
	public void TestSetTitle() {
		Window w = new MicrosoftWindow("Test");
		assertEquals("Test",w.getTitle());
		
		w.setTitle("Test2");
		assertEquals("Test2", w.getTitle());
		
		w.setTitle("Test Again");
		assertEquals("Test Again", w.getTitle());
	}
	
	@Test
	public void TestSetBounds() {
		Window w = new MicrosoftWindow("Test");
		assertEquals(new Rectangle(0, 0, 50, 50), w.getBounds());
		
		w.setBounds(new Rectangle(100,100,50,50));
		assertEquals(new Rectangle(100, 100, 50, 50), w.getBounds());
		
		w.setBounds(new Rectangle(1100,1100,250,250));
		assertEquals(new Rectangle(1100, 1100, 250, 250), w.getBounds());
	}

}
