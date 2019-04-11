package main;

import java.util.ArrayList;
import java.util.List;

public class Sujet implements ISujet {
	
	

	List<IObservateur> maliste = new ArrayList<>(); // on cr�e une liste pour stocker les observateurs
	private int hum;
	private int temp;
	
	
	@Override
	public void notifyObservers() {
		
		for (IObservateur n : maliste) // pour parcourir la liste
		n.actualiser(temp, hum);
		
	}

	

	@Override
	public void addObserver(IObservateur iobs) {
		maliste.add(iobs); // on rajoute l'observateur dans la liste cr��
		
	}

	@Override
	public void removeObserver(IObservateur iobs) {
		maliste.remove(iobs); // pour supprimer l'observateur de la liste
	
	}
	
	
	public void miseAJour (int temp, int hum) {
		this.temp=temp;
		this.hum=hum;
		notifyObservers(); // des que la m�j faite, on notifie les 2 observeurs

	}

}
