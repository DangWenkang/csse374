package problem.blueberrymuffinclient;

import problem.blueberrymuffin.MuffinThreadExecutor;
import problem.blueberrymuffin.VirtualThread;

public class CreatorThread extends VirtualThread {

	@Override
	public void run() {
		for(int i = 1; i <= 3; ++i) {
			System.out.format("[CreatorThread-%d] Hello %d!%n", this.getId(), i);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		executor.schedule(new WorkerThread());
	}
}
