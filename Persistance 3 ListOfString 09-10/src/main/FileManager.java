package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileManager {
	
	final static String separateur = ",";

	public FileManager () {

	}

	public void save (IObject o) {

		List<String> s = o.stringToFile();
		String t = "";
		
		for(String h : s) {
			t+= h + separateur;
		}
		
		t = t.substring(0,t.length()-1);
		
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
			String [] a = line.split(",");
			o.processStringFromFile(List<String>);




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



