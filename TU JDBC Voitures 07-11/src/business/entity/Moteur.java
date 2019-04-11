package business.entity;

public class Moteur {
	
	private long id; // car 11 caract�res
	private String marque;
	private String modele;
	private int cylindree;
	
	
	public Moteur(long id, String marque, String modele, int cylindree) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.cylindree = cylindree;
	}
	
	public Moteur() {
		
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


	public int getCylindree() {
		return cylindree;
	}


	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}


	@Override
	public String toString() {
		return "Moteur [id=" + id + ", marque=" + marque + ", modele=" + modele + ", cylindree=" + cylindree + "]";
	}
	
	
}
