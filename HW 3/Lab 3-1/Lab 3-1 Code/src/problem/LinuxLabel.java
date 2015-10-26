package problem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LinuxLabel extends Label {

	public LinuxLabel(String text) {
		super(text, null);
	}

	public LinuxLabel(String text, Rectangle bound) {
		super(null, text, bound);
	}

	public LinuxLabel(IComponent parent, String text, Rectangle bound) {
		super(parent, text, bound);
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		Rectangle bound = this.getBounds();
		
		// Draw the title
		g.setFont(new Font("Arial", Font.PLAIN, 14)); 		
		g.setColor(Color.black);
		g.drawString(super.getText(), bound.x + Label.H_SPACE, bound.y + 16);
	}

}
