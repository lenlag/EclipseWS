package business.entity;

import java.util.List;

public class Person {
	
	private String lastName;
	private String firstName;
	private int age;
	private long id;
	private List <Animal> animaux; // au lieu de la tab d'association person__animal
	
	
	public Person(String lastName, String firstName, int age, long id, List<Animal> animaux) {

		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
		this.id = id;
		this.animaux = animaux;
	}


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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public List<Animal> getAnimaux() {
		return animaux;
	}


	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}


	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", id=" + id
				+ ", animaux=" + animaux + "]";
	}
	
	
		
	

}
