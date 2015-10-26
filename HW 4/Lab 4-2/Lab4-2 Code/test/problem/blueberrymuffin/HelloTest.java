package problem.blueberrymuffin;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestSayHello() throws IOException {
		HelloReceiver hr = new HelloReceiver();
		
		assertEquals("Hello", hr.sayHello());
	}

}
