package problem;

public class HtmlHandler implements DirectoryEventHandler {
	
	private String command;
	private String fileName;
	private String behavior;
	
	public HtmlHandler(String command, String file) {
		this.command = command;
		this.fileName = file;
		this.behavior = "read";
	}

	public HtmlHandler(String command, String file, String behavior) {
		this.command = command;
		this.fileName = file;
		this.behavior = behavior;
	}
	
	@Override
	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	
	@Override
	public void getBehavior(String behavior) {
		this.behavior = behavior;
	}

	@Override
	public void setFileName(String file) {
		this.fileName = file;
	}

}
