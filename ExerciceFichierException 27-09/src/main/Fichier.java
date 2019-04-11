package main;

public class Fichier {


	public void open () throws Exception { // �a peut envoyer exception
		// throw Exception; // �a l'envoie vraiment
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
			fichier.read(); // s'il y a une erreur sur read, le fichier ne sera jamais ferm�
			fichier.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { // imbriqu�
				fichier.close (); // donc, il faut imbriquer fichier.close => pour que le fichier soit ferm� en tous les cas de figure, passage obligatoire par cette �tape !!!
			} catch (Exception e) {
				e.printStackTrace();

			} // try imbriqu�

		} // try

	} // main

} // class
