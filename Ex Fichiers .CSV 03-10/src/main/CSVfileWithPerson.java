package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfileWithPerson {

	private String path;
	private String separateur;
	boolean titre;
	List <Person> data	= new ArrayList <> (); // liste à 2 dimensions
	List<String> title	= new ArrayList <> ();


	public CSVfileWithPerson () {

	}

	//// Constructeurs /////
	public CSVfileWithPerson (String path) { // appel d'un constructeur à partir d'un autre

		this (path, ",", true);

	}


	public CSVfileWithPerson(String path, String separateur, boolean titre) {

		this.path = path;
		this.separateur = separateur;
		this.titre = titre;
	}


	public List<Person> getData() {
		return data;
	}



	public boolean isTitre() {
		return titre;
	}

		
	
	public List<String> getTitle() { 									// c'est le getter du Title (pas du titre)
		return title;
	}

	//// fonctions /////
	public void load () throws FileNotFoundException, IOException {

		BufferedReader br = null; // BufferedReader = lecture ligne par ligne
		String a;
		try {
			br = new BufferedReader (new FileReader(path));
			int compteur = 0;
			while ((a = br.readLine())!=null) {
				if ((compteur == 0) && (titre == true)) {				// si c'est le premier tour (indice zero) et si le titre existe (true)
					String [] listeTitre = a.split (separateur); 		// on stock la première ligne dans une liste de Strings "Title"
					title = Arrays.asList(listeTitre);
					
				} else {
					String [] array = a.split (separateur); 			
					//List <String> l = Arrays.asList(array);				// on recupère les données de la ligne = nom, prenom, age, email
					
					/*String nom = l.get(0);
					String prenom =  l.get(1);
					int age = Integer.parseInt(l.get(2));
					String email = l.get(3);
					*/
					Person p = new Person(array[0], array [1], Integer.parseInt(array [2]), array [3]);
					
					data.add(p);
					}

				compteur ++;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;

		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		}	finally {
			try {
				if (br !=null) {
					br.close();
				}
			}
			catch  (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void display (List<Person> param) {
		for (Person m: param) {									// Person m => c'est un element de la Liste<Person>			 
			
			System.out.println(m);
		}
	}

	public void display () {
		display(data);
	}

	//// main //////
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVfileWithPerson c = new CSVfileWithPerson ("fichier/csv.txt",",",true);
		//	c = new CSVfile ("fichier/csv.txt"); 						// polymorphe
		c.load();
		List<Person> z = c.getData();
		c.display(z);
	//	c.display(); 												// polymorphe

		//System.out.println(c.getTitle());





	}

}
