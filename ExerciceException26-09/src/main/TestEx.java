package main;

public class TestEx {


	public static void fonctionExc () throws Exception { // normalement ne pas utiliser static! sauf dans les main, mais ici c'est ok
		//throw new Exception ("This function throws a foreseeable Exception"); // si je veux jeter une erreur

		String s = null; 
		s.length();
			
	}


	public static void main(String[] args) {

		try {
			fonctionExc ();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Une erreur");
		} finally {
			System.out.println("Finally");
		} // try

	} // main

} //class
