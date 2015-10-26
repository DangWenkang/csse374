package problem;

public class MacGuiComponentFactory implements GuiComponentFactory {

	@Override
	public Window createWindow() {
		return new MacWindow("Mac Window");
	}

	@Override
	public TextBox createTextBox() {
		return new MacTextBox("Mac TextBox");
	}

	@Override
	public Label createLabel() {
		return new MacLabel("Mac Label");
	}

	@Override
	public Button createButton() {
		return new MacButton("Mac Button");
	}

}
