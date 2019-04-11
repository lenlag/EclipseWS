package main;

public class Item {

	private int id;
	private String nom;
	private double prixHT;
	
	public Item(int id, String nom, double prixHT) {
		this.id = id;		
		this.nom = nom;
		this.prixHT = prixHT;
	} // constr-r avec des paramètres

	public Item() {
		super();
	} // constr-r par defaut explicite
	
	
	
	// Getters and setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
	
	
 // Getters for id - uniquement Getter, pas de Setter, car id est super privé

	public int getId() {
		return id;
	}
	


	@Override
	public String toString() {
		return "id= " + id + " nom=" + nom + " prixHT=" + prixHT ;
	}
	

	
	
	
	
	
	
} // class
