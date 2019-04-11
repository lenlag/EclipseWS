package main;

public class Main1 {

	public static void main(String[] args) {
		
		Person p1 = new Person ("Marilyn", "Monroe", 30, new Address ("Stars Ave.", 10235, "Hollywood"));
		p1.setId(1);
		
		Person p2 = new Person ("Gérard", "Depardieu", 69, new Address ("Rue Parvis du Sacré-Coeur", 75018, "Paris"));
		p2.setId(2);
		
		Person p3 = new Person ("Johnny", "Depp", 55, new Address ("Franklin Ave.", 568454, "Los Angeles"));
		p3.setId(3);
		
		
		FileManager fm = new FileManager ();
		fm.save(p1);
		fm.save(p2);
		fm.save(p3);
		
		
		
		
		
	}

}
