package main;

public class Person {

	
	// variables
	String lastname;
	String firstName;
	int age;
	String country;
	
	//  constructeur
	public Person(String lastname, String firstName, int age, String country) {
		this.lastname = lastname;
		this.firstName = firstName;
		this.age = age;
		this.country = country;
	}

	
	//getters & setters
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	//f-on to String
	@Override
	public String toString() {
		return "Person [lastname=" + lastname + ", firstName=" + firstName + ", age=" + age + ", country=" + country
				+ "]";
	}
	
	
	
	
	
}
