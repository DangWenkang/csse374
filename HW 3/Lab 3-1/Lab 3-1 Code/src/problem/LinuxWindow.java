package problem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class LinuxWindow extends Window {

	public LinuxWindow() {
		super(null);
	}

	public LinuxWindow(String title) {
		super(title, null);
	}

	public LinuxWindow(String title, Rectangle bound) {
		super(title, bound);
	}


	@Override
	public void drawComponent(Graphics2D g) {
		// Draw the border
		g.setColor(new Color(48, 0, 0));
		g.draw3DRect(1, 1, this.getBounds().width - H_SPACE,
				this.getBounds().height - V_SPACE, true);

		// Draw the title bar
		g.setColor(new Color(96, 0, 0));
		g.fill3DRect(1, 1, (int) this.getBounds().width - H_SPACE,
				TITLE_HEIGHT, true);

		// Draw the title
		g.setFont(new Font("Arial", Font.PLAIN, 17));
		g.setColor(Color.white);
		g.drawString(super.getTitle(), 5, 20);
	}

}
