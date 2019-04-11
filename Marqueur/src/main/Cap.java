package main;

public class Cap {

	private boolean on = true; // if off = false
	
	
	public Cap () {
		
	} // constructeur
	
	public void capOff () {
		on = false;
		System.out.println("The cap is off.");
	}
	
	public void capOn () {
		on = true;
		System.out.println("The cap is on.");
	}
	
} // classe
