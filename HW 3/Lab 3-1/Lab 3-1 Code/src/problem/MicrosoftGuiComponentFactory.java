package problem;

public class MicrosoftGuiComponentFactory implements GuiComponentFactory {

	@Override
	public Window createWindow() {
		return new MicrosoftWindow("Microsoft Window");
	}

	@Override
	public TextBox createTextBox() {
		return new MicrosoftTextBox("Microsoft TextBox");
	}

	@Override
	public Label createLabel() {
		return new MicrosoftLabel("Microsoft Label");
	}

	@Override
	public Button createButton() {
		return new MicrosoftButton("Microsoft Button");
	}

}
