package problem;

public abstract class Gui {
	
	private GuiComponentFactory compFactory;
	
	public abstract Window createGui();
	
	public void setCompFactory(GuiComponentFactory compFactory) {
		this.compFactory = compFactory;
	}
	
	public GuiComponentFactory getCompFactory() {
		return this.compFactory;
	}

}
