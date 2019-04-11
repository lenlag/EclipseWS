package objets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLister implements ILister {

	@Override
	public List<String> list() throws IOException {


		BufferedReader br = null;
		List <String> maliste = new ArrayList<String> ();
		String a;

		try {
			br = new BufferedReader (new FileReader("fichier/fichier.txt"));

			while ((a = br.readLine())!=null) {

				//System.out.println("Ligne lue : " + a);
				maliste.add(a);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}

		return maliste;
	}

	@Override
	public void display() {
		System.out.println("Fonction display de la Classe FileLister");

	}

}
