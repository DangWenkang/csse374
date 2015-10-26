package problem.library;

import java.util.Iterator;
import problem.library.IData;

public class DataGenerator implements Iterable<IData> {
	private IFilter filter;
	
	public DataGenerator(int low, int high, IFilter filter) {
		this.filter = filter;
		filter.process(low, high);
	}

	@Override
	public Iterator iterator() {
		return this.filter.createIterator();
	}

}
