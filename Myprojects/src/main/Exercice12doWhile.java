package main;

public class Exercice12doWhile {

	public static String getInputString() throws Exception {
		byte[] bs = new byte[255];
		System.in.read(bs);

		return new String(bs).trim();
	}
	public static int getInputdouble() throws Exception {
		String s = getInputString().trim();
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		double n = 0;
		String answer;

		do {
			System.out.println("Entrez la valeur ->");
			n = getInputdouble();
			System.out.println();

			if ((n>=100.0) && (n<=1000.0)) {
				System.out.println("La valeur " +n+ " fait partie de l'intervale donnée");
			} else {
				System.out.println("La valeur " +n+ " ne fait partie de l'intervale donnée");
			}
			System.out.println();
			System.out.println("Voulez-vous continuer? -> O / N");
			answer = getInputString();
			if (answer.equalsIgnoreCase("N")) {
				break;
			} else if (!answer.equalsIgnoreCase("O"));
		} while(true); 

	}

}
