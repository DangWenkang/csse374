package problem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmazonLineParserTest {
	private AmazonLineParser parser;

	@Before
	public void setUp() throws Exception {
		parser = new AmazonLineParser();
	}

	@After
	public void tearDown() throws Exception {
		parser = null;
	}

	@Test
	public final void testParse() {
		String input = "aws1 ttl 100, aws2 ttl 450";
		String expected = "aws1 : 100"+ "\n" + "aws2 : 450";
		String actual = parser.parse(input);
		
		assertEquals(expected, actual);
	}
}
