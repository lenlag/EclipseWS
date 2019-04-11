package main;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestMyCount extends TestCase {
	MyCount mc = new MyCount();
	int a = 7;
	int b = -5;
	String x = "7";

	public void test_count () throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		assertEquals(mc.count(a).size(), 7);

		try {
			assertEquals(mc.count(b).size(), 5);
		} catch (Exception ex) {
			assertNotNull(ex); // on attrape erreur
		}
	}

	public void test_cast () {

		assertEquals(mc.cast(a), x);
	}

	public void test_uncast () {
		assertEquals(mc.uncast(x), a);

	}

}
