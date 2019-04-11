package main;

public class Person_old{
	
	public Person_old () {
		System.out.println("Je suis le constructeur de la classe Person");
	}

	public static void main(String[] args) throws Exception {
		
		Person_old pOld = new Person_old ();
		Class <?> klass = pOld.getClass(); // Classe associé à personne.class (personne compilé) f-on getClass est au niveau d'Object
		System.out.println(klass.getName());
		
		Class <?> klass2 = Class.forName("main.Person_old");
		System.out.println(klass2.getName());

		Object p = (Person_old)klass.newInstance ();
		//Object o = (Person_old)klass2.newInstance(); // => crée l'instance de Personne
	}

}
