package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MacGuiComponentFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCreateWindow() {
		GuiComponentFactory gcf = new MacGuiComponentFactory();
		Window w = gcf.createWindow();
		
		assertEquals("Mac Window", w.getTitle());
		assertEquals(new Rectangle(0,0,50,50), w.getBounds());
	}
	
	@Test
	public void TestCreateTextBox() {
		GuiComponentFactory gcf = new MacGuiComponentFactory();
		TextBox t =  gcf.createTextBox();
		
		assertEquals("Mac TextBox", t.getText());
		assertEquals(new Rectangle(0,0,50,50), t.getBounds());
	}
	
	@Test
	public void TestCreateLabel() {
		GuiComponentFactory gcf = new MacGuiComponentFactory();
		Label l =  gcf.createLabel();
		
		assertEquals("Mac Label", l.getText());
		assertEquals(new Rectangle(0,0,50,50), l.getBounds());
	}
	
	@Test
	public void TestCreateButton() {
		GuiComponentFactory gcf = new MacGuiComponentFactory();
		Button b =  gcf.createButton();
		
		assertEquals("Mac Button", b.getText());
		assertEquals(new Rectangle(0,0,50,50), b.getBounds());
	}

}
