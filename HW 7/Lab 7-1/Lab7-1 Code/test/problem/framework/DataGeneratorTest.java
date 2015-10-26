package problem.framework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import problem.model.IData;

public class DataGeneratorTest {

	@Test
	public final void testProcess() {
		final List<IData> handledList = new ArrayList<IData>();
		
		IHandler evenHandler = new IHandler() {
			@Override
			public boolean canHandle(IData d) {
				return d.getId() % 2 == 0;
			}

			@Override
			public void handle(IData d) {
				handledList.add(d);
			}
		};
		DataGenerator generator = new DataGenerator(1, 7, evenHandler);
		generator.process();
		
		assertEquals(handledList.size(), 3);
		for(IData d: handledList) {
			assertTrue(d.getId() %2 == 0);
		}
	}
}
