package problem.blueberrymuffin;

public class BlueberryThread2 extends AbstractBlueberryThread {

	private static BlueberryThread2 uniqueThread = new BlueberryThread2();
	
	protected BlueberryThread2() {};
	
	public static BlueberryThread2 getInstance() {
		return uniqueThread;
	}
	
}
