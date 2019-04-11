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

public class MyFileManagerV2 {


	private String path;
	List <String> list = new ArrayList<String>();


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}



	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}


	public MyFileManagerV2 () {

	}	


	public MyFileManagerV2 (String path) throws IOException {	//constructeur - charge le fichier en paramètre	
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



	public List <String> list () {
		for (String s : list) {
			System.out.println(s);
		}
		return list;
	}




	public long size () throws IOException { 
		LineNumberReader lineNumberReader = new LineNumberReader (new FileReader(this.path));
		String h;
		int l;
		int somme = 0;
		int a;
		while ((h = lineNumberReader.readLine())!=null) {
			l = h.length();
			somme += l;
			a  = lineNumberReader.getLineNumber();
		}
		return somme;	
	}
	/*	String line;
	String separateur = "\r\n";
	int sep = separateur.length();
	int l;
	int somme = 0;
	try {
		
		while ((line = br.readLine())!=null) { 	
							
		l =	line.length();
			somme += l + sep; 
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw e;

	} catch (IOException e) {
		e.printStackTrace();
		throw e;

	}	finally {
		if (br !=null) {
		//	br.close();
		} 
	}
	return somme;
*/			
	

	public int getLineTerminatorLength( String filePath ) throws Exception 	{
		BufferedReader br = null;
		try  {	
			br = new BufferedReader(new FileReader(this.path));
					String l = "";
			char termChar = ' ';

			while ( ( termChar = (char) br.read() ) != -1 )
			{

				if ( ( termChar == '\n' ) || ( termChar == '\r' ) )
				{
					char ctwo = ' ';
					if ( ( ctwo = (char) br.read() ) != -1 )
					{
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
		RandomAccessFile raf = new RandomAccessFile (path, "rw");
		raf.skipBytes((int) this.size());
		raf.writeBytes("\r" + line);



	}

	public void remove (String line) {

	}





}
