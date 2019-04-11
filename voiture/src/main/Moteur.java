package main;

public class Moteur { // classe
	
	private boolean isStarted = false; // variable pour modeliser la classe : false, car eteint, true si allumé
	
	public Moteur() { // public constr-r explicite
			
	} // constr-r
	
	public void start () {
		isStarted = true;
		System.out.println("Moteur demarre");
	} // method start
	
	
	public void stop () {
		isStarted = false;
		System.out.println("Moteur s'arrête");
	} // methode stop

	
	public void accelerer () {
		System.out.println("On accelère");
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
	
	
	
	
	
} // classe
