package main;

import java.util.ArrayList;
import java.util.List;

public class ForMe {

	public static void main(String[] args) throws Exception {
		

		MyClassList t = new MyClassList();
		System.out.println(t.createList(5, "coucou"));
		
		System.out.println(t.createList(2, null));
		
		System.out.println(t.createList(-1, "nananan"));
		
		System.out.println(t.createList(-1, null)); 
		
		

		MyMath mm = new MyMath ();
		double x = mm.abs(-99.5);
		
		System.out.println(x);
		
		x = mm.sqrt(5);
		System.out.println(x);
		
		double w = Math.sqrt(-55);
		
		System.out.println(w);
		
		double y = mm.random(5);
		System.out.println(y);
		
		MyCount mycount = new MyCount();
		List<Integer>myList = new ArrayList<Integer>();
		myList = mycount.count(3);
		
		System.out.println(myList);
		
		String path = "src/file/doc.txt";
		String val = "Coucou";
		
		MyFile mf = new MyFile();
		mf.writeFile(path, val);
		
		
	//	List<String> ml = new ArrayList<String> ();
		mf.readFile(path);
		
	}

}
