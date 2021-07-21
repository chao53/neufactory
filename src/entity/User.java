package entity;

public class User {

	private String id;
	private String password;
	private String number;
	private int power;
	private int exist = 1;

	public User(String id, String password, String number, int power) {
		this.id = id;
		this.password = password;
		this.number = number;
		this.power = power;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getNumber() {
		return number;
	}

	public int getPower() {
		return power;
	}
	
	public int getExist() {
		return exist;
	}

	public void changeNumber(String number) {
		this.number = number;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public void changePower(int power) {
		this.power = power;
	}

	public void changeExist(int exist) {
		this.exist = exist;
	}
}