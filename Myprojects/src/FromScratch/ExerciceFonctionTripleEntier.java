package FromScratch;

import java.util.Scanner;

public class ExerciceFonctionTripleEntier {

	public static int calculeTriple (int a) {
		return a * 3;
	} // f-on calculeTriple

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);

		int x;

		System.out.println("Entrez la valeur -> ");
		x  = sc.nextInt();

		int resultat = calculeTriple (x);
		
		System.out.println("La valeur " + x + " , multiplié par 3, fait: " + resultat);

	} //f-on void main

} //class
