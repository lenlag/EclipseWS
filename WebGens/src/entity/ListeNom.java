package entity;

import java.util.ArrayList;
import java.util.List;

public class ListeNom {

	
	private List<Nom> nameList = new ArrayList<Nom>();
	

	public ListeNom() {
		
	}

	public List<Nom> getNameList() {
		return nameList;
	}

	public void setNameList(List<Nom> nameList) {
		this.nameList = nameList;
	}
	
	public void add(Nom nom) {
		
			nameList.add(nom);
				
	}
	
	public void delete(int index) {
		nameList.remove(index);
	}

	@Override
	public String toString() {
		return "ListeNom [nameList=" + nameList + "]";
	}
	
	
}
