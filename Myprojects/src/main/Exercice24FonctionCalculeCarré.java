package main;

import java.util.Scanner;

public class Exercice24FonctionCalculeCarré {

	public static double calculeCarre (double x) {
		return x * x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Entrez un nombre -> ");
		
		double n = input.nextDouble();
		
		double resultat = calculeCarre (n);
		
		System.out.println("Le carré de nombre " + n + " est " + resultat);
		
		
		
	} // f-on main

} // class
