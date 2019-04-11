package main;

import junit.framework.TestCase;

public class Test_Ex1 extends TestCase {
	

	TU1_Ex1 ex1 = new TU1_Ex1();
	String a = "ccc";
	String b = "";


	public void test_purge () { // throws Exception ? -> non, si pas d'erreur (x en rouge)
		ex1.purge();
		String z = ex1.getMyString();
		assertEquals(b,z);
		

	}


	public void test_append () throws Exception {
		ex1.append(a); 				 // test MyString + chaine
		String z = ex1.getMyString();
		assertEquals(b+a, z);
		
			
		ex1.purge();	// on vide la chaine pour la reinitialiser à l'etat initial	
		ex1.append(b);
		z = ex1.getMyString();		// test MyString + chaine vide
		assertEquals(b,z);
		
		ex1.purge();
		z = ex1.getMyString();		// test MyString + MyString
		ex1.append(z);
		String g = ex1.getMyString();
		assertEquals (b, g);
		
	}

	public void test_decr () { // faire append !
		try {
			ex1.decrement();
			String z = ex1.getMyString();
			assertEquals(z.length(), b.length()-1);
		} catch (Exception ex) {
			assertNotNull(ex);
		}
	}

}
