package problem.renderers.windows;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem.components.Button;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.Configuration;
import problem.renderers.IRenderer;

// Here is an example test for testing factories
public class WindowRendererFactoryTest {
	WindowRendererFactory factory;
	
	@Before
	public final void setUp() {
		Configuration.setTest(true);;
		Configuration.setDefaultOS("windows");
		
		factory = new WindowRendererFactory();
	}
	
	@After
	public final void tearDown() {
		factory = null;
	}

	@Test
	public final void testCreateButton() {
		Button b = new Button();
		IRenderer r = b.getRenderer();
		assertTrue(r instanceof ButtonRenderer);
	}

	@Test
	public final void testCreateLabel() {
		Label b = new Label("");
		IRenderer r = b.getRenderer();
		assertTrue(r instanceof LabelRenderer);
	}

	@Test
	public final void testCreateTextBox() {
		TextBox b = new TextBox();
		IRenderer r = b.getRenderer();
		System.out.println(r.getClass());
		assertTrue(r instanceof TextBoxRenderer);
	}

	@Test
	public final void testCreateTextWindow() {
		Window b = new Window();
		IRenderer r = b.getRenderer();
		assertTrue(r instanceof WindowRenderer);
	}
}
