package ui.model;

public class Voiture {

	private String modele;
	private String marque;
	
	
	public Voiture (String modele, String marque) {
		this.modele = modele;
		this.marque = marque;
	}


	@Override
	public String toString() {
		return modele + " (" + marque + ")";
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	
	
	
}
