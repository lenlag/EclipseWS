package main;

public class Exercice2 {
	
	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs);
	}
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int x, y, m;
		System.out.print("Entrez x ->");
		x = getInputInt();
		System.out.println();
		System.out.print("Entrez y ->");
		y = getInputInt();
		m = x*y;
		System.out.println();
		System.out.println("Le résultat de la multiplication est:"+ m);
		
	}

}
