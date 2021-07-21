package entity;

public class Order {
	
	private String id;
	private String name;
	private String agency;
	private String product;
	private String quantity;
	private String equipment;
	private String address;
	private String date;
	private String factory = "";
	private int state = 1;
	
	public Order(String id, String name, String agency,String product,String quantity, String equipment, String address, String date) {
		this.id = id;
		this.name = name;
		this.agency = agency;
		this.product = product;
		this.quantity = quantity;
		this.equipment = equipment;
		this.address = address;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getAgency() {
		return agency;
	}
	
	public String getProduct() {
		return product;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public String getEquipment() {
		return equipment;
	}
	
	public String getFactory() {
		return factory;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getState() {
		return state;
	}
	
	public void changeQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public void changeAddress(String address) {
		this.address = address;
	}
	
	public void changeDate(String date) {
		this.date = date;
	}
	
	public void changeFactory(String factory) {
		this.factory = factory;
	}
	
	public void changeState(int state) {
		this.state = state; 
	}
	
	
}
