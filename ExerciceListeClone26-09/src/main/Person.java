package main;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	
	// variables
		String lastName;
		String firstName;
		int age;
		String country;
		
		//  constructeur
		public Person(String lastName, String firstName, int age, String country) {
			this.lastName = lastName;
			this.firstName = firstName;
			this.age = age;
			this.country = country;
		}
		
		public Person () {
		} // constructeur vide explicite
		
		
		
	@Override
		public String toString() {
			return "Person [lastname=" + lastName + ", firstName=" + firstName + ", age=" + age + ", country=" + country
					+ "]";
		}



	public Person clone () { // methode objet = Person, nom = clone (miniscule)

		Person p = new Person (); // nouv objet , en utilisant le constructeur vide
		p.setAge(this.age);// remplit nouveau objet avec this.xxx
		p.setCountry(this.country);
		p.setFirstName(this.firstName);
		p.setLastName(this.lastName);
		
		return  p; // on retourne l'objet de Person
	} // methode clone

	
	// setters & getters
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

} // class 
