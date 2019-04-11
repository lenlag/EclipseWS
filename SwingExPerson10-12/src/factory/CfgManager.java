package factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CfgManager {
	
	CfgData data;
	private List<CfgData> myList = new ArrayList<>();
	
	private int chosen; //par index
	
	private static String CfgPath = "config/file.cfg";
	
	
	public String read(String fileToRead) {
		FileInputStream	fis = null;
		
		String result = "";
		
		try {
			fis = new FileInputStream(fileToRead); // lecture fichier
			
			int lus = 0; // nombre de caractères réelement lus

			while (lus != -1) { // tant qu'il y a des caracteres à lire
				byte [] bs = new byte [1024]; 
				try {
					lus = fis.read (bs);
				} catch (IOException e) {
					e.printStackTrace();
				} 
				
				if (lus!=-1) { 
					String txt = new String(bs, 0, lus);
					result +=  txt;// pour concatener le resultat dans une chaine (bs, debut => 0, jusqu'à la fin=> lus = nbre des car-s réelement lus)						
				} // if
			} // while

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	try {
			fis.close();						//fermeture fichier
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		
			
	}
	
	public void load () {
		String initial = read(CfgPath);
		
		String [] lines = initial.split("\r\n"); //on separe le text d'abord par lignes (\r\n)
	
		List<String[]> myLines = new ArrayList<>();
		
		for (String l : lines) {
			myLines.add(l.split(",")); //on separe les lignes par ,
		}
	
		
		// data.setDisplay(myLines [0]);
		
		//	myList.add(new CfgData("", ""));
		
		
	}
	
	


}
