package main;

public class Voiture {

	private String couleur; // variable à declarer avant la méthode

	Moteur moteur = new Moteur (); // aggregation
	Frein frein = new Frein ();
	Phares headlights = new Phares ();
	
	public Voiture (String _couleur) {
		couleur = _couleur;
		//Moteur moteur = new Moteur (); // composition
		//Frein frein = new Frein ();
	} // constructeur que l'on a crée
	
	
	public Voiture () {
		System.out.println ();
	} // constructeur par defaut explicite

		
	public void demarrer () {	

		if (moteur.isStarted() == true) {
			System.out.println("Attention! Le moteur est déjà allumé!");
		}
		else {
			moteur.start();
		}
	} // méthode demarrer	
	

	public void avance () {
		if(moteur.isStarted() == true && frein.isEtat() == true) {
			frein.relache();
			moteur.accelerer();
		} else if (moteur.isStarted() == true && frein.isEtat() == false) {
			moteur.accelerer();
			System.out.println("La voiture avance");	
		} else {
			System.out.println("Attention! La voiture ne peut pas avancer");
		}
	} // methode avance
	
	
	public void stop () {
		
		
		if(frein.isEtat() == false) {
			frein.enclenche();
			moteur.stop();
		} else if( frein.isEtat() == true) {
			System.out.println("La voiture est déjà arretée");
		}
	
	} // methode avance
	
	
	public void headlightsON () {
		headlights.allumerPhares();
	}
	
	public void headlightsOFF () {
		headlights.eteindrePhares();
	}
	
	/*          Getters et Setters         */
	public String getCouleur() {
		return couleur;
	} // Accesseur getter


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	} // Accesseur setter

	public void accelere () {
		System.out.println("La voiture accelere");
	} // methode accelere

} // public class Voiture

