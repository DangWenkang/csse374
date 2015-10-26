package problem.blueberrymuffin;

public class BlueberryThread1 extends AbstractBlueberryThread {

	private static BlueberryThread1 uniqueThread = new BlueberryThread1();
	
	protected BlueberryThread1() {};
	
	public static BlueberryThread1 getInstance() {
		return uniqueThread;
	}
	
}
