package main;


import objets.FileLister;
import objets.ILister;
import objets.MemLister;
import process.ListerFactory;

import java.util.List;

public class TestMain {

	public static void main(String[] args) throws Exception {
	
				
		ILister lister = ListerFactory.newInstance();
		if (lister instanceof FileLister) {
			System.out.println("Je suis une instance of FileLister");
		} else if (lister instanceof MemLister) {
			System.out.println("Je suis une instance of MemLister");
		}
		lister.display();
		
		
		List<String> list = lister.list(); // il faut stocker mem.list(ça renvoie List<String>) dans une variable List<String> list
		System.out.println(list);
		
			List <String> malistenet = lister.list();
		
		for (String h : malistenet) { 
			System.out.println(h);
		}
		
	}

}
