package factory;

public class Test {

	public static void main(String[] args) {
		
		CfgManager cfg = new CfgManager();
		String s  = cfg.read("config/file.cfg");
		System.out.println(s);
	}

}
