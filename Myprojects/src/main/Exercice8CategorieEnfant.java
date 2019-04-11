package main;

public class Exercice8CategorieEnfant {

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
		
		int age;
		System.out.print("Entrez l'âge d'un enfant ->");
		age = getInputInt();
		System.out.println();
		
		if (age>=6 && age <=7) {
			System.out.println("Poussin");
		} else if (age >=8 && age <=9) {
			System.out.println("Pupille");
		} else if (age >=10 && age <=11) {
			System.out.println("Minime");
		} else {
			System.out.println("Cadet");
		}
		
}

}
