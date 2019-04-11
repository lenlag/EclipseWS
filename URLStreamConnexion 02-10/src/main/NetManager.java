package main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetManager {


	private String url;

	public NetManager (String url) {
		this.url = url;
	}

	public void display () throws IOException {

		URL url1 = new URL (url); //classe URL extends Object
		URLConnection link;
		link = url1.openConnection(); // Returns a URLConnection instance that represents a connection to the remote object referred to by the URL

		System.out.println(link);

		InputStream is = url1.openConnection().getInputStream(); // classe abstraite, donc on ne peut pas l'instancier

		String result = ""; 
		try {
			is = url1.openConnection().getInputStream(); // ouvrir fichier

			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { 
				byte [] bs = new byte [1024]; 
				lus = is.read (bs); 

				if (lus!=-1) { 
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut 0, jusqu'à la fin lus = nbre des car-s réelement lus)
				} 
			} 
			System.out.println(result);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (is != null) {
					is.close(); 
				}
			} catch(IOException e) {
				e.printStackTrace();
			} 
		} 
	}

	public int count (String balise) {
		//display (); // modif pour que ça renvoie une chaine
		return 0;

	}

	public static void main(String[] args) throws IOException {
		NetManager nm = new NetManager ("http://www.montpellier.fr/");
		nm.display ();


	}

}
