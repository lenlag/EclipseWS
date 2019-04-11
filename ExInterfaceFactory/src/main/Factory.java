package main;

public class Factory {

	Class1 class1 = new Class1 ();
	Class2 class2 = new Class2 ();
	
	public void newInstance () {
		if (Math.random() < 0.5) {
			class1.compute();
		} else {
			class2.compute();
		}
		
	}
	
	
}
