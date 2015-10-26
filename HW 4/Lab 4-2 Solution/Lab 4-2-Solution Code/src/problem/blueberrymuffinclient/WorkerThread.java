package problem.blueberrymuffinclient;

import problem.blueberrymuffin.VirtualThread;

public class WorkerThread extends VirtualThread {
	
	@Override
	public void run() {
		for(int i = 1; i <= 3; ++i) {
			System.out.format("[WorkerThread-%d] Hello %d!%n", this.getId(), i);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
