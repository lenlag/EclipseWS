package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

public class ModeleVoiture extends AbstractListModel<Voiture> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Voiture> myList;
	
	public ModeleVoiture (List<Voiture> myList) {
		this.myList = myList;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return myList.size();
	}

	@Override
	public Voiture getElementAt(int index) {
		// TODO Auto-generated method stub
		return myList.get(index);
	}

	


}
