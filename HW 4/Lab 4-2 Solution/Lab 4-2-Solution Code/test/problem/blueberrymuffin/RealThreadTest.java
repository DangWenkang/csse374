package problem.blueberrymuffin;

import static org.junit.Assert.*;

import org.junit.Test;

public class RealThreadTest {
	boolean executed;

	@Test
	public final void testRun() throws InterruptedException {
		executed = false;
		RealThread rThread = new RealThread(new VirtualThread() {
			@Override
			public void run() {
				executed = true;
			}
		});
		rThread.start();
		rThread.join();
		assertTrue(executed);
	}
}
