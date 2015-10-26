package problem.newclient;

import java.util.Iterator;
import java.util.List;

public class PrimeFilterIterator implements Iterator {
	
	private List list;
	private int position;
	
	public PrimeFilterIterator(List data) {
		this.list = data;
		this.position = 0;
	}

	@Override
	public boolean hasNext() {
		if (position >= list.size() || list.get(position) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Object next() {
		Object data = list.get(position);
		position++;
		return data;
	}

	@Override
	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (list.get(position-1) != null) {
			for (int i = position-1; i < (list.size()-1); i++) {
				Object d = list.get(i+1);
				list.set(i, d);
			}
			list.remove(list.size() - 1);
		}
	}


}
