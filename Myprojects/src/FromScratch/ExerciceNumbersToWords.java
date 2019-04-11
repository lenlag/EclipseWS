package FromScratch;

import java.util.Scanner;

public class ExerciceNumbersToWords {


	public static void print (String x) {
	System.out.println(x);	
	} // f-on void print
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		print ("Entrez une valeur entre 21 et 69 -> ");
		Scanner sc = new Scanner (System.in);
		int n;
		n = sc.nextInt();
		
		int dizaine = n / 10;
 
		switch (dizaine) {
		case 2 : 
		System.out.print("vingt ");
		break;
		case 3 : 
		System.out.print("trente ");
		break;
		case 4 : 
		System.out.print ("quarante ");
		break;
		case 5 :
		System.out.print("cinquante ");
		break;
		case 6 : 
		System.out.print("soixante ");
		break;
		default : 
		System.out.print ("Vous avez saisi un mauvais nombre. Le programme s'arrete");
		break;
		}
		
		int unite = n % 10;
		
		switch (unite) {
		case 1 : System.out.print("un");
		break;
		case 2 : System.out.print("deux");
		break;
		case 3 : System.out.print("trois");
		break;
		case 4 : System.out.print("quatre");
		break;
		case 5 : System.out.print("cing");
		break;
		case 6 : System.out.print("six");
		break;
		case 7 : System.out.print("sept");
		break;
		case 8 : System.out.print("huit");
		break;
		case 9 : System.out.print("neuf");
		break;		
		}
		
		
		
	}
}