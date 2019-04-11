package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {

		public FileManager () {

		}

	public void save (IObject o) {
		
		File f = new File ("folder/" + o.getId());
		PrintWriter pw = null;

		try {
			pw= new PrintWriter(f);

			pw.println(o.stringToFile());

		} catch (IOException e){ 
			System.out.println("Erreur lors de l'écriture: " + e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	public void load (IObject o) throws Exception {

		BufferedReader br  = null;
		String line;

		try {
			br = new BufferedReader (new FileReader("folder/" + o.getId()));
			line = br.readLine();
			o.processStringFromFile(line);

			


		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}	finally {
			try {
				if (br !=null) {
					br.close();
				}

			} catch  (IOException e) {
				e.printStackTrace();
			}


		}



	}


}
