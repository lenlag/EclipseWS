package FromScratch;


import java.util.Scanner;

public class ExerciceIsSquareOdd {
	
	public static int square (int x) {
	return x * x;
	} // f-on square
	
	public static boolean isOdd (int x) {
	if (x % 2 == 0) {
		return false ;
	} else {
		return true;
	} // if
	} // f-on isOdd
	
	public static boolean isSquareOdd (int x) {
	if (isOdd(square (x))) {
		return true ;
	} else {
		return false;
	}
	} // f-on isSquareOdd
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		int n;
		
		System.out.println("Entrez un nombre ->");
		n = sc.nextInt();
		
		boolean result;
		result = isSquareOdd (n);
		
		System.out.println(result);
	} // f-on void main 

} // class

