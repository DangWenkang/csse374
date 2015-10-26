package problem;

public class AmazonParser implements IParser{

	@Override
	public StringBuffer parse(String line) {
		StringBuffer buffer = new StringBuffer();
		String colonAdded = line.replace("ttl", ":");
		String[] fields = colonAdded.split(",");
		buffer.append(fields[0].trim());
		buffer.append("\n");
		buffer.append(fields[1].trim());
		return buffer;
	}

}
