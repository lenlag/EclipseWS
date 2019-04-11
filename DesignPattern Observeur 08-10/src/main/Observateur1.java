package main;

public class Observateur1 implements IObservateur {
	
	
	public Observateur1 (Sujet suj) { // on s'abonne au moment de la création d'observateur, càd dans le constructeur
		suj.addObserver(this);
	}

	@Override
	public void actualiser(int temps, int hum) {
		System.out.println("*******temps = " + temps + ", " + "hum = " + hum + "*******");
		
	}

}
