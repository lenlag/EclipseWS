package main;

public class Observateur2 implements IObservateur {
	
	
	public Observateur2 (Sujet suj) { // on s'abonne au moment de la création d'observateur, càd dans le constructeur
		suj.addObserver(this); // this = moi-même, je m'abbonne
	}

	@Override
	public void actualiser(int temps, int hum) {
		System.out.println("-------temps = " + temps + ", " + "hum = " + hum  + "-------");
		
	}

}
