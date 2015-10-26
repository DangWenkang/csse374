package problem.blueberrymuffin;

import static org.junit.Assert.*;

import org.junit.Test;

import problem.blueberrymuffin.VirtualThread;
import problem.blueberrymuffinclient.CreatorThread;
import problem.blueberrymuffinclient.WorkerThread;

public class VirtualThreadTest {
	@Test
	public final void testID() {
		VirtualThread vThread = new WorkerThread();
		int expected = vThread.getId() + 1;
		
		vThread = new CreatorThread();
		int actual = vThread.getId();
		assertEquals(expected, actual);
	}
}
