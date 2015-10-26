package problem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoogleLineParserTest {
	private GoogleLineParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new GoogleLineParser();
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}

	@Test
	public final void testParse() {
		String input = "geo1 - 100";
		String expected = "geo1 : 100";
		String actual = parser.parse(input);
		
		assertEquals(expected, actual);
	}
}
