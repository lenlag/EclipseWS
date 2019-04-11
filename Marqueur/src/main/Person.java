package main;

public class Person {
	
	private String name; // variables
		
	
	public Person (String name) {
		this.name  = name;
	} // constructeur
	
	
	public void jecris (Crayon crayon) {
		crayon.enleverCapuchon();
		crayon.ecrire();
		System.out.println();
		System.out.println(name + " écrit avec un crayon au tableau.");
	}
	
} // class
