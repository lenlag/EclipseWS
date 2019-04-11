package main;

public class Parent extends Person { // uses implicit constructor

	private Parent [] enfants = new Parent [10];
	int nbEnfants = 0;


	public Parent() {
		super();

	} // constructeur de la classe mère

	public Parent(String nom, String prenom, int age) {
		super(nom, prenom, age);

	} // constructeur de la classe mère

	public void accoucher () {
		if (getAge() > 17) {
			Parent enfant = new Parent ("penom-enfant-" + (nbEnfants+1), "nom-enfant-" + (nbEnfants+1),0);
			enfants [nbEnfants++] = enfant;
			System.out.println("Enfant créé");
		}
	} // méthode accoucher

	public String toString () {
		String s = super.toString() + "\r\n";
		if (nbEnfants > 0) { // pour avoir l'en-tête
			s+= "Enfants : \r\n";
			for (int i = 0; i <nbEnfants; i ++) {
				s += enfants[i].toString();	
			} // for
			s+="\r\n";
		} // if
		return s;
	} // méthode toString


	public Parent getEnfants(int i) {
		return enfants [i];
	}


	// for (i=0; i < 2; i++)




} // class
