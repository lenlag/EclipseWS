
public class Vehicule {

	private String name;
	
	Moteur motor = new Moteur ();

	public Vehicule () {
		System.out.println("Vehicule");	
	}

	
	public void startEngine () {
		motor.start();
	}
	
	public void demarrer () {
		System.out.println("On demarre");
	}
	
	}
