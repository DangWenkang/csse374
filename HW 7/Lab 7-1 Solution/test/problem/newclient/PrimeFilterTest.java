package problem.newclient;

import static org.junit.Assert.*;

import org.junit.Test;

import problem.library.IFilter;
import problem.model.Data;

public class PrimeFilterTest {

	@Test
	public final void testInclude() {
		int primes[] = {1, 2, 3, 5, 7, 11, 13, 17};
		IFilter filter = new PrimeFilter();
		
		int pIndex = 0;
		for(int i = 0; i <= primes[primes.length - 1]; ++i) {
			if(filter.include(new Data(i, ""))) {
				assertEquals(i, primes[pIndex++]);
			}
		}
	}
}
