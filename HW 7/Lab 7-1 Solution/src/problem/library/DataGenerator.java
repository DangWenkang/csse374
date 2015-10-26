package problem.library;

import java.util.Iterator;
import java.util.NoSuchElementException;

import problem.model.Data;
import problem.model.IData;

public class DataGenerator implements Iterable<IData> {
	private int low;
	private int high;
	private IFilter filter;
	
	public DataGenerator(int low, int high, IFilter filter) {
		this.low = low;
		this.high = high;
		this.filter = filter;
	}
	
	private IData createData(int i) {
		return new Data(i, "Data - " + i);
	}

	public Iterator<IData> iterator() {
		return new DataIterator();
	}
	
	private class DataIterator implements Iterator<IData> {
		private int index;
		private IData next;
		boolean hasNextChecked;

		public DataIterator() {
			hasNextChecked = false;
			index = low;
		}
		
		@Override
		public boolean hasNext() {
			if(hasNextChecked)
				return next != null;
			
			hasNextChecked = true;
			next = null;
			
			while(index < high) {
				IData d = createData(index++);
				if(filter.include(d)) {
					next = d;
					break;
				}
			}
			
			return next != null;
		}

		@Override
		public IData next() {
			hasNext();
			
			hasNextChecked = false;
			
			if(next != null)
				return next;
			
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
