package main;

public class SellableItem extends Item implements ISellableItem {
	 
	double tva;
	
	public SellableItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SellableItem(int id, String nom, double prixHT, double tva) {
		super(id, nom, prixHT);
		this.tva = tva;
		// TODO Auto-generated constructor stub
	}


	
	public double getPrixTTC () {
		double prixTTC = getPrixHT() * (1+tva);
		return prixTTC;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		s= s + " tva=" + tva + " prixTTC= " + getPrixTTC();
		return s;
	}
	
	
	
} // class
