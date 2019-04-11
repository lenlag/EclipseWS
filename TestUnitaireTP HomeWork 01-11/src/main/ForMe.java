package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ForMe {

	public static void main(String[] args) throws Exception {
		String path = "src/file/doc.txt";
		MyFileManager mf = new MyFileManager(path);

		MyFileManagerV2 mf2 = new MyFileManagerV2(path);
		List<String> myList = mf.list(); 
		for (String str : myList) {
			System.out.println(str);
		}
		
		
		int somme = 0;
		String[] myListString = mf2.getList().toArray(new String[0]);
		for (String s : myListString) {
			int length = s.length();
			somme += length + "\r\n".length();	
		}
		System.out.println(somme);


	/*	int t = mf2.getLineTerminatorLength(path);
		System.out.println(t); */
		
		File file = new File (path);
		long length = file.length();
		System.out.println(length);

		long s = mf.size();
		System.out.println(s);
		
		
		String line = "Our mutual friend";
		mf.append(line);
		 		
	//	mf.load(path);
		myList = mf.list(); 
		for (String str : myList) {
			System.out.println(str);
		}
	

		
	}
}
