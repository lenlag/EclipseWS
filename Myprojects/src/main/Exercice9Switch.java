package main;

public class Exercice9Switch {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs).trim();
	}
	public static int getInputInt() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		int x=0;
		
		System.out.print("Entrez la valeur x ->");
		x = getInputInt();
		System.out.println();
		
		switch (x) {
			case 0:
			case 1:
				x = x+4;
				break;
			case 2 : 
				x=x+8;
				break;
			case 3 : 
				x=x+12;
				break;
			default :
				x = x+16;
				break;
		}
		System.out.println(x);
	}
}
