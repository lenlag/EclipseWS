package main;

import java.util.List;

import junit.framework.TestCase;

public class TestMyClassList extends TestCase {
	
	MyClassList myList = new MyClassList(); // on la déclare au niveau de la classe pour ne pas créer new à chaque test -> pour la mémoire

	public void testMyClassList () throws Exception {

		int i = 1;
		List<String> j = myList.createList(i);
		assertEquals(i, j.size());

		try {
			i = -3;
			j = myList.createList(i);
			assertEquals(i, j.size());
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}

	/* SINON
	 * public void testMyClassList () throws Exception {

		int i = 1;
		List<String> j = myList.createList(i);
		assertEquals(i, j.size());


		i = -3;
		j = myList.createList(i);
		assertNull(j);

	}
	 * 
	 * 
	 */

	public void testMyClassList2 () throws Exception {
		
		// test cas standart
		int i = 1;
		String prefix = "bla";
		List<String> j = myList.createList(i, prefix);

		for (String string : j) {
			String compare = string.substring(0, prefix.length());
			assertEquals(prefix, compare);
		}

		// test case if (nb < 0) 

		try {
		i = -3;
		prefix = "bla";
		j = myList.createList(i, prefix);
		assertNull(j);
		} catch (Exception ex) {
			assertNotNull(ex);
		}

		// test case if prefix = null
		i = 5;
		prefix = null;
		j = myList.createList(i, prefix);		 
		assertFalse(j.contains(prefix));

		// test case if i is negative & prefix = null
		try {
		i = -5;
		prefix = null;
		j = myList.createList(i, prefix);		 
		assertNull(j);
		} catch (Exception ex) {
			assertNotNull(ex);
		}

	}
}
