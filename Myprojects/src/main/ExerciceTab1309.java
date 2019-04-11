package main;

public class ExerciceTab1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] tab = new int [100];
		int i;

		for (i = 0; i < 100; i++) {
			tab [i] = i + 1001; 
		} // for

		for (i = 0; i < 100; i++) {
			System.out.print(tab[i] + "\t");
		} // for affich boucle
		
		System.out.println();
		System.out.println();
		
		for (i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				tab [i] = tab [i] / 5;
				System.out.print(tab [i] + "\t");
				
			} else {
				tab [i] = tab [i] / 10;
				System.out.print(tab [i] + "\t");
			} // if %
		}//for
	} // f-on main

} // class
