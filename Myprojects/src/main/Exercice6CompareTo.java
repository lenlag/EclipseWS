package main;

public class Exercice6CompareTo {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);
		
		return new String(bs);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String s1;
		System.out.print("Entrez le premier nom ->");
		s1 = getInputString();
		System.out.println();
		
		String s2;
		System.out.print("Entrez le deuxième nom ->");
		s2 = getInputString();
		System.out.println();

		String s3;
		System.out.print("Entrez le premier nom ->");
		s3 = getInputString();
		System.out.println();
		
				
			if ((s1.compareTo(s2) <0) && (s2.compareTo(s3) <0)) {
					System.out.println("Ordre Alphabétique");
			} else {
					System.out.println("Ordre non-alphabétique");
			}
	}

}
