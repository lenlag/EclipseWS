package process;

import java.io.FileInputStream;
import java.util.Properties;

import objets.IDisplay;

public class DisplayFactory {


	public static IDisplay newInstance() throws Exception {

		Properties p = new Properties ();
		p.load(new FileInputStream("config/lister.cfg")); // pour telecharger le fichier de config
		String z = p.getProperty("class2"); // extraction de value "class" de lister.cfg

		Class <?> klass2 = Class.forName(z); // on instancie la m�taclasse klass, c�d on cr�e un objet, donn� par FQN (ici c'est le get property de config/lister.cfg qu'on a appel� string
		Object iDisp = klass2.newInstance();// on 
		return (IDisplay) iDisp;


	}

	public static void main(String[] args) {

	}

}