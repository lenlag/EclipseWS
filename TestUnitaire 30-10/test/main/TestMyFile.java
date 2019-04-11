package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestMyFile extends TestCase {

	String path = "src/file/doc.txt";
	String val = "Coucou";
	MyFile mf = new MyFile();
	File file = new File(path);
	List<String> myList = new ArrayList<String> ();
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		 if (!file.exists()) {
			 file.createNewFile();
		 }
		 
	
	}

	public void test_write () throws Exception {
		mf.writeFile(path, val);
		assertEquals(file.length(), val.length()+"\r\n".length()); // on rajoute le separateur, car pw.println
	}

	public void test_read () throws IOException {
		mf.readFile(path);
		
	}
	
	public void test_delete () {
		mf.removeFile(path);
		assertEquals(0, file.length());
	}

}
