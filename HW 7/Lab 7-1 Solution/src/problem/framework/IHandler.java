package problem.framework;

import problem.model.IData;

public interface IHandler {
	public boolean canHandle(IData d);
	public void handle(IData d);
}
