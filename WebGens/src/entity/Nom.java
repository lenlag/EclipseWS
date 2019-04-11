package entity;

public class Nom {
	
	private String name;
	
	public Nom(String name) {
		this.name=name;
	}

	public Nom() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Nom [name=" + name + "]";
	}
	
	
}
