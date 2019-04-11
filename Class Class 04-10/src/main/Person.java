package main;

public class Person {
	
	public Person () {
		System.out.println("Je suis le constructeur de la classe Person");
	}

	public static void main(String[] args) throws Exception {
		
		/*Person p = new Person ();
		Class <?> klass = p.getClass(); // Classe associé à personne.class (personne compilé) f-on getClass est au niveau d'Object
		System.out.println(klass.getName());
		*/
		Class <?> metaclasse = Class.forName("main.Person");
		System.out.println(metaclasse.getName());

		//p = (Person)klass.newInstance ();  // soit on caste, soit
		Object o = metaclasse.newInstance(); // => crée l'instance de Personne
	}

}
