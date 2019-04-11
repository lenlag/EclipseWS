package main;

public class Person {

	private String nom;
	private String prenom;
	protected int age;


	public Person (String nom, String prenom, int age) {
		super ();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	} // constructor

	public Person () {

	} // implicit constructor


	public String toString () {
		return nom+ " " + prenom + "(" + age + ")";
	}

	public void grandir () {
		System.out.println(nom + " " + prenom + " grandit");
		age ++;	
		System.out.println("Age : " + age);
	}
	// Setters and getters // 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



} // class
