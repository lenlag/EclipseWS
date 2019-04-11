package mainMultiThread;

public class MyThread extends Thread {

	private MultiThread mt; // aggregation



	public MyThread(MultiThread mt) { // comme String s    //  constructeur
		this.mt= mt;
	}
	public void run () {
		mt.afficher();
	}
}
