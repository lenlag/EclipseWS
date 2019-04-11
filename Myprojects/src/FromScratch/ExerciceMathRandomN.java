package FromScratch;

import java.util.Scanner;

public class ExerciceMathRandomN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		double n;

		System.out.println("Entrez une valeur -> ");
		n = sc.nextDouble();

		while (n > 1) {
			n = n / 7;
		} // while

		System.out.println(n);

		double mathrandom = 0;


		System.out.println("Random");
		while (mathrandom < n) {
			mathrandom = Math.random();
			System.out.println(mathrandom);
		} // while



	} // f-on void main

} // class
