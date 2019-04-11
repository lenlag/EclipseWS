package ui.model;

import java.util.List;

import javax.swing.AbstractListModel;

public class MyModel extends AbstractListModel<String>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> list;
	
	public MyModel (List<String> list) {
		this.list = list;
	}
	@Override
	public int getSize() {
		return list.size();
	}

	@Override
	public String getElementAt(int index) {
		return list.get(index);
	}


}
