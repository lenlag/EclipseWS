package main;

public class Exercice10ConversionMiles {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs).trim();
	}
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		double mile;
		double km;
		
		km = 0;
		mile = 0;
		
		System.out.println("Entrez le nombre de miles-> ");
		mile = getInputInt();
		System.out.println();
		
		
		km = mile * 1.609;
		
		System.out.println("Cela fait " +km+" kms");
	}

}
