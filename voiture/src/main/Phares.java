package main;

public class Phares {

	private boolean switchedOn = false; // si true - alumés
	
	public Phares () {
		
	}
	
	public void allumerPhares ( ) {
		switchedOn = true;
		System.out.println("Les phares sont allumés");
	}
	
	public void eteindrePhares () {
		switchedOn = false;
		System.out.println("Les phares sont éteints");
	}
	
	
	
} // class
