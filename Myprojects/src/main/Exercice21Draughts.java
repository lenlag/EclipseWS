package main;

import java.util.Scanner;

public class Exercice21Draughts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int i;
		int j;
		int ligne = 0;
		int col;
		int [] [] tab = new int [10] [10];
		boolean stop = false;
							
		for (i = 0; i < tab.length; i++) {
			for (j = 0; j < tab[i].length; j++) {
				tab[i] [j] = 0;
		}	
		}
		
		for (i = 0; i <tab.length; i++) {
			for (j = 0; j < tab[i].length; j++) {
				System.out.print(tab [i] [j]+ " ");
			}
		System.out.println();	
		}
		
		System.out.println();
		
				
						
			while(true) {
				System.out.println("Donnez la position de votre pion -> no de ligne ");
				ligne = input.nextInt();
		
				if ((ligne < 1) || (ligne > 10)) {
					System.out.println("Erreur. Le tableau contient entre 1 et 10 lignes. Recommencez");
					stop = true;
				} else {
					break;
				}
			}	
			while(true) {
				System.out.println("Donnez la position de votre pion -> no de colonne");
				col = input.nextInt();
		
				if ((col < 1) || (col > 10)) {
				System.out.println("Erreur. Le tableau contient entre 1 et 10 colonnes. Recommencez");
				stop = true;
				} else {
				break;
				}
			}
		
		tab[ligne-1][col-1] = 1;
		for (i = 0; i <tab.length; i++) {
			for (j = 0; j < tab[i].length; j++) {

				System.out.print(tab [i] [j]+ " ");
			}
		System.out.println();	
		}
		
		int l = ligne;
		int c = col;
		int mouv;
		
		
		
		System.out.println();
		System.out.println("Quel mouvement voulez-vous effectuer?  0 (en haut à gauche), 1 (en haut à droite), 2 (en\r\n" + 
				"bas à gauche), 3 (en bas à droite) -> ");
		
		
		while(true) {		
			mouv = input.nextInt();
			System.out.println();
			ligne = l;
			col = c;
			switch (mouv) {
				case 0:
					l--;
					c--;
					break;
				case 1:
					l--;
					c++;
					break;
				case 2 : 
					l++;
					c--;
					break;
				case 3 : 
					l++;
					c++;
					break;
				default :
					System.out.println("Mouvement incorrect. On sort");
					System.out.println();
					break;
				
			}
			if (l < 1 || c < 1 || l > 10 || c > 10) {
				System.out.println("Mouvement Impossible. On sort");
				break;
			}
			tab [l-1][c-1] = 1;	
			tab[ligne-1][col-1] = 0;
				
			for (i = 0; i <tab.length; i++) {
				for (j = 0; j < tab[i].length; j++) {
					System.out.print(tab [i] [j]+ " ");
				}
				System.out.println();
			}
		
			System.out.println();
			System.out.println();
			System.out.println();
		} // while	
	} // main	
} // class

