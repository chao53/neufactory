package model;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import entity.*;
import frame.*;

public class Equipment_model {

	Gson gson = new Gson();
	ArrayList<User> User_list = new ArrayList<User>();
	ArrayList<Equipment> Equipment_list = new ArrayList<Equipment>();
	ArrayList<Factory> Factory_list = new ArrayList<Factory>();
	ArrayList<Order> Order_list = new ArrayList<Order>();
	ArrayList<Product> Product_list = new ArrayList<Product>();

	public void refresh() {
		BufferedReader in0;
		BufferedReader in1;
		BufferedReader in2;
		BufferedReader in3;
		BufferedReader in4;
		try {
			in0 = new BufferedReader(new InputStreamReader(new FileInputStream("file//Users.txt")));
			String line0;
			User_list.clear();
			while ((line0 = in0.readLine()) != null) {
				String jsonString = line0;
				User user2 = gson.fromJson(jsonString, User.class);
				User_list.add(user2);
			}
			in0.close();

			in1 = new BufferedReader(new InputStreamReader(new FileInputStream("file//Equipments.txt")));
			String line1;
			Equipment_list.clear();
			while ((line1 = in1.readLine()) != null) {
				String jsonString = line1;
				Equipment Equipment2 = gson.fromJson(jsonString, Equipment.class);
				Equipment_list.add(Equipment2);
			}
			in1.close();

			in2 = new BufferedReader(new InputStreamReader(new FileInputStream("file//Factorys.txt")));
			String line2;
			Factory_list.clear();
			while ((line2 = in2.readLine()) != null) {
				String jsonString = line2;
				Factory Factory2 = gson.fromJson(jsonString, Factory.class);
				Factory_list.add(Factory2);
			}
			in2.close();

			in3 = new BufferedReader(new InputStreamReader(new FileInputStream("file//Orders.txt")));
			String line3;
			Order_list.clear();
			while ((line3 = in3.readLine()) != null) {
				String jsonString = line3;
				Order Order2 = gson.fromJson(jsonString, Order.class);
				Order_list.add(Order2);
			}
			in3.close();

			in4 = new BufferedReader(new InputStreamReader(new FileInputStream("file//Products.txt")));
			String line4;
			Product_list.clear();
			while ((line4 = in4.readLine()) != null) {
				String jsonString = line4;
				Product Product2 = gson.fromJson(jsonString, Product.class);
				Product_list.add(Product2);
			}
			in4.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add_equipment(String name, String description, String factory, String user_id, int p) {
		if (factory.equals("产能中心") && p != 3) {
			Warning.getInstance().notmain(16);
		} else {
			String id = "E" + String.format("%03d", Equipment_list.size() + 1);
			Equipment ta = new Equipment(id, name, description, factory, user_id);
			Equipment_list.add(ta);
			PrintWriter out1;
			try {
				out1 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Equipments.txt", true))));
				out1.println(gson.toJson(ta));
				out1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Equipment_man.getInstance().isVisible()) {
				Equipment_man.getInstance().setVisible(false);
				Equipment_man.getInstance().dispose();
				Equipment_man.getInstance().notmain(user_id, p);
			}else if(Factory_equipment.getInstance().isVisible()) {
				Factory_equipment.getInstance().setVisible(false);
				Factory_equipment.getInstance().dispose();
				Factory_equipment.getInstance().notmain(factory,user_id, p);
			}
			Notification.getInstance().notmain(5);
		}
	}

	public DefaultTableModel equipments_table() {
		String[] cols = { "ID", "名称", "描述", "所属", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Equipment_list.size(); i++) {
			String state = null;
			switch (Equipment_list.get(i).getState()) {
			case 2:
				state = "开启";
				break;
			case 1:
				state = "停用";
				break;
			case 0:
				state = "已删除";
				break;
			}
			dt.addRow(new String[] { Equipment_list.get(i).getId(), Equipment_list.get(i).getName(),
					Equipment_list.get(i).getDescription(), Equipment_list.get(i).getFactory(), state });
		}
		return dt;
	}

	public void del_equipment(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(17);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Equipment_list.size(); i1++) {
				if (id.equals(Equipment_list.get(i1).getId())) {
					if (Equipment_list.get(i1).getState() == 0) {
						Warning.getInstance().notmain(19);
					} else if (Equipment_list.get(i1).getOwner().equals(user_id) == false && p != 3) {
						Warning.getInstance().notmain(18);
					} else {
						Equipment_list.get(i1).changeState(0);
						PrintWriter out1;
						PrintWriter out2;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Equipments.txt"))));
							out1.println(gson.toJson(Equipment_list.get(0)));
							out1.close();

							out2 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Equipments.txt", true))));
							for (int i2 = 1; i2 < Equipment_list.size(); i2++) {
								out2.println(gson.toJson(Equipment_list.get(i2)));
							}
							out2.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(Equipment_man.getInstance().isVisible()) {
							Equipment_man.getInstance().setVisible(false);
							Equipment_man.getInstance().dispose();
							Equipment_man.getInstance().notmain(user_id, p);
						}else if(Factory_equipment.getInstance().isVisible()) {
							Factory_equipment.getInstance().setVisible(false);
							Factory_equipment.getInstance().dispose();
							Factory_equipment.getInstance().notmain(Equipment_list.get(i1).getFactory(),user_id, p);
						}
						
						Notification.getInstance().notmain(3);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(7);
			}
		}
	}

	public void change_equipment0(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(22);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Equipment_list.size(); i1++) {
				if (id.equals(Equipment_list.get(i1).getId())) {
					if (p != 3 && Equipment_list.get(i1).getOwner().equals(user_id) == false) {
						Warning.getInstance().notmain(23);
					} else {
						Change_equipment.getInstance().notmain(id, user_id, p);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(19);
			}
		}
	}

	public void change_equipment(String id, String description, String user_id, int p) {
		
			for (int i1 = 0; i1 < Equipment_list.size(); i1++) {
				if (id.equals(Equipment_list.get(i1).getId())) {
					Equipment_list.get(i1).changeDescription(description);
				}
			}
			PrintWriter out1;
			PrintWriter out2;
			try {
				out1 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Equipments.txt"))));
				out1.println(gson.toJson(Equipment_list.get(0)));
				out1.close();

				out2 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Equipments.txt", true))));
				for (int i2 = 1; i2 < Equipment_list.size(); i2++) {
					out2.println(gson.toJson(Equipment_list.get(i2)));
				}
				out2.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Equipment_man.getInstance().setVisible(false);
			Equipment_man.getInstance().dispose();
			Equipment_man.getInstance().notmain(user_id, p);
			Notification.getInstance().notmain(4);
		
	}
	
	public void switch_equipment(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(20);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Equipment_list.size(); i1++) {
				if (id.equals(Equipment_list.get(i1).getId())) {
					if (Equipment_list.get(i1).getState() == 0) {
						Warning.getInstance().notmain(19);
					} else if (Equipment_list.get(i1).getOwner().equals(user_id) == false && p != 3) {
						Warning.getInstance().notmain(21);
					} else {
						if (Equipment_list.get(i1).getState() == 2) {
							Equipment_list.get(i1).changeState(1);
						} else if (Equipment_list.get(i1).getState() == 1) {
							Equipment_list.get(i1).changeState(2);
						}

						PrintWriter out1;
						PrintWriter out2;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Equipments.txt"))));
							out1.println(gson.toJson(Equipment_list.get(0)));
							out1.close();

							out2 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Equipments.txt", true))));
							for (int i2 = 1; i2 < Equipment_list.size(); i2++) {
								out2.println(gson.toJson(Equipment_list.get(i2)));
							}
							out2.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(Equipment_man.getInstance().isVisible()) {
							Equipment_man.getInstance().setVisible(false);
							Equipment_man.getInstance().dispose();
							Equipment_man.getInstance().notmain(user_id, p);
						}else if(Factory_equipment.getInstance().isVisible()) {
							Factory_equipment.getInstance().setVisible(false);
							Factory_equipment.getInstance().dispose();
							Factory_equipment.getInstance().notmain(Equipment_list.get(i1).getFactory(),user_id, p);
						}
						Notification.getInstance().notmain(6);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(7);
			}
		}
	}

	public DefaultTableModel search_equipment(String key) {
		String[] cols = { "ID", "名称", "描述", "所属", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Equipment_list.size(); i++) {
			if (Search.getInstance().isMatch(key, Equipment_list.get(i).getName())) {
				String state = null;
				switch (Equipment_list.get(i).getState()) {
				case 2:
					state = "开启";
					break;
				case 1:
					state = "停用";
					break;
				case 0:
					state = "已删除";
					break;
				}
				dt.addRow(new String[] { Equipment_list.get(i).getId(), Equipment_list.get(i).getName(),
						Equipment_list.get(i).getDescription(), Equipment_list.get(i).getFactory(), state });
			}
		}
		return dt;
	}

	private Equipment_model() {

	}

	public static Equipment_model instance = new Equipment_model();

	public static Equipment_model getInstance() {
		return instance;
	}

}
