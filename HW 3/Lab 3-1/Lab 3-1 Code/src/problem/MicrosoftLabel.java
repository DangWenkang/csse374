package problem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MicrosoftLabel extends Label {

	public MicrosoftLabel(String text) {
		super(text, null);
	}

	public MicrosoftLabel(String text, Rectangle bound) {
		super(null, text, bound);
	}

	public MicrosoftLabel(IComponent parent, String text, Rectangle bound) {
		super(parent, text, bound);
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		Rectangle bound = this.getBounds();
		
		// Draw the title
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12)); 		
		g.setColor(Color.black);
		g.drawString(super.getText(), bound.x + Label.H_SPACE, bound.y + 16);
	}

}
