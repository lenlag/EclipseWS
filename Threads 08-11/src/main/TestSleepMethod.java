package main;

public class TestSleepMethod extends Thread{

	public void run () {
		System.out.println("F-on run de la classe TestSleepMethod");
		for (int i=0; ; i++) { // infinite loop, commence à 0 sec et fait une boucle
			try {
				Thread.sleep(1000); // ça affichera toutes les secondes 1000 = 1 sec
			} catch (InterruptedException e ) {
				System.out.println(e);
			} System.out.println(i + "F-on run de la classe TestSleepMethod");
			}
	}
}
