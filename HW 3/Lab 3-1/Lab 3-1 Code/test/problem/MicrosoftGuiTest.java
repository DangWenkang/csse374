package problem;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftGuiTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestCreateGui() {
		Gui gui = new MicrosoftGui();
		Window w = gui.createGui();
		
		// Window
		assertEquals("Microsoft Window", w.getTitle());
		assertEquals(new Rectangle(0,0,50,50), w.getBounds());
		
		// Button
		Button b = (Button) w.getChildren().get(0);
		
		assertEquals("Microsoft Button", b.getText());
		assertEquals(new Rectangle(5,30, 200, 25), b.getBounds());
		
		// Label
		Label l = (Label) w.getChildren().get(1);
		
		assertEquals("Microsoft Label", l.getText());
		assertEquals(new Rectangle(300,50, 100, 25), l.getBounds());
		
		// TextBox
		TextBox t = (TextBox) w.getChildren().get(2);
		
		assertEquals("Microsoft TextBox", t.getText());
		assertEquals(new Rectangle(150, 150, 100, 25), t.getBounds());
	}

	@Test
	public void TestSetCompFactory() {
		GuiComponentFactory gcf = new MicrosoftGuiComponentFactory();
		Gui gui = new MicrosoftGui();
		gui.setCompFactory(gcf);
		
		assertEquals(gcf, gui.getCompFactory());
	}

}
