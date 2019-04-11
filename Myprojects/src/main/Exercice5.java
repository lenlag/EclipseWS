package main;

public class Exercice5 {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s = null;
		System.out.print("Entrez une chaine de caractrère ->");
		s = getInputString();
		s.toUpperCase();
		s = s.toUpperCase();
		
	
	
		System.out.println(s);
		

	}

}
