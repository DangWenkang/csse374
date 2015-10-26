package problem.question7;

public class Clock implements Runnable {

	final long startTime = 100;
	long remaining;
	static boolean done;

	public Clock() {
		remaining = startTime;
		done = false;
	}

	public void run() {

		while (remaining > 0) {
			remaining = startTime - (System.currentTimeMillis() / 1000);
			System.out.println("Time remaining: " + remaining + " seconds.\n");
		}
		
		System.out.println("You have run out of time. \n");
		done = true;
	}

}
