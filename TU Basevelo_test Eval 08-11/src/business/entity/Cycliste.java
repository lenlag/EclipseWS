package business.entity;

public class Cycliste {
	
	private long id;
	private String name;
	private Equipe equipe;
	private int nombre_velos;
	
	
	public Cycliste(long id, String name, Equipe equipe, int nombre_velos) {
		this.id = id;
		this.name = name;
		this.equipe = equipe;
		this.nombre_velos = nombre_velos;
	}
	
	public Cycliste () {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public int getNombre_velos() {
		return nombre_velos;
	}

	public void setNombre_velos(int nombre_velos) {
		this.nombre_velos = nombre_velos;
	}

	@Override
	public String toString() {
		return "Cycliste [id=" + id + ", name=" + name + ", equipe=" + equipe + ", nombre_velos=" + nombre_velos + "]";
	}
		
}
