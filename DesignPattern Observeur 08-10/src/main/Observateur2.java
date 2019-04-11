package main;

public class Observateur2 implements IObservateur {
	
	
	public Observateur2 (Sujet suj) { // on s'abonne au moment de la cr�ation d'observateur, c�d dans le constructeur
		suj.addObserver(this); // this = moi-m�me, je m'abbonne
	}

	@Override
	public void actualiser(int temps, int hum) {
		System.out.println("-------temps = " + temps + ", " + "hum = " + hum  + "-------");
		
	}

}
