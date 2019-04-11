package persistence.manager;

import java.util.Properties;

public class TEST {

	public static void main(String[] args) throws Exception {
		
		
	//	System.out.println(CfgManager.getInstance().getCfg());
		if(false) {
			System.setProperty(CfgManager.EXTERNAL_CFG_FILE, "c:\\data\\cfg.ini");
			Properties cfg = CfgManager.getInstance().getCfg();
			System.out.println(cfg);
		} else {
			System.setProperty(CfgManager.OTHER_CFG_FILE, "files/cfg2.ini");
			Properties cfg = CfgManager.getInstance().getCfg();
			System.out.println(cfg);
		}
		

		}

}
