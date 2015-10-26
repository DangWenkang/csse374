package problem.library;

import java.util.Iterator;

public interface IFilter {
	public boolean canFilter(IData d);
	public void filter(IData d);
	public void process(int low, int high);
	public abstract IData createData(int i);
	public abstract Iterator createIterator();
}
