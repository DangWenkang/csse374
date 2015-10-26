package problem.blueberrymuffinclient;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import problem.blueberrymuffin.MuffinThreadExecutor;

public class MuffinAppIntegrationTest {
	ByteArrayOutputStream bOut;
	PrintStream temp;
	
	@Before
	public final void setUp() {
		// Route System.out to print to the our byte stream
		bOut = new ByteArrayOutputStream();
		temp = System.out;
		System.setOut(new PrintStream(bOut, true));
	}
	
	@After
	public final void tearDown() {
		// Restore Sytem.out
		System.setOut(temp);
	}

	@Test
	public final void integrationTest() {
		MuffinThreadExecutor executor = MuffinThreadExecutor.getInstance();
		for(int i = 0; i < 3; ++i) {
			executor.schedule(new WorkerThread());
			executor.schedule(new CreatorThread());
		}
		executor.start();
		
		
		String output = bOut.toString();
		String[] lines = output.split("\n");
		boolean interLeaved = false;
		for(int i = 0; i < lines.length - 2; ++i) {
			String[] fields1 = lines[i].split(" ");
			String[] fields2 = lines[i+1].split(" ");
			String[] fields3 = lines[i+2].split(" ");

			if(fields1[0].equals(fields2[0]))
				continue;
			
			if(fields2[0].equals(fields3[0]))
				continue;
			
			if(fields1[0].equals(fields3[0]))
				continue;
			
			interLeaved = true;
			break;
		}
		
		// There are at least three threads that interleaved
		assertTrue(interLeaved);
	}
}
