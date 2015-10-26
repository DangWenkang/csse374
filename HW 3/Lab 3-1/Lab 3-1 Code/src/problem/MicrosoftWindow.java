package problem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MicrosoftWindow extends Window {

	public MicrosoftWindow() {
		super(null);
	}

	public MicrosoftWindow(String title) {
		super(title, null);
	}

	public MicrosoftWindow(String title, Rectangle bound) {
		super(title, bound);
	}

	@Override
	public void drawComponent(Graphics2D g) {
		// Draw the border
		g.setColor(Color.gray);
		g.draw3DRect(1, 1, this.getBounds().width - H_SPACE,
				(int) this.getBounds().height - V_SPACE, true);

		// Draw the title bar
		g.setColor(new Color(49, 68, 176));
		g.fill3DRect(1, 1, this.getBounds().width - H_SPACE, TITLE_HEIGHT - 5,
				true);

		// Draw the title
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.setColor(Color.white);
		g.drawString(super.getTitle(), 5, 17);
	}

}
