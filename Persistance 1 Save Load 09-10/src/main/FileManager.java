package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManager {

	private String separateur;

	private List<String> l = new ArrayList<String>();


	public FileManager (String separateur) {

		this.separateur = separateur;
	}

	public void save (Person p) {
		String s = p.getFirstName() + "," + p.getLastName() + ","  + p.getAge() + "," + p.getAddress().getAdresse() +  "," + p.getAddress().getZipCode() +"," + p.getAddress().getCity();


		File f = new File ("folder/" + p.getId());
		PrintWriter pw = null;

		try {
			pw= new PrintWriter(f);

			pw.println(s);

		} catch (IOException e){ 
			System.out.println("Erreur lors de l'écriture: " + e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	public void load (Person p) throws Exception {

		BufferedReader br  = null;
		String line;

		try {
			br = new BufferedReader (new FileReader("folder/" + p.getId()));
			line = br.readLine();
			String [] a = line.split(separateur);
			p.setFirstName(a[0]);
			p.setLastName(a[1]);
			p.setAge(Integer.parseInt (a[2]));
			p.setAddress(new Address ());
			p.getAddress().setAdresse(a[3]);
			p.getAddress().setZipCode(Integer.parseInt(a[4]));
			p.getAddress().setCity(a[5]);

			


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
