package main;

import static java.lang.System.out;

import java.util.Scanner;
	
public class Exercice15CorrErr {

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Entrez la valeur 'A'");
		int a = input.nextInt();
		int b = 0;
		
		if (a!=0) {
			a = 10;
			b = 3+2*a;
			out.println("b="+b);
			out.println("a="+a);
		} else {
			a = 8;
			int c = 3+a;
			out.println("c="+c);
			out.println("a="+a);
			out.println("b="+b);
		}
		
		out.println("a="+a);
		out.println("b="+b);
	}

}
