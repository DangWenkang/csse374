package problem.blueberrymuffin;

public abstract class AbstractBlueberryThread extends Thread {
	
	protected AbstractRunnable runnable = null;
	
	protected AbstractBlueberryThread() {
	}

	public void setRunnable(AbstractRunnable runnable) {
		this.runnable = runnable;
	}
	
	public AbstractRunnable getRunnable() {
		return this.runnable;
	}
	
}
