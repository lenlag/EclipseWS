package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileBufferedReader {

	public static void main(String[] args) {
		
		BufferedReader in = null;
		String a;
		int compteur = 0;
		try {
			in = new BufferedReader (new FileReader("file/alire"));
					
			while ((a = in.readLine())!=null) {
				
			System.out.println("Ligne lue : " + a);
			compteur ++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Il y a " + compteur + " lignes dans le fichier texte");
		
		
	} // main

} // class
