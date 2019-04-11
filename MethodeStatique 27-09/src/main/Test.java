package main;


public class Test {

	private int valeur; // si statique, impossible de set valeur pour les objets test

	
	// getters and setters
	public int getValeur() { // si statique , impossible pour la variabnle non - statique
		return valeur;
	}

	// f-on STATIQUE possible si elle ne referencie aucun attribut (variable) de la classse, ex f-on utilitaire (Math. etc)

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public static void affiche () { // fonction STATIC !!!
		System.out.println("Bonjour");
	}
	public static int square (int a) { // ici, f-on utilitaire static
		return a*a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sq = Test.square(10); // CLASS.méthode - pour les fonctions statiques!!!
		
		// Test t =new Test(); => si PAS STATIC
		//t.affiche(); => si PAS STATIC
		affiche();// appelle fonction STATIC!!!
	}
	
	
}
