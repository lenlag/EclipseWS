package factory;

import service.IService;
import service.ServiceDAOnoSql;

public class Factory {
	
	private static Factory factory = null;
	private String klass;
	
	public static Factory getNewInstance () {
		if (factory == null) {
			factory = new Factory ();
		}
		return factory;
	}
	
/*
	public IService create() { // cette Factory renvoie IService
		return new ServiceDAOsql();
	}
	
*/	
	public IService create() {
		return new ServiceDAOnoSql();
	}
	

}
