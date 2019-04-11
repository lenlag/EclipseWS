package main;

public class Exercice16TableauEntiers {

	public static void main(String[] args) {
		
		int tab [] = new int [20];
		int i;
		
		for (i=1; i<tab.length; i++) {
			tab[i] = (int) ((double)Math.random()*99.0);
			System.out.println(tab[i]);
		}
	
		
		
		
	}

}
