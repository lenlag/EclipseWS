package main;

public class Exercice19TabZeros {

	public static void main(String[] args) {

	int [] [] tab = new int [6] [13];
	int i, j;
	
	for (i = 0; i <tab.length; i++) {
		for (j=0; j<tab[i].length; j++) {
			tab[i][j] = 0;
		}
	}
	for (i = 0; i <tab.length; i++) {
		for (j=0; j<tab[i].length; j++) {
			System.out.print(tab[i][j]+ " ");
		}
		System.out.println();
	}

}
}
