package problem.blueberrymuffinclient;

import problem.blueberrymuffin.MuffinThreadExecutor;

public class MuffinApp {
	public static void main(String[] args) {
		MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		for(int i = 0; i < 3; ++i) {
			executor.schedule(new WorkerThread());
			executor.schedule(new CreatorThread());
		}
		executor.start();
	}
}
