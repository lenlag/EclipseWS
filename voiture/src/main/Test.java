package main;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Voiture v = new Voiture ("blanche");// on cree l'objet v à l'aide du constructeur que l'on a crée avec String _couleur
	//	v.demarrer (); // appel methode demarrer
	//	v.avance ();

	//	System.out.println(v.getCouleur());
	//	v.setCouleur("Noir");
	//	System.out.println(v.getCouleur());
		
		v.headlightsON();
		System.out.println();
		
		v.demarrer();
		
		System.out.println();
		
		
		v.avance();
		
		System.out.println();
		v.stop();
		
		v.headlightsOFF();
	
		
	} // f-on void main

} // class Test
