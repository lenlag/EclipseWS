package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

public class TestMyFileManager extends TestCase {
	
	String path = "src/file/doc.txt";
	MyFileManager mf;
	int sizeInit;
	int nbLignesInit;
	
	
	@Override
	protected void setUp() throws Exception {  // on crée un jeu de données de test
		super.setUp();
		mf = new MyFileManager(path);
		sizeInit = 106;
		nbLignesInit = 5;
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	
	
	// test
	public void testSize () throws IOException {
		File file = new File(path);
		assertEquals(file.length(), mf.size());
	}


	public void testList () throws FileNotFoundException, IOException {
		assertEquals(nbLignesInit, mf.list().size());
		
	}

	public void testAppend () throws IOException {
		String s = "Our mutual friend";
		mf.append(s);
		assertEquals(nbLignesInit+1, mf.list().size());
		
	}

}
