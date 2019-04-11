package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MyFile {

	public void writeFile (String path_fichier, String val) throws Exception {
		PrintWriter pw = new PrintWriter (path_fichier);
		pw.println(val);
		pw.close();

	}

	public void readFile(String path_fichier) throws IOException {
		BufferedReader br = null; 
		String line;
		List<String> myList = new ArrayList<String>();
		try {
			br = new BufferedReader (new FileReader(path_fichier));
			while ((line=br.readLine()) != null) {
				myList.add(line);	
			}
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
			}
			catch  (IOException e) {
				e.printStackTrace();
			}
		}
		for (String x: myList) {
			System.out.println(x);
		}
	}

	public void removeFile(String path_fichier) {
		File file = new File (path_fichier);
		file.delete();
	}

}
