package main;

public class Test {

	public static void main(String[] args) {

		Parent parent = new Parent ("Sailor", "Moon", 10);
		while (parent.getAge() < 18) {
			parent.grandir();
		}

		// 8 fois grandir - pour atteindre 18 ans

		parent.accoucher();
		parent.accoucher();
		parent.accoucher();
		// 3 fois accoucher - pour avoir 3 enfants

		String s = parent.toString();
		System.out.println(s);

	
		int i = 0;
		
		while (true) {
			Parent x = parent.getEnfants(i);
			if (x==null) {
				break;
			} // if
			System.out.println("Enfant : " + x);
			
				while (x.getAge() < 18) {
				x.grandir();
			} // xhile - grandir
			i++;
			x.accoucher();
			x.accoucher();
		} // while - true

		String result = parent.toString();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println(result);
		
	} // main

} // classe
