package main;

public class Machin implements IBidule {
	
	@Override
	public void display() {
		Singleton.getInstance().display();
	}

	@Override
	public int getValue() {
		return Singleton.getInstance().getValeur();
		
	}

	@Override
	public void setValue (int i) {
		Singleton.getInstance().setValeur(i);
		
	}

}
