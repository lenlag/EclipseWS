package main;

import java.util.Scanner;

public class Exercice26FonctionCarreTableau {

	public static int [] carreTableau (int [] tab ) {
		int i;
		int carre;
		int n =0;
		for (i = 0; i < tab.length; i++) {
			carre = tab [i] * tab [i];
			tab[i] = carre;
		}
		return tab;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);

		System.out.println("Entrez le nombre de valeurs du tableau -> ");
		int n = input.nextInt();

		System.out.println();
		System.out.println("Voici le tableau de " +n+ " elements : ");

		int i;
		int [] result;

		int [] tab = new int [n];

		for (i = 0; i < n; i++) {
			tab [i] = (int)((double)Math.random() * n);
			System.out.print(tab[i]+" ");
		} // for

		System.out.println();

		result  = carreTableau (tab);
		for (i = 0; i < n; i++) {
			System.out.print(result[i]+" ");
		}
	} // f-on main
} // class
