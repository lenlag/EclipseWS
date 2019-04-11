
public class Test {

	public static void main(String[] args) {

		Break b = new Break ();
		
		b.startEngine();
		
		Camion c = new Camion ();
		c.demarrer();
		
		Vehicule v = new Camion ();
		v.demarrer ();
	}

}
