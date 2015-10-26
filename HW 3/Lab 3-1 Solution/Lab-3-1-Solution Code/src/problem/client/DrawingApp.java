package problem.client;

import java.awt.Rectangle;

import problem.components.Button;
import problem.components.Label;
import problem.components.TextBox;
import problem.components.Window;

public class DrawingApp {

	public static void main(String[] args) throws Exception {
		Window window = new Window("This is a Window", new Rectangle(200,200, 500, 500));
		Label label = new Label(window, "This is a label", new Rectangle(5,30, 200, 25));
		window.show();
		
		for(int i = 10; i <= 100; i+=10) {
			Thread.sleep(200);
			label.setBounds(new Rectangle(5 + i, 30 + i, 300, 25));
		}
		
		TextBox text = new TextBox("This is a text", new Rectangle(300,50, 100, 25));
		window.addChild(text);

		Button button = new Button("This is a button", new Rectangle(140,400, 100, 25));
		window.addChild(button);
	}
}
