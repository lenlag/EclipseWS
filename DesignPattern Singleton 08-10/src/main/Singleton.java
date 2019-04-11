package main;

public class Singleton {
	
	private int valeur;
	
	private static Singleton instance = null;

	private Singleton () {

	}

	public static Singleton getInstance () {
		if (instance == null) {
			instance = new Singleton ();
		}
		return instance;
	}

	public void display () {
		System.out.println("Je suis la f-on display de singleton");
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}


	
	
}
