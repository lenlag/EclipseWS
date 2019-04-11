package process;

import java.io.FileInputStream;
import java.util.Properties;

import objets.ILister;

public class ListerFactory {
	
	public static ILister newInstance() throws Exception {
		
		Properties p = new Properties ();
		p.load(new FileInputStream("config/lister.cfg")); // pour telecharger le fichier de config
		String x = p.getProperty("class"); // extraction de value "class" de lister.cfg
		
		Class <?> klass = Class.forName(x); // on instancie la métaclasse klass, càd on crée un objet, donné par FQN (ici c'est le get property de config/lister.cfg qu'on a appelé string
		Object iLister = klass.newInstance();// on 
		return (ILister) iLister;
		
		
	}

	public static void main(String[] args) {
		
	}

}
