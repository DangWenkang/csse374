package problem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MacLabel extends Label {

	public MacLabel(String text) {
		super(text, null);
	}

	public MacLabel(String text, Rectangle bound) {
		super(null, text, bound);
	}

	public MacLabel(IComponent parent, String text, Rectangle bound) {
		super(parent, text, bound);
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		Rectangle bound = this.getBounds();
		
		// Draw the text
		g.setFont(new Font("Garamond", Font.PLAIN, 14)); 		
		g.setColor(new Color(139, 144, 151));
		g.drawString(super.getText(), bound.x + Label.H_SPACE, bound.y + 16);
	}
	
}
