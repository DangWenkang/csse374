package problem;

public class MicrosoftLineParser implements ILineParser {

	@Override
	public String parse(String line) {
		return line.replace(",", " : ");
	}
}
