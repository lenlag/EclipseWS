package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

import entity.ErrorItem;

public class ModeleError extends AbstractListModel<ErrorItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ErrorItem> list;
	
	

	public ModeleError(List<ErrorItem> list) {
		this.list = list;
	}

	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public ErrorItem getElementAt(int index) {
		return list.get(index);
	}

}
