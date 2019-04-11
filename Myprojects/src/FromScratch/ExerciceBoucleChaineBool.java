package FromScratch;

import java.util.Scanner;

public class ExerciceBoucleChaineBool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);

		String rep;
		boolean ok = true;

		while (ok) {
			System.out.println("Entrez une chaine de caractères: ");
			rep = sc.nextLine();
			if (rep.equalsIgnoreCase("exit")) {
				ok = false;	
			} //if
		} // while
		System.out.println("Attention. On sort.");

	} // f-on main
} //class
