package problem;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataStandardizerIntergrationTest {
	private DataStandardizer standardizer;
	
	@Before
	public void setUp() throws Exception {
		// Setup the parser for the companies that we are supporting
		Map<String, ILineParser> companyToParserMap = new HashMap<String, ILineParser>();
		
		companyToParserMap.put("google", new GoogleLineParser());
		companyToParserMap.put("microsoft", new MicrosoftLineParser());
		companyToParserMap.put("amazon", new AmazonLineParser());
		
		this.standardizer = new DataStandardizer(companyToParserMap);
	}

	@After
	public void tearDown() throws Exception {
		this.standardizer = null;
	}

	@Test
	public final void testGoogleParse() throws Exception {
		// Parse Google
		String filePath = "./input_output/io.gogl";
		this.standardizer.parse(filePath);

		// Test company name parsing logic
		String expected = "google";
		String actual = this.standardizer.getCompany();
		assertEquals(expected, actual);
		
		// Test data parsing logic
		StringBuffer buffer = new StringBuffer();
		buffer = new StringBuffer();
		buffer.append("geo1 : 100\n");
		buffer.append("geo2 : 450\n");
		buffer.append("geo3 : 90\n");
		buffer.append("geo4 : 750");

		expected = buffer.toString().trim();
		actual = this.standardizer.getData().trim();

		assertEquals(expected, actual);
	}

	@Test
	public final void testMicrosoftParse() throws Exception {
		// Parse Microsoft
		String filePath = "./input_output/io.ms";
		this.standardizer.parse(filePath);

		// Test company name parsing logic
		String expected = "microsoft";
		String actual = this.standardizer.getCompany();
		assertEquals(expected, actual);
		
		// Test data parsing logic
		StringBuffer buffer = new StringBuffer();
		buffer.append("ms1 : 100\n");
		buffer.append("ms2 : 450\n");
		buffer.append("ms3 : 90\n");
		buffer.append("ms4 : 750");


		expected = buffer.toString().trim();
		actual = this.standardizer.getData().trim();

		assertEquals(expected, actual);
	}
	
	@Test
	public final void testAmazonParse() throws Exception {
		// Parse Microsoft
		String filePath = "./input_output/io.aws";
		this.standardizer.parse(filePath);

		// Test company name parsing logic
		String expected = "amazon";
		String actual = this.standardizer.getCompany();
		assertEquals(expected, actual);
		
		// Test data parsing logic
		StringBuffer buffer = new StringBuffer();
		buffer.append("aws1 : 100\n");
		buffer.append("aws2 : 450\n");
		buffer.append("aws3 : 90\n");
		buffer.append("aws4 : 750\n");
		buffer.append("aws5 : 900\n");
		buffer.append("aws6 : 200");


		expected = buffer.toString().trim();
		actual = this.standardizer.getData().trim();

		assertEquals(expected, actual);
	}	

}
