package business.entity;

public class Animal {
	
	private String name;
	private String sex;
	private String coatColor;
	private long id;
	private Specie specie; // objet specie pour avoir "nomSpecie" directement // aggregation
	
	public Animal(String name, String sex, String coatColor, long id, Specie specie) {


		this.name = name;
		this.sex = sex;
		this.coatColor = coatColor;
		this.id = id;
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCoatColor() {
		return coatColor;
	}

	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Specie getSpecie() {
		return specie;
	}

	public void setSpecie(Specie specie) {
		this.specie = specie;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", sex=" + sex + ", coatColor=" + coatColor + ", id=" + id + ", specie="
				+ specie + "]";
	}
	
	

	}