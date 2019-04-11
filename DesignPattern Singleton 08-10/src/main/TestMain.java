package main;

public class TestMain {

	public static void main(String[] args) {
		Machin m1 = new Machin ();  // on instancie 2 objets de la classe LAchin
		Machin m2 = new Machin ();
		System.out.println(m1.equals(m2)); // check  si m1 n'est pas identique à m2
		
		Singleton s1 = Singleton.getInstance(); // on recupère 2 variables de Singleton
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1.equals(s2)); // check si les objets de Singleton sont identiques
		
		m1.display();
		
		m1.setValue(10);
		m2.setValue(20);
		
		System.out.println(m2.getValue());
		System.out.println(s1.getValeur());
		System.out.println(s2.getValeur());
	}

}
