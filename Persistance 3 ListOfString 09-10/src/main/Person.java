package main;

import java.util.ArrayList;
import java.util.List;

public class Person implements IObject {

	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	int id;



	public Person(String firstName, String lastName, int age, Address address) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}

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


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String toString () {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", adresse=" + address
				+ "]";
	}



	/*@Override
	public void processStringFromFile(String s) {
	
		String [] a = s.split(",");
		setFirstName(a[0]);
		setLastName(a[1]);
		setAge(Integer.parseInt (a[2]));
		setAddress(new Address ());
		getAddress().setAdresse(a[3]);
		getAddress().setZipCode(Integer.parseInt(a[4]));
		getAddress().setCity(a[5]);

	} */

	@Override
	public List<String> stringToFile() {
		List<String> maliste = new ArrayList<String>();
		maliste.add(firstName);
		maliste.add(lastName);
		maliste.add(""+age);
		maliste.add(address.getAdresse());
		maliste.add(""+address.getZipCode());
		maliste.add(""+address.getCity());
		return maliste;
	}


	@Override
	public void processStringFromFile(List<String> s) {
		List<String> liste = new ArrayList<String>();
		
		setFirstName(a[0]);
		setLastName(a[1]);
		setAge(Integer.parseInt (a[2]));
		setAddress(new Address ());
		getAddress().setAdresse(a[3]);
		getAddress().setZipCode(Integer.parseInt(a[4]));
		getAddress().setCity(a[5]);
		
	}



}
