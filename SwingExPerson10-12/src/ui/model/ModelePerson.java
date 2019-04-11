package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

import entity.PersonDTO;

public class ModelePerson extends AbstractListModel<PersonDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PersonDTO> list;

	
	public ModelePerson (List<PersonDTO> list) {
		this.list = list;
	}
	
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public PersonDTO getElementAt(int index) {
		return list.get(index);
	}

	

}
