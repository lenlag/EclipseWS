package main;

import java.util.Scanner;

public class Exercice23FonctionMult {


	public static int mult (int y) {
		return y * 2;
	} //mult

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input  = new Scanner (System.in);

		int x;

		System.out.println("Entrez un nombre: ");
		x = input.nextInt();

		int resultat = mult(x);

		System.out.println("Le "+x+" multiplié par 2 égal à: "+resultat);
		
		
	} //main

} //class