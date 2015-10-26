package problem;

public class LinuxGuiComponentFactory implements GuiComponentFactory {

	@Override
	public Window createWindow() {
		return new LinuxWindow("Linux Window");
	}

	@Override
	public TextBox createTextBox() {
		return new LinuxTextBox("Linux TextBox");
	}

	@Override
	public Label createLabel() {
		return new LinuxLabel("Linux Label");
	}

	@Override
	public Button createButton() {
		return new LinuxButton("Linux Button");
	}

}
