package main;

public class Exercice18BubbleSort {

	public static void main(String[] args) {
		int [] tab  = new int [20];
		int i, j = 100;
		int temp;
		
		System.out.println("Tableau random avant le tri:");
		
		for (i=0; i<tab.length; i++) {
			tab[i]= (int)((double)Math.random()*100);
			System.out.println(tab[i]);
		}
		
		System.out.println("Le tableau après le tri:");
		for (i=0; i<tab.length-1; i++) {
			for (j = i+1; j<tab.length; j++) {
				if (tab[j] < tab[i]) { 
				temp = tab[i];
				tab[i] = tab[j];
				tab[j] = temp;
				}
			}
		}
		for (i=0; i<tab.length-1; i++) {
		System.out.println(tab[i]);
		}
	}
}