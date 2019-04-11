package main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {


	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		String result = ""; // vide pour le moment
		String upper = "";
		try {
			fr = new FileReader("file/alire"); // ouvrir fichier
			fw = new FileWriter("file/ecrire");
			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { // jusqu'à ce que la boucle contienne des caractères, car -1 veut dire qu'on est à la fin de fichier
				char [] bs = new char [1024]; // char, car des caracteres
				lus = fr.read (bs); // les caractères lus = lecture de  notre fichier fis de 1024 caractères dans une boucle
				
				if (lus!=-1) { //  -1 = la fin de fichier
								
					result += new String(bs, 0, lus); // pour concatener le resultat dans une chaine (bs, debut 0, jusqu'à la fin lus = nbre des car-s réelement lus)
					fw.write(bs);// car on prend que des caracteres
										
				} // if
				
			} // while

			System.out.println(result);
		} // bloc try
		catch (IOException e) {
			e.printStackTrace();
		} // bloc catch
		finally {
			try {
				fr.close(); // car close peut lever des exceptions
				fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			} // bloc catch

		} // finally
		
			

	} // main

} // class
