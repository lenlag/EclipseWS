package main;

import junit.framework.TestCase;

public class TestMathe extends TestCase {

	public void testMathe () {
		int i = 3;
		int j = new Mathe().square(i);
		assertEquals(j, i*i);
	}
}
