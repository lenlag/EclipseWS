package main;

public class SubSystem {
	
	public SubSystem (String message ) {
		
	} // constructeur
	
	public SubSystem () {
		
	} // constructeur vide pour pouvoir cr�er un objet de cette classe dans une autre classe

	
	public void config () throws ConfigException{
			throw new ConfigException ("This function throws a foreseeable Exception"); // fait � partir du constructeur de INITEException
	
	} // m�thode config
	
} // class
