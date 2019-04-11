package main;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		Person person1 = new Person ("Brousse", "Gerard", 35, "FR");
		Person person2 = new Person ("Thao", "Kiab", 25, "DE");
		Person person3 = new Person ("Mathieu", "Natalia", 29, "RU");

		List <Person> maliste = new ArrayList <Person>(); // creation de la 1ere liste de la classe Person
		maliste.add(person1);
		maliste.add(person2);
		maliste.add(person3);
		
		List <Person> maliste2 = new ArrayList <Person>(); // creation de la 2eme liste

		System.out.println("Voici notre première liste : ");
		for (Person h : maliste) { // pour parcourir la liste 1
			System.out.println(h); // ca affiche la liste to String, car nous avons f-on string toString de Personne
		}
		
		maliste2.add(person1.clone()); // rajout personnes dans la 2eme liste
		maliste2.add(person2.clone());
		maliste2.add(person3.clone());
		
		System.out.println();
		System.out.println();
		System.out.println("Voici notre deuxième liste : ");
		for (Person k : maliste2) { // pour parcourir la liste 2
			System.out.println(k); // ca affiche la liste to String, car nous avons f-on string toString de Personne
		}
		
		
		person1.setAge(15); // on modifie l'age des personnes de la 1ère liste
		person2.setAge(15);
		person3.setAge(15);
		System.out.println();
		System.out.println();
		System.out.println("Voici la 1ère liste modifiée : ");
	
		for (Person h : maliste) { // la boucle pour afficher la liste 1
			System.out.println(h); // ca affiche la liste to String, car nous avons f-on string toString de Personne
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("Voici la 2ème liste : ");
		for (Person k : maliste2) { // la boucle pour afficher la liste 2
			System.out.println(k); // ca affiche la liste to String, car nous avons f-on string toString de Personne
		}
		
				
				
				
			

	}

}
