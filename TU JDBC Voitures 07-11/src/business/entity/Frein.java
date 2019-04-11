package business.entity;

public class Frein {
	
	private long id; // 11 car-s
	private String marque;
	private String modele;
	
	
	public Frein(long id, String marque, String modele) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
	}

	public Frein () { // ça mange pas de pain ))
		
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


	@Override
	public String toString() {
		return "Frein [id=" + id + ", marque=" + marque + ", modele=" + modele + "]";
	}
		

}

