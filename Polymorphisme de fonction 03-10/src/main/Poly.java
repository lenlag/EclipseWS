package main;

public class Poly {
	
	public String concat (String s1, String s2) {
		return s1 + s2;
		
	}
	
	public String concat (String s1, int a) {
		return concat (s1,""+a); // "" - pour dire que c'est une chaine, càd le premier constructeur
	}

	public static void main(String[] args) {
		
		Poly poly = new Poly ();
		String x = poly.concat("blabla", 5);
		String y = poly.concat("coucou", "doudou");
		
	System.out.println(x);
	System.out.println(y);

	}

}
