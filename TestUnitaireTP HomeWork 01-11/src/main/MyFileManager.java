package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyFileManager {


	private String path;
	private List <String> list = new ArrayList<String>();


	public MyFileManager (String path) throws Exception {	//constructeur - charge le fichier en paramètre	
		this.path=path;
		load (path);

	}


	private void load (String path) throws FileNotFoundException, IOException {	
		BufferedReader br = null; 
		String line;
		String separateur = "\r\n";
		int compteur = 0;
		try {
			br = new BufferedReader (new FileReader(path));
			while ((line = br.readLine())!=null) { 
				list.add(line.trim()); // trim erase "\r\n"
				compteur ++;
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

	}

	public List <String> list ()  {
		return list;
	}


	public long size () throws IOException { // !!!   renvoie la taille du fichier en faisant la somme des tailles des lignes de a liste!!!
		Long count = 0L; // pour initialiser la valeur Long à zero
		for (String string : list) {
			count += string.length() + "\r\n".length(); // on rajoute le "\r\n"
		}
		return count;
	}	


	public int getLineTerminatorLength( String filePath ) throws Exception 	{
		BufferedReader br = null;
		try  {	
			br = new BufferedReader(new FileReader(this.path));
			String l = "";
			char termChar = ' ';
			while ( ( termChar = (char) br.read() ) != -1 ) {
				if ( ( termChar == '\n' ) || ( termChar == '\r' ) ) {
					char ctwo = ' ';
					if ( ( ctwo = (char) br.read() ) != -1 ) {
						if ( ( ctwo == '\n' ) || ( ctwo == '\r' ) )
							return 2;
					}
					return 1;
				}
			}
		}
		catch ( Exception e ) {
			String errMsg = "Error reading file  " + path;
			throw new Exception( errMsg );
		}
		//Will reach here if it is empty file
		return 0;
	}


	public void append (String line) throws IOException {
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile (path, "rw");
			raf.seek(new File(path).length());
			raf.writeBytes(line + "\r\n");
		} finally {
			if (raf != null) {
				raf.close();
			}
		}
	}

	public void remove (String line) throws Exception {
		list.remove(line);
		new File(path).delete(); // on supprime le fichier initial
		for (String s : list) {
			append(s + "r\n"); // on recrée la liste , sans la ligne qu'on a supprimé
		}
	}

}
