package main;

import junit.framework.TestCase;

public class TestStringConcat extends TestCase {

	public void testStringConcat () {
		
		String a = "abc";
		String b = "def";
		String c = new StringConcat().append(a, b);
		assertEquals(c, a+b);

		try {
		a = null;
		b = "def";
		c = new StringConcat().append(a, b);
		assertEquals(c, a+b);
		assertNotNull(null);
		
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		
		
		try {
		a = "abc";
		b = null;
		c = new StringConcat().append(a, b);
		assertEquals(c, a+b);
		assertNotNull(null);
		
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		
		try {
		a = null;
		b = null;
		c = new StringConcat().append(a, b);
		assertEquals(c, a+b);
		assertNotNull(null);
		
		} catch (Exception ex) {
			assertNotNull(ex);
		}
		
		
	}
	
	
	
	
}
