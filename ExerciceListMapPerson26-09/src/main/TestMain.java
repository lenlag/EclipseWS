package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {

	public static void main(String[] args) {

		Person person1 = new Person ("Brousse", "Gerard", 35, "FR");
		Person person2 = new Person ("Thao", "Kiab", 25, "DE");
		Person person3 = new Person ("Mathieu", "Natalia", 29, "RU");

		List <Person> maliste = new ArrayList <Person>(); // creation d'une liste de la classe Person
		maliste.add(person1);
		maliste.add(person2);
		maliste.add(person3);

		System.out.println("C'est notre liste : ");
		for (Person h : maliste) { // pour parcourir la liste
			System.out.println(h); // ca affiche la liste to String, car nous avons f-on string toString de Personne
		}

		Map <String, Person> map = new HashMap <String, Person> ();// creation de Map avec country pour CLE & Person pour VALEUR

	
		for (Person h : maliste) { // pour parcourir la liste, � chaque tour de boucle, on recup�re le h , c�d Person
			map.put(h.getCountry(), h); // objet person(c�d h).getCountry, person (c�d objet h)
			// System.out.println(h.getCountry() + "=" + h); // on peut afficher la map comme �a �galement, sinon on fait une boucle => voir ci-dessous	
		} 
		
		System.out.println();
		System.out.println();
		System.out.println("Voici notre map : "); // qui provient de la liste
		for (String cle: map.keySet()) { // pour parcourir la liste des cl�s, boucle sur la map
			Person valeur = map.get(cle); // on appelle l'objet "valeur" - pour r�cup�rer la cl� de la valeur
			System.out.println(cle + "=" + valeur);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("C'est la nouvelle liste avec age remis � zero : ");
		for (Person h : maliste) { // pour parcourir la liste, une boucle sur la liste
			h.setAge(0); // set age de tous les �l�ments � 0
			System.out.println(h); // imprimer la liste
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println("C'est la nouvelle map : ");
		for (String cle: map.keySet() ) { // on refait la boucle sur la map
			Person valeur = map.get(cle); 
			System.out.println(cle + "=" + valeur);
		} 
		
	} 

} 
