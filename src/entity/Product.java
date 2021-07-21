package entity;

public class Product {

	private String id;
	private String name;
	private String description;
	private int exist = 1;

	public Product(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getExist() {
		return exist;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public void changeDescription(String description) {
		this.description = description;
	}

	public void changeExist(int exist) {
		this.exist = exist;
	}

}
