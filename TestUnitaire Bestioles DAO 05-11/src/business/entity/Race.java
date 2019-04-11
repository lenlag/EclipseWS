package business.entity;

public class Race {
	
	private long id;
	private String name;
	private int price;
	private String comments;
	
	
	public Race(long id, String name, int price, String comments) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.comments = comments;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", price=" + price + ", comments=" + comments + "]";
	}
	
	
	
	
	
	

}
