package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * The Parser class reformats the data in a given text file.
 * 
 * @author Nathan Cheung
 */

public interface IParser {
	
	public StringBuffer parse(String line);
	
}