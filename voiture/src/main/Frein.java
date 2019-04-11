package main;

public class Frein { // class


	private boolean etat = true;  // variable  attribut  --> false si relaché, true si enclenché
		
	
	public Frein (boolean _etat) { // _etat argument/parametre de la methode
	etat = _etat;

	} // constr-r
	
	public Frein () {
		
	} // constr-r explicite
	
	public void enclenche () {
		etat = true;
		System.out.println("On relache le frein");
	} // methode start
	
	
	public void relache () {
		etat = false;
		System.out.println("Le frein est relaché");
	} // methode relaché

	
	
	
	
	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	
} // class
