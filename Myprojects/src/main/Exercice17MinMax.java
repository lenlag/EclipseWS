package main;

public class Exercice17MinMax {

public static void main(String[] args) {
		
		int tab [] = new int [20];
		int i;
		int max = 0;
		int min = 100;
		
		for (i=0; i<tab.length; i++) {
			tab[i] = (int) ((double)Math.random()*100.0);
			System.out.println(tab[i]);
		}
		
		for (i=0; i<20; i++) {
			if (tab [i] > max) {
			max = tab[i];					
			}
		}
		System.out.println("La valeur maximale du tableau est: " +max);		
		
		for (i=0; i<20; i++) {
			if (tab [i] < min) {
			min = tab[i];				
			}
		}
		System.out.println("La valeur minimale du tableau est: " +min);	
}
}