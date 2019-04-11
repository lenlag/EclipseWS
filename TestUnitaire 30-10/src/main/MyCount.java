package main;

import java.util.ArrayList;
import java.util.List;

public class MyCount {

	public List<Integer> count(int a) throws Exception {	//renvoie une liste contenant les chiffres de 0 à a
		List<Integer>myListInt = new ArrayList<Integer>();
		if (a<0) {
			throw new Exception("mauvaise valeur"); //on indique erreur
		}
		for (int i=0; i<a; i++) {
			myListInt.add(i);
		}

		return myListInt;


	}

	public String cast(int a) {
		return a +"";
	}


	public int uncast(String s) {
		int b = Integer.valueOf(s);
		return b;

	}
}
