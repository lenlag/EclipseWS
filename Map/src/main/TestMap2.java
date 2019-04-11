package main;

import java.util.HashMap;
import java.util.Map;

public class TestMap2 {

	public static void main(String[] args) {

		Map <String, Integer> map = new HashMap <String, Integer> ();


		
		boolean b = true; // pour rentrer dans la boucle
		while (b) {
			int i = (int)(Math.random()*11.0); // *11.0 pour indiquer que c'est un double, et prendre la mult-on en () + le castrer en (int)
			if(i%2==0) {
				map.put("PAIR", i);
			}else {
				map.put("IMPAIR", i);
			}
			if (map.keySet().size()>=2) { // s'il y en a au moins 2 éléments
				b=false; // pour arreter la boucle
			}
		}// while
		
				
		for (String key: map.keySet() ) { // pour afficher la map
			Integer val = map.get(key);
			System.out.println(key + "=" + val);
			
					
		}
	} // body

}// class
