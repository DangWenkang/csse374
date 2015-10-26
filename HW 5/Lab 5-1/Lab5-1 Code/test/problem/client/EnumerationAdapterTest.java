package problem.client;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EnumerationAdapterTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestNextElement() {
		// string enumeration
		ArrayList<String> strL = new ArrayList<String>();
		strL.add("One");
		strL.add("Two");
		strL.add("Three");
		strL.add("Four");
		
		EnumerationAdapter<String> strAdptr = new EnumerationAdapter<String>(strL.iterator());
		
		assertEquals("One", strAdptr.nextElement());
		assertEquals("Two", strAdptr.nextElement());
		assertEquals("Three", strAdptr.nextElement());
		assertEquals("Four", strAdptr.nextElement());
		
		// int enumeration
		ArrayList<Integer> intL = new ArrayList<Integer>();
		intL.add(1);
		intL.add(2);
		intL.add(3);
		intL.add(4);
		
		EnumerationAdapter<Integer> intAdptr = new EnumerationAdapter<Integer>(intL.iterator());

		assertEquals((int)1, (int)intAdptr.nextElement());
		assertEquals((int)2, (int)intAdptr.nextElement());
		assertEquals((int)3, (int)intAdptr.nextElement());
		assertEquals((int)4, (int)intAdptr.nextElement());
	}
	
	@Test
	public void TestHasMoreElements() {
		ArrayList<String> aL = new ArrayList<String>();
		aL.add("One");
		aL.add("Two");
		aL.add("Three");
		aL.add("Four");
		
		EnumerationAdapter<String> adptr = new EnumerationAdapter<String>(aL.iterator());

		for(int i = 0; i < 4; i++) {
			assertTrue(adptr.hasMoreElements());
			adptr.nextElement();
		}
		
		assertFalse(adptr.hasMoreElements());
	}
	
}
