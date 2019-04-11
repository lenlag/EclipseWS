package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File {



	public static void main(String[] args) {

		FileInputStream fis = null;
		FileOutputStream fos = null;
		String result = ""; // vide pour le moment
		String upper = "";
		try {
			fis = new FileInputStream("file/alire"); // ouvrir fichier
			fos = new FileOutputStream("file/ecrire");
			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { // jusqu'à ce que la boucle contienne des caractères, car -1 veut dire qu'on est à la fin de fichier
				byte [] bs = new byte [1024]; // lire les 1024 caractères à la fois, et les stocket dans bs
				lus = fis.read (bs); // les caractères lus = lecture de  notre fichier fis de 1024 caractères dans une boucle
				
				if (lus!=-1) { // pour que la longueur ne soit pas -1
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut 0, jusqu'à la fin lus = nbre des car-s réelement lus)
					upper = txt.toUpperCase();
					fos.write(upper.getBytes());
				} // if
				
			} // while

			System.out.println(result);
		} // bloc try
		catch (IOException e) {
			e.printStackTrace();
		} // bloc catch
		finally {
			try {
				fis.close(); // car close peut lever des exceptions
				fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			} // bloc catch

		} // finally
		
		
		
	
		

	} // main

} // class
