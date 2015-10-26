package problem.newclient;

import problem.library.IFilter;
import problem.model.IData;

public class PrimeFilter implements IFilter {

	public PrimeFilter() {}

	@Override
	public boolean include(IData d) {
		int num = d.getId();

		if (num % 2 == 0 && num != 2) 
			return false;

		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0) 
				return false;

		return true;
	}
}
