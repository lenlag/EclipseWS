package mainMultiThread;

public class MultiThread {
	boolean stopMain = false;
	
	public void afficher () {
		System.out.println("Debut du thread secondaire");
		try {
			Thread.sleep(10000);
		} catch (Exception x) {
			x.printStackTrace();
		}
		stopMain = true;
		System.out.println("Fin du thread secondaire");
	}
	public void main(){

		MyThread mt = new MyThread (this); // this = objet lui-même => voir dans le MyThread
		mt.start();
		for (int i=1; ; i++) { // infinite loop, commence à 0 sec et fait une boucle
			if (stopMain) {
				break;
			}
			try {
				Thread.sleep(1000); // ça affichera toutes les secondes 1000 = 1 sec
			} catch (InterruptedException e ) {
				System.out.println(e);
			} System.out.println(i + "Je m'appelle MultiThread. Thread principal"); // les 2 Threads ne sont pas synchrones
		}

	}

}
