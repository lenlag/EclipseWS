package main;

import java.util.ArrayList;
import java.util.List;

public class MyClassList {

	public MyClassList () {

	}


	public List<String> createList (int nombreDeString) throws Exception {
		if (nombreDeString < 0) {
			throw new Exception("mauvaise valeur");
		}
		List <String> myList = new ArrayList<>();
		for (int i = 0; i < nombreDeString; i++) {
			myList.add(i + " ");
		}
		return myList;
	}

	/* SINON
	 * public List<String> createList (int nombreDeString) {
		if (nombreDeString < 0) {
			return null;
		}
		List <String> myList = new ArrayList<>();
		for (int i = 0; i < nombreDeString; i++) {
			myList.add(i + " ");
		}
		return myList;
	}
	 * 
	 */

	public List<String> createList (int nb, String prefix) {
		if (nb < 0) {
			return null;
		} else if (prefix==null) { // pour comparer à null on utilise ==
			List <String>myList2 = new ArrayList<>();
			for (int i = 0; i < nb; i++) {
				myList2.add("xxx");
			}
			return myList2;
		} 
		List <String>myList = new ArrayList<>();
		for (int i = 0; i < nb; i++) {
			myList.add(prefix + "xxx");
		}
		return myList;
	}





} // class
