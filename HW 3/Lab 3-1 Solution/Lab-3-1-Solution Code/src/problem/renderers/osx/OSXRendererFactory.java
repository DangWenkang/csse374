package problem.renderers.osx;

import problem.components.Button;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;
import problem.renderers.AbstractRendererFactory;

public class OSXRendererFactory extends AbstractRendererFactory {
	@Override
	protected void populate() {
		this.put(Window.class, WindowRenderer.class);
		this.put(Label.class, LabelRenderer.class);
		this.put(TextBox.class, TextBoxRenderer.class);
		this.put(Button.class, ButtonRenderer.class);
	}
}
