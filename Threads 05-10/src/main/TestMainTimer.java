package main;

import java.util.Timer;
import java.util.TimerTask;


public class TestMainTimer {

	public static void main(String[] args) {
		
		Timer t = new Timer ();
		MyTimerTask tx = new MyTimerTask ();
		

		t.schedule(tx, 20000, 10000); // thread TimerTask tx secondaire
		System.out.println("Fin du prog principal"); // ça s'affiche en 1er
		
	}

}
