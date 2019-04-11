package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciceMapTableau {

	public static void main(String[] args) {

		List <Integer> malistePAIR = new ArrayList <Integer>();// creation de 2 listes
		List <Integer> malisteIMPAIR = new ArrayList <Integer>();

		Map <String, List<Integer>> map = new HashMap <String, List<Integer>> (); // creation de la map <cle, valeur<>>

		map.put("PAIRES", malistePAIR); // rajout dans la 1ere map - avat la boucle !!!!
		map.put("IMPAIRS", malisteIMPAIR); // rajout dans la 2eme map

		for  (int i = 0; i < 100; i++ ) { // var i pour parcourir la boucle
			int k = (int)(Math.random()*100.0); // var k pour créer des nombres random
			if(k%2==0) {
				malistePAIR.add(k); // rajout dans la 1ere liste
			}else {
				malisteIMPAIR.add(k); // rajout dans la 2eme liste

			}
		}



		for (String key: map.keySet() ) { // boucle sur la map
			List <Integer> val = map.get(key);
			System.out.print(key + ": " ); // pour afficher la clé
			for (Integer h : val) {// boucle imbriquée sur la liste
				System.out.print(h + " "); // pour afficher la valeur
			}
			System.out.println();
		}


	}

}
