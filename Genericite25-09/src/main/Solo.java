package main;

public class Solo <T, X> {

	private T valeur;
	private X value;
	
	
	public Solo(T valeur) {
		this.valeur = valeur;
	} // constr-r 1

	public Solo(T valeur, X value) {
		this.valeur = valeur;
		this.value = value;
	} //constr-r2
	
	
	public T getValeur() {
		return valeur; // getter
	}



	public X getValue() {
		return value;
	}



	public void setValue(X value) {
		this.value = value;
	}



	public void setValeur(T valeur) {
		this.valeur = valeur; // setter
	}

	
	public static void main(String[] args) {


	}

}
