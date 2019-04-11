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
			int lus = 0; // nombre de caract�res r�element lus

			while (lus != -1) { // jusqu'� ce que la boucle contienne des caract�res, car -1 veut dire qu'on est � la fin de fichier
				byte [] bs = new byte [1024]; // lire les 1024 caract�res � la fois, et les stocket dans bs
				lus = fis.read (bs); // les caract�res lus = lecture de  notre fichier fis de 1024 caract�res dans une boucle
				
				if (lus!=-1) { // pour que la longueur ne soit pas -1
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut 0, jusqu'� la fin lus = nbre des car-s r�element lus)
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
