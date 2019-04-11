package main;
import objets.ILister;
import process.ListerFactory;

public class TestMain {

	public static void main(String[] args) throws Exception {
	
				
		ILister lister = ListerFactory.newInstance();
		lister.display();
		
		
		
	}

}
