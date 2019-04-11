package business.entity;

public class Automobile {

	private long id; // 11 car-s
	private String marque;
	private String modele;
	private Moteur moteur; // FK = on met l'objet
	private Frein frein; // FK = objet
	
	
	public Automobile(long id, String marque, String modele, Moteur moteur, Frein frein) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.moteur = moteur;
		this.frein = frein;
	}
	
	public Automobile () {
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public Moteur getMoteur() {
		return moteur;
	}
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	public Frein getFrein() {
		return frein;
	}
	public void setFrein(Frein frein) {
		this.frein = frein;
	}


	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marque=" + marque + ", modele=" + modele + ", moteur=" + moteur + ", frein="
				+ frein + "]";
	}
		
}
