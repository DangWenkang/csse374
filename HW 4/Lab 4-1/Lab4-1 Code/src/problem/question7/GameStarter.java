package problem.question7;

public class GameStarter {
	
	private Game game;

	public void startGame() {
		Thread clock = new Thread(new Clock());
		clock.run();
		game.beginPlay();
		
		if (Clock.done == true) {
			clock.interrupt();
		}
	}
	
}
