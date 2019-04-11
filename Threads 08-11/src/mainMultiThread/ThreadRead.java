package mainMultiThread;

public class ThreadRead extends Thread {

	MultiThread mthr = new MultiThread ();

	public ThreadRead (MultiThread mthr) {
		this.mthr = mthr;
	}

	public void run () {
		mthr.read();
	}

}
