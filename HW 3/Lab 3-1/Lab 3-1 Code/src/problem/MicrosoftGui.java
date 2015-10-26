package problem;

import java.awt.Rectangle;

public class MicrosoftGui extends Gui {

	@Override
	public Window createGui() {
		setCompFactory(new MicrosoftGuiComponentFactory());
		Window w = getCompFactory().createWindow();
		Button b = getCompFactory().createButton();
		b.setBounds(new Rectangle(5,30, 200, 25));
		Label l = getCompFactory().createLabel();
		l.setBounds(new Rectangle(300,50, 100, 25));
		TextBox t = getCompFactory().createTextBox();
		t.setBounds(new Rectangle(150, 150, 100, 25));
		w.addChild(b);
		w.addChild(l);
		w.addChild(t);
		return w;
	}

}
