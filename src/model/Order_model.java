package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import entity.Equipment;
import entity.Factory;
import entity.Order;
import entity.Product;
import entity.User;
import frame.Change_order;
import frame.Notification;
import frame.Order_man;
import frame.Warning;

public class Order_model {

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

	public void add_order(String name, String product, String quantity, String equipment, String address, String date,
			String user_id, int p) {
		if (p != 1 && p != 3) {
			Warning.getInstance().notmain(40);
		} else if (name == null || name.isEmpty() || product.equals("-------请选择-------") || quantity == null
				|| quantity.isEmpty() || equipment.equals("-------请选择-------") || address == null || address.isEmpty()
				|| date == null || date.isEmpty()) {
			Warning.getInstance().notmain(41);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Equipment_list.size(); i1++) {
				if (Equipment_list.get(i1).getName().equals(equipment) && Equipment_list.get(i1).getState() != 0) {
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(42);
			} else {
				int j2 = 0;
				for (int i2 = 0; i2 < Product_list.size(); i2++) {
					if (Product_list.get(i2).getName().equals(product) && Product_list.get(i2).getExist() != 0) {
						j2 = 1;
					}
				}
				if (j2 == 0) {
					Warning.getInstance().notmain(47);
				} else {
					int j3 = 0;
					for (int i3 = 0; i3 < Order_list.size(); i3++) {
						if (Order_list.get(i3).getName().equals(name)) {
							j3 = 1;
						}
					}
					if (j3 == 1) {
						Warning.getInstance().notmain(43);
					} else {
						String id = "D" + String.format("%03d", Order_list.size() + 1);
						Order ta = new Order(id, name, user_id, product, quantity, equipment, address, date);
						Order_list.add(ta);
						PrintWriter out1;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Orders.txt", true))));
							out1.println(gson.toJson(ta));
							out1.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (Order_man.getInstance().isVisible()) {
							Order_man.getInstance().setVisible(false);
							Order_man.getInstance().dispose();
							Order_man.getInstance().notmain(user_id, p);
						}
						Notification.getInstance().notmain(9);
					}
				}
			}
		}
	}

	public DefaultComboBoxModel<String> product_combobox() {
		String[] pr = { "-------请选择-------" };
		DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<String>(pr);
		for (int i = 0; i < Product_list.size(); i++) {
			cb.addElement(Product_list.get(i).getName());
		}
		return cb;
	}

	public DefaultComboBoxModel<String> equipment_combobox() {
		String[] eq = { "-------请选择-------" };
		DefaultComboBoxModel<String> cb = new DefaultComboBoxModel<String>(eq);
		for (int i = 0; i < Equipment_list.size(); i++) {
			cb.addElement(Equipment_list.get(i).getName());
		}
		return cb;
	}

	public DefaultTableModel orders_table() {
		String[] cols = { "ID", "名称", "经销商", "产品", "数量", "设备", "地址", "截止日期", "状态", "工厂" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Order_list.size(); i++) {
			String state = null;
			switch (Order_list.get(i).getState()) {
			case 0:
				state = "已删除";
				break;
			case 1:
				state = "已发布";
				break;
			case 2:
				state = "已接单";
				break;
			case 3:
				state = "已完成";
				break;
			}
			dt.addRow(new String[] { Order_list.get(i).getId(), Order_list.get(i).getName(),
					Order_list.get(i).getAgency(), Order_list.get(i).getProduct(), Order_list.get(i).getQuantity(),
					Order_list.get(i).getEquipment(), Order_list.get(i).getAddress(), Order_list.get(i).getDate(),
					state, Order_list.get(i).getFactory() });
		}
		return dt;
	}

	public void del_order(String id, String user_id, int p) {
		if (p == 2 || p == 0) {
			Warning.getInstance().notmain(44);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Order_list.size(); i1++) {
				if (id.equals(Order_list.get(i1).getId())) {
					Order_list.get(i1).changeState(0);
					PrintWriter out1;
					PrintWriter out2;
					try {
						out1 = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Orders.txt"))));
						out1.println(gson.toJson(Order_list.get(0)));
						out1.close();

						out2 = new PrintWriter(new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream("file//Orders.txt", true))));
						for (int i2 = 1; i2 < Order_list.size(); i2++) {
							out2.println(gson.toJson(Order_list.get(i2)));
						}
						out2.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Order_man.getInstance().setVisible(false);
					Order_man.getInstance().dispose();
					Order_man.getInstance().notmain(user_id, p);
					Notification.getInstance().notmain(3);
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(48);
			}
		}
	}

	public void change_order0(String id, String user_id, int p) {
		if (p == 0 || p == 2) {
			Warning.getInstance().notmain(49);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Order_list.size(); i1++) {
				if (id.equals(Order_list.get(i1).getId())) {
					if (Order_list.get(i1).getAgency().equals(user_id) == false) {
						Warning.getInstance().notmain(50);
					} else {
						Change_order.getInstance().notmain(id, user_id, p);
						j1 = 1;
					}
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(48);
			}
		}
	}

	public void change_order(String id, String address, String user_id, int p) {

		for (int i1 = 0; i1 < Order_list.size(); i1++) {
			if (id.equals(Order_list.get(i1).getId())) {
				Order_list.get(i1).changeAddress(address);
			}
		}
		PrintWriter out1;
		PrintWriter out2;
		try {
			out1 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Orders.txt"))));
			out1.println(gson.toJson(Order_list.get(0)));
			out1.close();

			out2 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Orders.txt", true))));
			for (int i2 = 1; i2 < Order_list.size(); i2++) {
				out2.println(gson.toJson(Order_list.get(i2)));
			}
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Order_man.getInstance().setVisible(false);
		Order_man.getInstance().dispose();
		Order_man.getInstance().notmain(user_id, p);
		Notification.getInstance().notmain(4);

	}

	public DefaultTableModel search_orders(String key) {
		String[] cols = { "ID", "名称", "经销商", "产品", "数量", "设备", "地址", "截止日期", "状态", "工厂" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Order_list.size(); i++) {
			String state = null;
			switch (Order_list.get(i).getState()) {
			case 0:
				state = "已删除";
				break;
			case 1:
				state = "已发布";
				break;
			case 2:
				state = "已接单";
				break;
			case 3:
				state = "已完成";
				break;
			}
			if (Search.instance.isMatch(key, Order_list.get(i).getName())) {
				dt.addRow(new String[] { Order_list.get(i).getId(), Order_list.get(i).getName(),
						Order_list.get(i).getAgency(), Order_list.get(i).getProduct(), Order_list.get(i).getQuantity(),
						Order_list.get(i).getEquipment(), Order_list.get(i).getAddress(), Order_list.get(i).getDate(),
						state, Order_list.get(i).getFactory() });
			}
		}
		return dt;
	}

	public void complete_order(String id, String user_id, int p) {
		if (p == 2 || p == 0) {
			Warning.getInstance().notmain(53);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Order_list.size(); i1++) {
				if (id.equals(Order_list.get(i1).getId()) && Order_list.get(i1).getState() != 0) {
					if (Order_list.get(i1).getAgency().equals(user_id) == false && p != 3) {
						Warning.getInstance().notmain(51);
					} else if (Order_list.get(i1).getState() == 3) {
						Warning.getInstance().notmain(52);
					} else if (Order_list.get(i1).getState() == 1) {
						Warning.getInstance().notmain(54);
					} else {
						Order_list.get(i1).changeState(3);
						PrintWriter out1;
						PrintWriter out2;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Orders.txt"))));
							out1.println(gson.toJson(Order_list.get(0)));
							out1.close();

							out2 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Orders.txt", true))));
							for (int i2 = 1; i2 < Order_list.size(); i2++) {
								out2.println(gson.toJson(Order_list.get(i2)));
							}
							out2.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Order_man.getInstance().setVisible(false);
						Order_man.getInstance().dispose();
						Order_man.getInstance().notmain(user_id, p);
						Notification.getInstance().notmain(11);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(48);
			}
		}

	}

	private Order_model() {
	}

	public static Order_model instance = new Order_model();

	public static Order_model getInstance() {
		return instance;
	}

}
