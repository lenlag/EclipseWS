package main;

public class Machine {

	private SubSystem sub = new SubSystem ();

	public void init() throws INITException {
		throw new INITException ("This function throws a foreseeable Exception"); // fait à partir du constructeur de INITEException
	}


	public Machine() {
	} // constructeur

	public void process () throws ProcessException {
		throw new ProcessException ("This function throws a foreseeable Exception"); // à partir du constructeur
	}

	public void config () throws MachineConfigException {

		SubSystem sub = new SubSystem ();

		try {
			sub.config();
		} catch (ConfigException ex) {
			ex.printStackTrace();
			System.out.println("Erreur SubSystemConfigException ");
			throw new MachineConfigException ();// methode dans la methode
		} finally {
		} // try
	} // methode config
	
} // class



