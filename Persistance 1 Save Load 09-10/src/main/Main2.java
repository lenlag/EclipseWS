package main;

public class Main2 {

	public static void main(String[] args) throws Exception {
		
		FileManager fm = new FileManager (",");
		Person p1 = new Person ();
		p1.setId(1);
		fm.load(p1);
		System.out.println(p1);  // par defaut sysout de p => appelle le toString de l'objet, càd données avec des [ ]
		
				
		Person p2 = new Person ();
		p2.setId(2);
		fm.load(p2);
		
		System.out.println(p2);
		
		Person p3 = new Person ();
		p3.setId(3);
		fm.load(p3);
		
		System.out.println(p3);

	}

}
