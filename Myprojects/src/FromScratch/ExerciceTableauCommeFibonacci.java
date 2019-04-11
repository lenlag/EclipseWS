package FromScratch;

public class ExerciceTableauCommeFibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] tab = new int [100];
		int i;

		for (i = 0; i < tab.length; i++) {
			if (i == 0) {
				tab [i] = i;
			} else {
			tab [i] = i + tab [i-1];
			System.out.print(tab[i] + "\t");	
			} // if
			
		}// for

	} // void main 

} // class
