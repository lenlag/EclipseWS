package FromScratch;

public class Exercice3TableauxABC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [] tabA = new int [100];
		int [] tabB = new int [100];
		int [] tabC = new int [100];
		
		int i;
		
		
		for (i = 0; i < tabA.length; i ++ ) {
			tabA [i] = i + 1;
			System.out.print(tabA [i] + "\t");
		} // for
		
		System.out.println();
		
		for (i = 0; i < tabB.length; i ++) {
			tabB [i] = i +200;
			System.out.print(tabB [i] + "\t");
		} // for
		
		System.out.println();
		
		for (i = 0; i < tabC.length; i ++) {
			tabC [i] = tabB [i] - tabA[i];
			System.out.print(tabC [i] +"\t");
			
		} // for
	} // f-on void main
	
} // class
