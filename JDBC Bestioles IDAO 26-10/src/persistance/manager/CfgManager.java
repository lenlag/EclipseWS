package persistance.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class CfgManager implements ICfgManager {

	public static final String OTHER_CFG_FILE = "OTHER_CFG_FILE";
	public static final String EXTERNAL_CFG_FILE = "EXTERNAL_CFG_FILE";

	//	private final File file = new File ("src/files/cfg.ini");

	private static Properties p = null;
	private static CfgManager INSTANCE = null;

	protected CfgManager () throws Exception {
		p = new Properties();
		String path = System.getProperty(OTHER_CFG_FILE);
		if(path != null) {
			p.load(this.getClass().getClassLoader().getResourceAsStream(path));
		} else {
			path = System.getProperty(EXTERNAL_CFG_FILE);
			if (path != null) {
				p.load (new FileInputStream(path));
			} else {
				p.load(this.getClass().getClassLoader().getResourceAsStream("files/cfg.ini"));
			}
		}

	}

	public static CfgManager getInstance () throws Exception {
		if (INSTANCE == null) {
			INSTANCE = new CfgManager ();
		}
		return INSTANCE;
	}


	@Override
	public Properties getCfg() { // f-on pour extraire les propriétés
		return p;
	}





}
