package problem.blueberrymuffin;

import java.util.ArrayList;
import java.util.LinkedList;

public class BlueberryMuffin {

	LinkedList<AbstractRunnable> queue;
	ArrayList<AbstractBlueberryThread> active;

	public BlueberryMuffin() {
		this.queue = new LinkedList<AbstractRunnable>();

		this.active = new ArrayList<AbstractBlueberryThread>();
		this.active.add(BlueberryThread1.getInstance());
		this.active.add(BlueberryThread2.getInstance());
		this.active.add(BlueberryThread3.getInstance());
	}

	public void setThread(AbstractRunnable runnable) {

		for (AbstractBlueberryThread t : active) {
			if (t.getRunnable() == null || t.getRunnable().isFinished() == true) {
				t.setRunnable(runnable);
				return;
			}
		}

		// if all the threads are executing then this thread is added to the
		// back of the queue
		this.queue.add(runnable);

	}

	public void threadWasStarted() throws InterruptedException {
		for (AbstractBlueberryThread t : active) {
			if (t.getRunnable() != null) {
				t.getRunnable().run();
				t.setRunnable(null);
			}

			if (!this.queue.isEmpty()) {
				setThread(this.queue.pop());
				threadWasStarted();
			}
		}

	}

}
