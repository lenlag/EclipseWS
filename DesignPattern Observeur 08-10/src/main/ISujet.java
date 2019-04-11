package main;

public interface ISujet {

	public void addObserver (IObservateur iobs);
	
	public void removeObserver (IObservateur iobs);
	
	public void notifyObservers(); // dans une boucle elle appelle observeur.actualiser(temp, hm)
	
}
