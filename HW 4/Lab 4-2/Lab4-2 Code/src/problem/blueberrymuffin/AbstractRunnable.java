package problem.blueberrymuffin;

public abstract class AbstractRunnable implements Runnable {
	
	protected boolean finished;

	@Override
	public abstract void run();
	
	public boolean isFinished() {
		return this.finished;
	}

}
