package main;

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

	@Override
	public String stringToFile() {
		String s = getFirstName() + "," + getLastName() + ","  + getAge() + "," + getAddress().getAdresse() +  "," + getAddress().getZipCode() +"," + getAddress().getCity();
		return s;
	}

	@Override
	public void processStringFromFile(String s) {
	
		String [] a = s.split(",");
		setFirstName(a[0]);
		setLastName(a[1]);
		setAge(Integer.parseInt (a[2]));
		setAddress(new Address ());
		getAddress().setAdresse(a[3]);
		getAddress().setZipCode(Integer.parseInt(a[4]));
		getAddress().setCity(a[5]);

	}



}
