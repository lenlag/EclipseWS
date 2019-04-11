
public class Camion extends Vehicule {

	private String type;

	public Camion () {
		super ();
		this.type = type;
		System.out.println("Camion");	
	}

	@Override
	public void demarrer() {
		// TODO Auto-generated method stub
		super.demarrer();
		System.out.println("Un truc en plus");
	}
	
}
