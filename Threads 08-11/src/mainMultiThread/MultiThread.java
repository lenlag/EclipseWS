package mainMultiThread;

import java.util.ArrayList;
import java.util.List;

public class MultiThread {

	boolean stopMain = false;
	boolean stop;

	private List <String> nl = new ArrayList<>();



	public List<String> getNl() {
		return nl;
	}


	public void setNl(List<String> nl) {
		this.nl = nl;
	}


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


	public void main() {

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


	public void alphaMain () {  
		ThreadListString tls = new ThreadListString (this); // Thread qui remplit le liste (écrit)
		tls.start();
		
		ThreadRead tr = new ThreadRead (this) ; // Thread qui lit - read
		tr.start();
	}


	public void write () {
		byte b = 'A';

		while (b <= 'Z') { // moins que la val 'Z'
			try {
				
				byte [] bs = {b,b,b};
				String s = new String (bs);
				//System.out.println(s);
				nl.add(s);
				b ++;
				Thread.sleep(500); // sleep on positionne en bas
			} catch (InterruptedException e ) {
				System.out.println(e);
			} 
			
		}

	}


	public void read () {
		int i = 0;
		while (i!= 26) {
		
			System.out.println(nl.get(i));
			i ++;
			try {
				Thread.sleep(1000); // sleep on positionne en bas
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}



}
