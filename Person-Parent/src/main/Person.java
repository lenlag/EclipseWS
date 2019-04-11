package main;

public class Person {

	private String firstName;
	private String lastName;
	protected int age;
	
	
	public Person (String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
	} // constructeur
	
	public Person () {
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

		/* public void grandir () {
	 System.out.println("La personne " + firstName + " " + lastName + " grandit");
		for (age = age; age < 19; age ++) {
			System.out.print(age + " ");
		} // for
		if (age > 17) {
			System.out.println();
			System.out.println("La personne a atteint l'âge pour accoucher");
		} else {
			System.out.println("La personne ne peut pas accoucher");
		}
	} // methode grandir */
	
	public void grandir ();
		
		
} // classe
