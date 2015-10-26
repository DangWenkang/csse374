package problem.blueberrymuffin;

public class BlueberryThread3 extends AbstractBlueberryThread {

	private static BlueberryThread3 uniqueThread = new BlueberryThread3();
	
	protected BlueberryThread3() {};
	
	public static BlueberryThread3 getInstance() {
		return uniqueThread;
	}
	
}
