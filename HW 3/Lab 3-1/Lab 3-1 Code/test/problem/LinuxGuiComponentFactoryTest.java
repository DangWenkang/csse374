package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinuxGuiComponentFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestCreateWindow() {
		GuiComponentFactory gcf = new LinuxGuiComponentFactory();
		Window w = gcf.createWindow();
		
		assertEquals("Linux Window", w.getTitle());
		assertEquals(new Rectangle(0,0,50,50), w.getBounds());
	}
	
	@Test
	public void TestCreateTextBox() {
		GuiComponentFactory gcf = new LinuxGuiComponentFactory();
		TextBox t =  gcf.createTextBox();
		
		assertEquals("Linux TextBox", t.getText());
		assertEquals(new Rectangle(0,0,50,50), t.getBounds());
	}
	
	@Test
	public void TestCreateLabel() {
		GuiComponentFactory gcf = new LinuxGuiComponentFactory();
		Label l =  gcf.createLabel();
		
		assertEquals("Linux Label", l.getText());
		assertEquals(new Rectangle(0,0,50,50), l.getBounds());
	}
	
	@Test
	public void TestCreateButton() {
		GuiComponentFactory gcf = new LinuxGuiComponentFactory();
		Button b =  gcf.createButton();
		
		assertEquals("Linux Button", b.getText());
		assertEquals(new Rectangle(0,0,50,50), b.getBounds());
	}

}
