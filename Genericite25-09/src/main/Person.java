package main;

public class Person {

	String lastName;
	String firstName;
	int age;
	


	
// getters and setters//
	
	public String getName() {
		return lastName;
	}

	public void setName(String name) {
		this.lastName = name;
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

	
	// constructeur//
	
	public Person(String name, String firstName, int age) {
		super();
		this.lastName = name;
		this.firstName = firstName;
		this.age = age;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
