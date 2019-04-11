package main;

import java.util.ArrayList;
import java.util.List;
public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <String> maliste = new ArrayList <String>();
		
		for  (int i = 0; i < 10; i++ ) {
			String m = i + "_"+ Math.random()*10;
			maliste.add(m);
			// maliste.add("AAA");
			/* erreur! cannot convert from Object to String		
			 * String  s = maliste.get(0);
			 */
		//	Object s = maliste.get(0);
		//	String x = (String) s;
			//System.out.println(x);
		} 

		
		for (String h : maliste) { // pour parcourir la liste
			System.out.println(h.toString());
		}
		
		System.out.println();
		System.out.println(maliste.get(5));
		System.out.println(maliste.get(7));
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.print(maliste.toString());
		
		
		/*List <String> malisteSupp = new ArrayList <String>();
		int i =0;
		for (String maString : maliste) {
			
			
			if (i%2 == 0) {
				malisteSupp.add(maString);
				System.out.println(malisteSupp.toString());
			}
			i++;
		}
		maliste.removeAll(malisteSupp);
		System.out.println(maliste.toString());
		*/
		
		List <String> malisteSupp = new ArrayList <String>();
		for (String h : maliste) {
			String first = h.substring(0, 1);
			int p = Integer.parseInt(first);
			if (p%2 ==0) {
				malisteSupp.add(h);
			}
		}
		
		maliste.removeAll(malisteSupp);
		
		for (String h: maliste ) {
			System.out.println(h);
		}
		}// main

} // class
