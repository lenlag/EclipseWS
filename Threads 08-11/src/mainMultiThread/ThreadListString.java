package mainMultiThread;

import java.util.ArrayList;
import java.util.List;

public class ThreadListString extends Thread {

	MultiThread mthr = new MultiThread ();

	public ThreadListString (MultiThread mthr) {
		this.mthr = mthr;
	}

	public void run () {
		mthr.write();
	}




}
