package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftGuiComponentFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCreateWindow() {
		GuiComponentFactory gcf = new MicrosoftGuiComponentFactory();
		Window w = gcf.createWindow();
		
		assertEquals("Microsoft Window", w.getTitle());
		assertEquals(new Rectangle(0,0,50,50), w.getBounds());
	}
	
	@Test
	public void TestCreateTextBox() {
		GuiComponentFactory gcf = new MicrosoftGuiComponentFactory();
		TextBox t =  gcf.createTextBox();
		
		assertEquals("Microsoft TextBox", t.getText());
		assertEquals(new Rectangle(0,0,50,50), t.getBounds());
	}
	
	@Test
	public void TestCreateLabel() {
		GuiComponentFactory gcf = new MicrosoftGuiComponentFactory();
		Label l =  gcf.createLabel();
		
		assertEquals("Microsoft Label", l.getText());
		assertEquals(new Rectangle(0,0,50,50), l.getBounds());
	}
	
	@Test
	public void TestCreateButton() {
		GuiComponentFactory gcf = new MicrosoftGuiComponentFactory();
		Button b =  gcf.createButton();
		
		assertEquals("Microsoft Button", b.getText());
		assertEquals(new Rectangle(0,0,50,50), b.getBounds());
	}

}
