package objets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class NetLister implements ILister {

	@Override
	public List<String> list() throws IOException {

		URL url = new URL ("http://www.lefigaro.fr"); //classe URL extends Object
		URLConnection link;
		link = url.openConnection(); // Returns a URLConnection instance that represents a connection to the remote object referred to by the URL

		InputStream is = url.openConnection().getInputStream();


		BufferedReader br = null;
		List <String> maliste = new ArrayList<String> ();
		String a;

		try {
			br = new BufferedReader (new InputStreamReader(is));

			while ((a = br.readLine())!=null) {

				maliste.add(a);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br!=null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return maliste;
	}


	@Override
	public void display() {
		System.out.println("F-on display de NetLister");


	}

}
