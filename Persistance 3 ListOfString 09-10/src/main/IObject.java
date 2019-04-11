package main;

import java.util.List;

public interface IObject {
	
	public List <String> stringToFile ();
	
	public void processStringFromFile (List <String> s);
	
	public int getId ();
	

}
