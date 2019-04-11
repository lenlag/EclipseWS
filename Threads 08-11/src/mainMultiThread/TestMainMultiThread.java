package mainMultiThread;

public class TestMainMultiThread  {

	public static void main(String[] args) throws Exception {
		MultiThread mthr = new MultiThread ();
		
		mthr.main();
		System.out.println("Fin du programme"); // ça s'affiche en dernier, car il y a une boucle qui s'execute d'abord
	}

}
