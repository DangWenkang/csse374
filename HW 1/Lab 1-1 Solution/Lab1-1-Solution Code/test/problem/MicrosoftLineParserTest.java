package problem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MicrosoftLineParserTest {
	private MicrosoftLineParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new MicrosoftLineParser();
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}

	@Test
	public final void testParse() {
		String input = "ms1,100";
		String expected = "ms1 : 100";
		String actual = parser.parse(input);
		
		assertEquals(expected, actual);
	}
}
