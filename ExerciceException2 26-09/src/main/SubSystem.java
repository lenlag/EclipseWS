package main;

public class SubSystem {
	
	public SubSystem (String message ) {
		
	} // constructeur
	
	public SubSystem () {
		
	} // constructeur vide pour pouvoir créer un objet de cette classe dans une autre classe

	
	public void config () throws ConfigException{
			throw new ConfigException ("This function throws a foreseeable Exception"); // fait à partir du constructeur de INITEException
	
	} // méthode config
	
} // class
