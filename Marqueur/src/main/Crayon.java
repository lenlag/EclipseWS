package main;

public class Crayon {
	
	private String couleur;
	
	Cap cap = new Cap ();
	
	
	public Crayon () { // constructeur	
	}	
		
	
	public void enleverCapuchon () {
		cap.capOff();
	}
	
	public void ecrire () {	
		System.out.print("Le crayon peut écrire.");
	}
	

} // class
