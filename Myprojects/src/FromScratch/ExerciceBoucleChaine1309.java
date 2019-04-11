package FromScratch;

import java.util.Scanner;

public class ExerciceBoucleChaine1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		String rep;
		
		while (true) {
		System.out.println("Entrez une chaine de caractères: ");
		rep = sc.nextLine();
		
			if (rep.equalsIgnoreCase("exit")) {
				break;	
			} //if
		} // while
		System.out.println("Attention. On sort.");
		
	} // f-on main
} //class
