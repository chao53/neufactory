package entity;

public class Equipment {
	
	private String id;
	private String name;
	private String description;
	private String factory;
	private String owner;
	int state = 2;
	
	public Equipment(String id,String name,	String description, String factory, String owner) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.factory = factory;
		this.owner = owner;
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
	
	public String getFactory() {
		return factory;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getState() {
		return state;
	}
	
	public void changeDescription(String description) {
		this.description = description;
	}
	
	public void changeState(int state) {
		this.state = state;
	}
}
