package problem.library;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import problem.model.IData;

public class DataGeneratorTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();	

	DataGenerator generator;

	@Before
	public final void setUp() {
		IFilter evenFilter = new IFilter() {
			@Override
			public boolean include(IData d) {
				return d.getId() % 2 == 0;
			}
		};
		
		generator = new DataGenerator(1, 7, evenFilter);
	}
	
	@After
	public final void tearDown() {
		generator = null;
	}

	@Test
	public final void testEnhancedLoop() {
		int count = 0;

		// Test the data
		for(IData d: generator) {
			assertTrue(d.getId() % 2 == 0);
			++count;
		}
		
		// Test size
		assertEquals(count, 3);
	}

	@Test
	public final void testIteratorNext() {
		Iterator<IData> iterator = generator.iterator();
		
		// Iterate without next
		for(int i = 0; i < 3; ++i) {
			IData d = iterator.next();
			assertTrue(d.getId() %2 == 0);
		}
		
		// We should now get NoSuchElementException when we call next
		exception.expect(NoSuchElementException.class);
		iterator.next();
	}

	@Test
	public final void testIteratorHasNextAndNext() {
		Iterator<IData> iterator = generator.iterator();
		
		while(iterator.hasNext()) {
			IData d = iterator.next();
			assertTrue(d.getId() %2 == 0);
		}
	}
}
