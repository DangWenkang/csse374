package problem.newclient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import problem.library.Data;
import problem.library.IFilter;
import problem.library.IData;

public class PrimeFilter implements IFilter {
	
	private List data = new ArrayList();

	@Override
	public boolean canFilter(IData d) {
		int num = d.getId();
		if (num % 2 == 0)  {
			return false;
		}
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) {
				return false;
			}
		return true;
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
		return new PrimeFilterIterator(this.data);
	}

	@Override
	public void filter(IData d) {
		this.data.add(d);
	}

}
