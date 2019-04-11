package business.entity;

public class Specie {

	private long id;
	private String commonName;
	private String latinName;
	
	
	
	public Specie(long id,String commonName, String latinName) {
		
		this.id = id;
		this.commonName = commonName;
		this.latinName = latinName;
		
	}


	public String getCommonName() {
		return commonName;
	}


	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}


	public String getLatinName() {
		return latinName;
	}


	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Specie [commonName=" + commonName + ", latinName=" + latinName + ", id=" + id + "]";
	}
	
	



	
}
