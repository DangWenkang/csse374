package problem.newclient;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import problem.library.Data;
import problem.library.DataGenerator;
import problem.library.IData;
import problem.library.IFilter;

public class DataGeneratorTest {

	@Test
	public final void testProcess() {
		final List<IData> filteredList = new ArrayList<IData>();
		
		IFilter evenFilter = new IFilter() {
			
			static final int MAX_EVENS = 6;
			int numberOfEntries = 0;
			IData[] data = new IData[MAX_EVENS];
			
			@Override
			public boolean canFilter(IData d) {
				return d.getId() % 2 == 0;
			}

			@Override
			public void filter(IData d) {
				filteredList.add(d);
				data[numberOfEntries] = d;
				numberOfEntries++;
			}

			@Override
			public void process(int low, int high) {
				for(int i = low; i < high; ++i) {
					IData d = createData(i);
					if(canFilter(d)) {
						filter(d);
					}
				}
			}

			@Override
			public IData createData(int i) {
				return new Data(i, "Data - " + i);
			}

			@Override
			public Iterator createIterator() {
				return new EvenFilterIterator(this.data);
			}
		};
		DataGenerator generator = new DataGenerator(1, 13, evenFilter);
		
		assertEquals(filteredList.size(), 6);
		for(IData d: filteredList) {
			assertTrue(d.getId() %2 == 0);
		}
	}
}

class EvenFilterIterator implements Iterator {

	IData[] list;
	int position;
 
	public EvenFilterIterator(IData[] list) {
		this.list = list;
		this.position = 0;
	}
	
	@Override
	public Object next() {
		IData data = list[position];
		position++;
		return data;
	}
 
	@Override
	public boolean hasNext() {
		if (position >= list.length || list[position] == null) {
			return false;
		} else {
			return true;
		}
	}
  
	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (list[position-1] != null) {
			for (int i = position-1; i < (list.length-1); i++) {
				list[i] = list[i+1];
			}
			list[list.length-1] = null;
		}
	}
	
}