package main;

public class Phares {

	private boolean switchedOn = false; // si true - alum�s
	
	public Phares () {
		
	}
	
	public void allumerPhares ( ) {
		switchedOn = true;
		System.out.println("Les phares sont allum�s");
	}
	
	public void eteindrePhares () {
		switchedOn = false;
		System.out.println("Les phares sont �teints");
	}
	
	
	
} // class
