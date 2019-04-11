package FromScratch;

public class ExerciceTableau1309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] tab = new int [10];
		int i;


		for (i = 0; i < tab.length; i ++) {
			tab [i] = i+1;
			System.out.println("Nombre" + tab [i] + " ");
							
			if (tab [i] * tab [i] > 50) {
				break;
			} // if
		} //for



	} // f-on main
} // class
