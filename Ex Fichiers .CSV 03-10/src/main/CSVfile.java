package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVfile {

	private String path;
	private String separateur;
	boolean titre;
	List<List<String>> data	= new ArrayList <> (); // liste à 2 dimensions : lignes et colonnes
	List<String> title	= new ArrayList <> (); // our second massif in one line that contains titles

	
	
	//// Constructeurs /////
	public CSVfile () {

	}

	
	public CSVfile(String path, String separateur, boolean titre) {

		this.path = path;
		this.separateur = separateur;
		this.titre = titre;
	}
	
	public CSVfile (String path) { // appel d'un constructeur à partir d'un autre

		this (path, ",", true);
	}


	public List<List<String>> getData() {
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
		String line;
		try {
			br = new BufferedReader (new FileReader(path));
			int compteur = 0;
			while ((line = br.readLine())!=null) {
				if ((compteur == 0) && (titre == true)) {				// si c'est le premier tour (càd indice zero in readLine() & et si le titre existe (true)
					String [] tabStringTitre = line.split (separateur); 		// on stock la première ligne dans un tableau de Strings "tabStringTitre", en la séparant par les virgules
					title = Arrays.asList(tabStringTitre);					// on transforme notre tableau en List<String>> s'appellant "title" (voir variables en haut)
				} else {
					String [] array = line.split (separateur); 			// sinon, le reste du fichier (apart le titre), on stock dans un tableau de Strings "array", et on separe les Strings de chaque ligne par les virgules
					List <String> l = Arrays.asList(array);				// et on transforme notre tableau de String "array" en List<String> "l"
					data.add(l);}										// ensuite on rajoute notre Liste de String l dans la liste à 2 dimensions "data"

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

	public void display (List<List<String>> param) {
		for (List<String> m : param) {									// on parcours les lignes			 
			for (String h : m) { 										// on parcours les colonnes
				System.out.print(h+ ";"  + "" + " ");
			}
			System.out.println();
		}
	}

	public void display () {
		display(data);
	}

	//// main //////
	public static void main(String[] args) throws FileNotFoundException, IOException {
		CSVfile c = new CSVfile ("fichier/csv.txt",",",true);
		//	c = new CSVfile ("fichier/csv.txt"); 						// polymorphe
		c.load();
		List<List<String>> z = c.getData(); // càd les données de la List<list<String>> data
		c.display(z);  // afffichera tout le fichier csv, sauf la 1ère ligne "titre", car elle est stocké dans une Liste<String> titre apart!
		// c.display(); 												// polymorphe

	//	System.out.println(c.getTitle());





	}

}

