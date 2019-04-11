package business.entity;

public class Equipe {
	
	private long id;
	private String name;
	private long budget;
	
	
	public Equipe(long id, String name, long budget) {
		this.id = id;
		this.name = name;
		this.budget = budget;
	}
	
	public Equipe () {
		
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

	public long getBudget() {
		return budget;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Equipe [id=" + id + ", name=" + name + ", budget=" + budget + "]";
	}
	
}
