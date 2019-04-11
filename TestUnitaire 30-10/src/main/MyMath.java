package main;

public class MyMath {
	
	public double abs(double d) {
		double a = Math.abs(d);
		return a;
	}
	
	public double sqrt(int a) throws Exception {
		if (a<0) {
			throw new Exception("mauvaise valeur");
		}
		double b = Math.sqrt(a);
		return b;
	}
	
	public int min(int a, int b) {
		int d = Math.min(a, b);
		return d;
		
	}

	
	public double random (int a) {
		return Math.random()*a;
		
	}
	
}
