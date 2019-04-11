package main;

public class ExerciceTripleTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] [] tab = new String [10] [10];
		int i;
		int j;
		int h;

		for (i = 0; i < tab.length; i++) {
			for (j = 0; j < tab[i].length; j++) {
				tab [i][j] = i + "@" + j ;
				System.out.print(tab[i][j] + "\t");
			} // for
		} // for

		System.out.println();
		System.out.println();	

		String [] [] [] tab1 = new String [10] [10] [10];

		for (i = 0; i < tab1.length; i++) {
			for (j = 0; j < tab1[i].length; j++) {
				for (h = 0; h < tab1[i][j].length; h++) {
					tab1 [i][j][h] = i + "@" + j + "@" + h;
					System.out.print(tab1[i][j][h] + "\t");
				} // for
			} // for
		} // for


	} // f-on main

} // class
