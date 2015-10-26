package problem;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class DataStandardizerTest {
	
	private Map<String, IParser> dataFormats = new HashMap<String, IParser>();
	
	private void setDataFormats() {
		this.dataFormats.put("google", new GoogleParser());
		this.dataFormats.put("microsoft", new MicrosoftParser());
		this.dataFormats.put("amazon", new AmazonParser());
	}
	
	@Test
	public final void testParseGoogle() {
		setDataFormats();
		DataStandardizer unifier = new DataStandardizer();
		unifier.setMap(dataFormats);
		unifier.parse("./input_output/io.gogl");
		
		String expected = "google";
		String actual = unifier.getCompany();
		assertEquals(expected, actual);

		StringBuffer buffer = new StringBuffer();
		buffer.append("geo1 : 100\n");
		buffer.append("geo2 : 450\n");
		buffer.append("geo3 : 90\n");
		buffer.append("geo4 : 750");

		expected = buffer.toString().trim();
		actual = unifier.getData().trim();
		assertEquals(expected, actual);
	}

	@Test
	public final void testParseMicrosoft() {
		setDataFormats();
		DataStandardizer unifier = new DataStandardizer();
		unifier.setMap(dataFormats);
		unifier.parse("./input_output/io.ms");
		
		String expected = "microsoft";
		String actual = unifier.getCompany();
		assertEquals(expected, actual);

		StringBuffer buffer = new StringBuffer();
		buffer.append("ms1 : 100\n");
		buffer.append("ms2 : 450\n");
		buffer.append("ms3 : 90\n");
		buffer.append("ms4 : 750");

		expected = buffer.toString().trim();
		actual = unifier.getData().trim();
		assertEquals(expected, actual);
	}
	
	@Test
	public final void testParseAmazon() {
		setDataFormats();
		DataStandardizer unifier = new DataStandardizer();
		unifier.setMap(dataFormats);
		unifier.parse("./input_output/io.aws");
		
		String expected = "amazon";
		String actual = unifier.getCompany();
		assertEquals(expected, actual);

		StringBuffer buffer = new StringBuffer();
		buffer.append("aws1 : 100\n");
		buffer.append("aws2 : 450\n");
		buffer.append("aws3 : 90\n");
		buffer.append("aws4 : 750\n");
		buffer.append("aws5 : 900\n");
		buffer.append("aws6 : 200");

		expected = buffer.toString().trim();
		actual = unifier.getData().trim();
		assertEquals(expected, actual);
	}
}
