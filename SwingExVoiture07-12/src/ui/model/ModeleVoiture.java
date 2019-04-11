package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

import entity.BagnoleEntity;


public class ModeleVoiture extends AbstractListModel<BagnoleEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<BagnoleEntity> list;

	
	public ModeleVoiture (List<BagnoleEntity> list) {
		this.list = list;
	}
	
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public BagnoleEntity getElementAt(int index) {
		return list.get(index);
	}

	

}
