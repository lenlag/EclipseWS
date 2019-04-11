package main;

import junit.framework.TestCase;

public class TestMyMath extends TestCase {

	MyMath mm = new MyMath ();
	double k = -99.5;
	double r = 125.33;
	int a = 555;
	int b = -555;


	public void test_abs () {
		double p = mm.abs(k);
		assertEquals (Math.abs(k), p);


		p = mm.abs(r);
		assertEquals (Math.abs(r),p);
	}


	public void test_sqrt () throws Exception {
		double p = mm.sqrt(a);
		assertEquals(Math.sqrt(a), p);

		try {
			p = mm.sqrt(b);
			assertEquals (Math.sqrt(b), p);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}


	public void test_min () {
		int x = mm.min(a,b);
		assertEquals(Math.min(a, b), x);
	}

	public void test_random () {
		double x = mm.random(a);
		assert ((Math.random()*a<555) || (x<555));
		
	}

}
