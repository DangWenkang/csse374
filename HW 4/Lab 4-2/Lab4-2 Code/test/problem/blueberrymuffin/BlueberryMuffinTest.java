package problem.blueberrymuffin;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlueberryMuffinTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
		System.setErr(null);
	}

	@Test
	public void TestSetThread() throws IOException {
		HelloRunnable run0 = new HelloRunnable(0, new HelloReceiver());
		HelloRunnable run1 = new HelloRunnable(1, new HelloReceiver());
		HelloRunnable run2 = new HelloRunnable(2, new HelloReceiver());
		HelloRunnable run3 = new HelloRunnable(3, new HelloReceiver());

		BlueberryMuffin bm = new BlueberryMuffin();

		assertTrue(bm.active.get(0).getRunnable() == null);
		assertTrue(bm.active.get(1).getRunnable() == null);
		assertTrue(bm.active.get(2).getRunnable() == null);
		assertTrue(bm.queue.isEmpty());

		bm.setThread(run0);
		bm.setThread(run1);
		bm.setThread(run2);
		bm.setThread(run3);

		assertEquals(bm.active.get(0).getRunnable(), run0);
		assertEquals(bm.active.get(1).getRunnable(), run1);
		assertEquals(bm.active.get(2).getRunnable(), run2);
		assertFalse(bm.queue.isEmpty());
		assertEquals(bm.queue.peek(), run3);
	}

	@Test
	public void TestThreadWasStarted() throws IOException, InterruptedException {
		HelloRunnable run0 = new HelloRunnable(0, new HelloReceiver());

		BlueberryMuffin bm = new BlueberryMuffin();

		bm.setThread(run0);

		bm.threadWasStarted();
		
		outContent.flush();

		String whatWasPrinted = new String(outContent.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(//
				System.getProperty("line.separator"));

		// since these are static threads, the runnables from the previous test are still assigned to the threads
		assertEquals(20, linesOfOutput.length);
		
		int i;
		
		for (i = 0; i < 5; i++) {
			assertEquals("Hello from thread-0", linesOfOutput[i]);
		}
		
		for (i = 5; i < 10; i++) {
			assertEquals("Hello from thread-0", linesOfOutput[i]);
		}
		
		for (i = 10; i < 15; i++) {
			assertEquals("Hello from thread-1", linesOfOutput[i]);
		}
		
		for (i = 15; i < 20; i++) {
			assertEquals("Hello from thread-2", linesOfOutput[i]);
		}
	}

}
