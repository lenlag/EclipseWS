package main;

import java.util.Scanner;

public class Exercice22SuppCaractereString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		
		String phrase;
		int rang;
		String phrase1;
	    
		
		System.out.println("Entrez une phrase: -> ");
		phrase = input.nextLine();
		
		System.out.println("Entrez le rang d'un caractère à supprimer -> ");
		rang = input.nextInt();
	
		int l = phrase.length();
		
		phrase1 = phrase.substring (0,(rang)) + phrase.substring ((rang+1),l);
		
		System.out.println("La nouvelle phrase est: " +phrase1);
		
		
		
		
		
		
		
		
	} // main

} // class
