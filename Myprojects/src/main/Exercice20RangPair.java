package main;

public class Exercice20RangPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int [] [] tab = new int [6] [13];
	int i, j;
	
	for (i = 0; i < tab.length; i++) {
		for (j = 0; j < tab[i].length; j++) {
			tab [i][j] = 0;
		}
	}
	for (i = 0; i < tab.length; i++) {
		for (j = 0; j < tab[i].length; j++) {
			System.out.print(tab [i][j]+ " ");
		}
		System.out.println();
	}
		System.out.println();
	for (i = 0; i < tab.length; i++) {
		for (j = 0; j < tab[i].length; j++) {
			if (j % 2 == 0) {
				tab [i][j] = 1;
			}
		}
	}
	for (i = 0; i < tab.length; i++) {
		for (j = 0; j < tab[i].length; j++) {
			System.out.print(tab [i][j]+ " ");
		}
		System.out.println();
	}
	
	
}
}
