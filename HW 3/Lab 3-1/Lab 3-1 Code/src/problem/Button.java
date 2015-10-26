package problem;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Button extends AbstractComponent {
	
	public static final int H_SPACE = 5;
	
	private String text;
	
	public Button() {
		this(null);
	}

	public Button(String text) {
		this(text, null);
	}

	public Button(String text, Rectangle bound) {
		this(null, text, bound);
	}
	
	public Button(IComponent parent, String text, Rectangle bound) {
		super(parent, bound);
		
		this.text = text;
		
		if(this.text == null)
			this.text = "";
	}

	/**
	 * Gets the text in the label.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the text in the button. 
	 * Calling this method results in the call to {@link #fireUpdate()}, 
	 * which informs the component hierarchy to re-draw itself.
	 */
	public void setText(String text) {
		this.text = text;
		this.fireUpdate();
	}

	public abstract void drawComponent(Graphics2D g);

}
