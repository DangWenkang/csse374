package problem.blueberrymuffin;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloRunnableTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void TestRunPrintsOutFiveTimes() throws IOException {
		HelloRunnable run = new HelloRunnable(0, new HelloReceiver());

		run.run();
		outContent.flush();

		String whatWasPrinted = new String(outContent.toByteArray());
		String[] linesOfOutput = whatWasPrinted.split(//
				System.getProperty("line.separator"));

		assertEquals(5, linesOfOutput.length);
		assertEquals("Hello from thread-0", linesOfOutput[0]);
	}

	@Test
	public void TestIsFinished() {
		HelloRunnable run = new HelloRunnable(0, new HelloReceiver());
		assertFalse(run.isFinished());

		run.run();
		assertTrue(run.isFinished());
	}

}
