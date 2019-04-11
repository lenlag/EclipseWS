package main;

public class Exercice7Souschaine {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs).trim();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String s1;
		System.out.print("Entrez la première chaîne ->");
		s1 = getInputString();
		System.out.println();
		
		String s2;
		System.out.print("Entrez la sous-chaîne à rechercher ->");
		s2 = getInputString();
		System.out.println();
		
		
		if (s1.contains(s2)) {
			System.out.println("La sous-chaîne est présente dans la première chaîne");
		} else {
			System.out.println("Cette sous-chaîne n'a pas été detectée dans la première chaîne" );
		}
}		
}

