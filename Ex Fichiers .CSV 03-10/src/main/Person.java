package main;

public class Person {

	String nom;
	String prenom;
	int age;
	String email;

	public Person () {

	}


	public Person(String nom, String prenom, int age, String email) {

		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
	}




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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Person [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
