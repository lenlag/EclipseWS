package FromScratch;

import java.util.Scanner;

public class ExerciceFonctionRecursion {
	
	public static void deux (int x) {
		int n = x * 2;
		System.out.println(n);
		if (n  < 100) {
			deux(n);
		} // for
		return ;
	} // f-on void

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		int n;
		int result;

		System.out.println("Entrez une valeur < 20");
		n = sc.nextInt();

		
		deux(n);
		
		
	} // f-on void main

} // class
