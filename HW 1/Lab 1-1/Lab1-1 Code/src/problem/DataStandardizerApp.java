package problem;

import java.util.HashMap;
import java.util.Map;

public class DataStandardizerApp {

	private static Map<String, IParser> dataFormats = new HashMap<String, IParser>();
	
	public static void main(String[] args) {
		setUpMap();
		
		DataStandardizer unifier = new DataStandardizer();
		unifier.setMap(DataStandardizerApp.dataFormats);
		unifier.execute();
	}
	
	private static void setUpMap() {
		DataStandardizerApp.dataFormats.put("google", new GoogleParser());
		DataStandardizerApp.dataFormats.put("microsoft", new MicrosoftParser());
		DataStandardizerApp.dataFormats.put("amazon", new AmazonParser());
	}

}
