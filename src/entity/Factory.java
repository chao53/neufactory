package entity;

import java.util.ArrayList;

public class Factory {

	private String id;
	private String name;
	private String administrator;
	private String description;
	private ArrayList<String> Eq_list = new ArrayList<String>();
	private int state = 1;

	public Factory(String id, String name, String administrator, String description) {
		this.id = id;
		this.name = name;
		this.administrator = administrator;
		this.description = description;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getAdministrator() {
		return administrator;
	}
	
	public String getDescription() {
		return description;
	}

	public ArrayList<String> getEq_list(){
		return Eq_list;
	}

	public int getState() {
		return state;
	}

	public void changeAdministrator(String administrator) {
		this.administrator = administrator;
	}
	
	public void changeDescription(String description) {
		this.description = description;
	}
	
	public void changeState(int state) {
		this.state = state;
	}

}
