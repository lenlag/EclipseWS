package FromScratch;

public class ExerciceTableau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;
		int [] tab = new int [10]; 

		System.out.println("Voici le tabeau de 10 entiers");
		System.out.println();

		for (i = 0; i < tab.length; i++ ) {
			tab [i] = i;
		} // for in

		for (i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		} // for affich tab1



		System.out.println();
		System.out.println();

		int s = 0;
		String [] tab1 = new String [10];
		for (s = 0; s < tab.length; s++) {
			tab1 [s] = "A" + s;
		} // for string

		for (s = 0; s < tab.length; s++) {
			System.out.print(tab1 [s] + " ");
		} // for affich tab2


	} // f-on main
} // class
