package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExampleFileInputStream {



	public static void main(String[] args) {

		FileInputStream fis = null;
	
		String result = ""; 
		try {
			fis = new FileInputStream("file/alire"); // ouvrir fichier
			
			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { 
				byte [] bs = new byte [1024]; 
				lus = fis.read (bs); 
				
				if (lus!=-1) { 
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut => 0, jusqu'à la fin=> lus = nbre des car-s réelement lus)
					
					
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
				
			} catch(IOException e) {
				e.printStackTrace();
			} // bloc catch

		} // finally
		
		
		
	} // main

} // class
