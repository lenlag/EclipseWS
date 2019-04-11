package main;

public class Exercice4 {


	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs);
	}
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int n1, n2;
		System.out.print("Entrez le 1er nombre ->");
		n1 = getInputInt();
		System.out.println();
		System.out.print("Entrez le 2eme nombre ->");
		n2 = getInputInt();
		System.out.println();
			if ((n1 < 0 )&& (n2 < 0) || (n1 > 0) && (n2 > 0)) {
					System.out.println("Leur produit est positif");
				} else if ((n1 == 0) || (n2 == 0)){ 
					System.out.println("Leur produit est null");
				} else {
					System.out.println("Leur produit est négatif");
				}
	}
			
}



