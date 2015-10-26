package problem.library;

import problem.model.IData;

public interface IFilter {
	public boolean include(IData d);
}
