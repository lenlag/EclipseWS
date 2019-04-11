package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ExClassURL {

	
	
	public static void main(String[] args) throws IOException {
		
		
		URL url = new URL ("http://www.montpellier.fr/"); //classe URL extends Object
		URLConnection link;
		link = url.openConnection(); // Returns a URLConnection instance that represents a connection to the remote object referred to by the URL
		
		System.out.println(link);
		

		InputStream is = url.openConnection().getInputStream(); // classe abstraite, donc on ne peut pas l'instancier
		
				
		String result = ""; 
		try {
			is = url.openConnection().getInputStream(); // ouvrir fichier
			
			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { 
				byte [] bs = new byte [1024]; 
				lus = is.read (bs); 
				
				if (lus!=-1) { 
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut 0, jusqu'à la fin lus = nbre des car-s réelement lus)
					
					
				} // if
				
			} // while

			System.out.println(result);
		} // bloc try
		catch (IOException e) {
			e.printStackTrace();
		} // bloc catch
		finally {
			try {
				is.close(); // car close peut lever des exceptions
				
			} catch(IOException e) {
				e.printStackTrace();
			} // bloc catch

		} // finally
			
		
		
	} // main
} // class
