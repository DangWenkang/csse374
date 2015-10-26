package problem;

public class GoogleParser implements IParser{

	@Override
	public StringBuffer parse(String line) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(line.replace('-', ':'));
		return buffer;
	}
	
	
}
