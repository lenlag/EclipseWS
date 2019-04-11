package main;

public class Fichier {


	public void open () throws Exception { // ça peut envoyer exception
		// throw Exception; // ça l'envoie vraiment
	}

	public void close () throws Exception {

	}

	public void read () throws Exception {

	}

	public void write () throws Exception{

	}

	public Fichier () {	
	} // constructeur => pour pouvoir instancier Fichier

	public static void main(String[] args) {

		Fichier fichier = new Fichier (); // cliquer sur l'erreur, choisir "surround with try/catch"
		try {
			fichier.open();
			fichier.read(); // s'il y a une erreur sur read, le fichier ne sera jamais fermé
			fichier.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // imbriqué
				fichier.close (); // donc, il faut imbriquer fichier.close => pour que le fichier soit fermé en tous les cas de figure, passage obligatoire par cette étape !!!
			} catch (Exception e) {
				e.printStackTrace();

			} // try imbriqué

		} // try

	} // main

} // class
