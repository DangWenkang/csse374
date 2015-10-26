package problem.library;

import static org.junit.Assert.*;

import org.junit.Test;

import problem.model.Data;

public class DataTest {

	@Test
	public final void testCreateData() {
		int expectedId = 1;
		String expectedCntn = "Data - 1"; 
		Data d = new Data(expectedId, expectedCntn);
		
		assertEquals(expectedId, d.getId());
		assertEquals(expectedCntn, d.getContent());
	}

	@Test
	public final void testEqualsAndHashCodeContract() {
		Data d1 = new Data(1, "Hello");
		Data d2 = new Data(1, "Hello");
		
		assertEquals(d1.hashCode(), d2.hashCode());
		assertTrue(d1.equals(d2));
	}
}
