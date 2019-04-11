package main;

public class TestMainSleep {

	public static void main(String[] args) {
		
		TestSleepMethod tsleep = new TestSleepMethod ();
		
		tsleep.start();
		
	//	System.out.println("Le nom du thread principal est " + Thread.currentThread().getName()); // ici c'est main
	}

}
