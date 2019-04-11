package main;

import java.util.Scanner;

public class Exercice25CalculeMoyenne {

	public static int calculeMoyenne (int tab []) {
		int i;
		int somme = 0;
		for (i=0; i<tab.length; i++) {
			somme = somme + tab [i];
		}
		return somme/tab.length; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);

		int n;
		int i;
		int result;

		System.out.println("Entrez le nombre de valeurs -> ");
		n = input.nextInt();

		int[] tab = new int [n];

		for (i=0; i<n; i++) {
			tab[i] = (int) ((double)Math.random()*n);
			System.out.print(tab[i]);
		} // for

		result = calculeMoyenne (tab);
		
		System.out.println();
		System.out.println("La moyenne du tableau est: " + result);


	} // f-on main

} // class
