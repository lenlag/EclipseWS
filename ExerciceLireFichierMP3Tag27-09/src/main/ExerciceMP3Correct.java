package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExerciceMP3Correct {

	public void openfile () throws FileNotFoundException, IOException {
	}

	public static void main(String[] args) {



		FileInputStream fis = null;
		String path = "mp3/muzik.mp3";

		File file = new File (path);
		file.length(); // pour avoir la taille du fichier

		long lengthFile = new File(path).length();
		System.out.println("La taille de notre fichier : " + lengthFile);


		try {
			fis = new FileInputStream(path);
			fis.skip(lengthFile - 128);

			byte [] bs = new byte [3]; // on prend les 3 bytes des 128 derniers // 3 = tag ident-on
			fis.read(bs);
			String text1 = new String (bs, "UTF-8"); // on les transforme en String + codage UTF-8 en paramètre
			
			// System.out.println(text1); // pas besoin de marquer la tag
			
			bs = new byte [30]; // Title
			fis.read(bs);
			String text2 = new String (bs).trim(); // trim pour enlever les blancs, UTF8 pas besoin, car ce sont des caractères anglais
			
			System.out.println(text2);
			
			
			bs = new byte [30]; // Artiste
			fis.read(bs);
			String text3 = new String (bs).trim(); 
			
			System.out.println(text3);
			
			bs = new byte [30]; // Album
			fis.read(bs);
			String text4 = new String (bs).trim(); 
			
			System.out.println(text4);
			
			bs = new byte [4]; // Year
			fis.read(bs);
			String text5 = new String (bs).trim(); 
			
			System.out.println(text5);
			
			bs = new byte [30]; // Comment
			fis.read(bs);
			String text6 = new String (bs).trim(); 
			
			System.out.println(text6);
			
			bs = new byte [1]; // Genre
			fis.read(bs);
			String text7 = new String (bs).trim(); 
			
			System.out.println(text7);
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			}
			catch  (IOException e) {
				e.printStackTrace();
			}

		}

	}

	private static void IOException() {
		// TODO Auto-generated method stub

	} // main

} // class
