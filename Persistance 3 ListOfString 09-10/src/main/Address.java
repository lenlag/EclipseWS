package main;

public class Address {
	
	private String adresse;
	private int zipCode;
	private String city;
	
	
	public Address(String adresse, int zipCode, String city) { // constructeur 1
		this.adresse = adresse;
		this.zipCode = zipCode;
		this.city = city;
	}
	
	public Address () {
		
	}
	
	
	public String toString () {
		return "Address [adresse=" + adresse + ", zipCode=" + zipCode + ", city=" + city + "]";
	}





	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getZipCode() {
		return zipCode;
	}


	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	

}
