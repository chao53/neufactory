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

import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import entity.Equipment;
import entity.Factory;
import entity.Order;
import entity.Product;
import entity.User;
import frame.*;

public class Factory_model {

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

	public void add_factory(String name, String description, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(24);
		} else {
			int j = 0;
			for (int i = 0; i < Factory_list.size(); i++) {
				if (Factory_list.get(i).getName().equals(name)) {
					j = 1;
				}
			}
			if (j == 1) {
				Warning.getInstance().notmain(25);
			} else {
				String id = "F" + String.format("%03d", Factory_list.size() + 1);
				Factory ta = new Factory(id, name, user_id, description);
				Factory_list.add(ta);
				PrintWriter out1;
				try {
					out1 = new PrintWriter(
							new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Factorys.txt", true))));
					out1.println(gson.toJson(ta));
					out1.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Factory_man.getInstance().isVisible()) {
					Factory_man.getInstance().setVisible(false);
					Factory_man.getInstance().dispose();
					Factory_man.getInstance().notmain(user_id, p);
				}
				Notification.getInstance().notmain(1);
			}
		}
	}

	public DefaultTableModel factorys_table() {
		String[] cols = { "ID", "名称", "描述", "管理者", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Factory_list.size(); i++) {
			String state = null;
			switch (Factory_list.get(i).getState()) {
			case 1:
				state = "开启";
				break;
			case 0:
				state = "停用";
				break;
			}
			dt.addRow(new String[] { Factory_list.get(i).getId(), Factory_list.get(i).getName(),
					Factory_list.get(i).getDescription(), Factory_list.get(i).getAdministrator(), state });
		}
		return dt;
	}
	
	public void switch_factory(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(26);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Factory_list.size(); i1++) {
				if (id.equals(Factory_list.get(i1).getId())) {
					if (Factory_list.get(i1).getAdministrator().equals(user_id) == false && p != 3) {
						Warning.getInstance().notmain(27);
					} else {
						if(Factory_list.get(i1).getState() == 1) {
							Factory_list.get(i1).changeState(0);
						}else if(Factory_list.get(i1).getState() == 0) {
							Factory_list.get(i1).changeState(1);
						}
						PrintWriter out1;
						PrintWriter out2;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Factorys.txt"))));
							out1.println(gson.toJson(Factory_list.get(0)));
							out1.close();

							out2 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Factorys.txt", true))));
							for (int i2 = 1; i2 < Factory_list.size(); i2++) {
								out2.println(gson.toJson(Factory_list.get(i2)));
							}
							out2.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Factory_man.getInstance().setVisible(false);
						Factory_man.getInstance().dispose();
						Factory_man.getInstance().notmain(user_id, p);
						Notification.getInstance().notmain(6);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(30);
			}
		}
	}

	public void change_factory0(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(28);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Factory_list.size(); i1++) {
				if (id.equals(Factory_list.get(i1).getId())) {
					if (p != 3 && Factory_list.get(i1).getAdministrator().equals(user_id) == false) {
						Warning.getInstance().notmain(29);
					} else {
						Change_factory.getInstance().notmain(id, user_id, p);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(30);
			}
		}
	}

	public void change_factory(String id, String description, String user_id, int p) {
		
			for (int i1 = 0; i1 < Factory_list.size(); i1++) {
				if (id.equals(Factory_list.get(i1).getId())) {
					Factory_list.get(i1).changeDescription(description);
				}
			}
			PrintWriter out1;
			PrintWriter out2;
			try {
				out1 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Factorys.txt"))));
				out1.println(gson.toJson(Factory_list.get(0)));
				out1.close();

				out2 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Factorys.txt", true))));
				for (int i2 = 1; i2 < Factory_list.size(); i2++) {
					out2.println(gson.toJson(Factory_list.get(i2)));
				}
				out2.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Factory_man.getInstance().setVisible(false);
			Factory_man.getInstance().dispose();
			Factory_man.getInstance().notmain(user_id, p);
			Notification.getInstance().notmain(4);
		
	}
	
	public void factory_equipment0(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(31);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Factory_list.size(); i1++) {
				if (id.equals(Factory_list.get(i1).getId())) {
					if (p != 3 && Factory_list.get(i1).getAdministrator().equals(user_id) == false) {
						Warning.getInstance().notmain(32);
					} else {
						Factory_equipment.getInstance().notmain(Factory_list.get(i1).getName(), user_id, p);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(30);
			}
		}
	}

	public DefaultTableModel factory_equipment_table(String factory) {
		String[] cols = { "ID", "名称", "描述", "所属", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Equipment_list.size(); i++) {
			if (Equipment_list.get(i).getFactory().equals(factory)) {
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
		for(int i1 = 0; i1 < Factory_list.size(); i1++) {
			if(Factory_list.get(i1).getName().equals(factory)) {
				for(int i2 = 0; i2 < Factory_list.get(i1).getEq_list().size();i2++) {
					for(int i3 = 0; i3 < Equipment_list.size(); i3++) {
						if(Factory_list.get(i1).getEq_list().get(i2).equals(Equipment_list.get(i3).getId())) {
							String state = null;
							switch (Equipment_list.get(i3).getState()) {
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
							dt.addRow(new String[] { Equipment_list.get(i3).getId(), Equipment_list.get(i3).getName(),
									Equipment_list.get(i3).getDescription(), Equipment_list.get(i3).getFactory() + "(租用)", state });
						}
					}
				}
			}
		}
		return dt;
	}
	
	public void rent_equipment(String id, String factory,String user_id, int p) {
		int j1 = 0;
		int j3 = 0;
		int j4 = 0;
		for(int i1 = 0; i1 < Equipment_list.size(); i1++) {
			if(Equipment_list.get(i1).getId().equals(id) && Equipment_list.get(i1).getState() != 0) {
				j1 = 1;
	 			for(int i2  = 0; i2 < Factory_list.size(); i2++) {
					if(Factory_list.get(i2).getName().equals(factory)) {
						int j2 = 0;
						for(int i3 = 0; i3 < Factory_list.get(i2).getEq_list().size(); i3++) {
							if(Factory_list.get(i2).getEq_list().get(i3).equals(id)) {
								j2 = 1;
								j3 = 1;
							}
						}
						if(j2 == 0) {
							Factory_list.get(i2).getEq_list().add(id);
							j4 = 1;
						}
					}
				}
			}
		}
		
		PrintWriter out1;
		PrintWriter out2;
		try {
			out1 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Factorys.txt"))));
			out1.println(gson.toJson(Factory_list.get(0)));
			out1.close();

			out2 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Factorys.txt", true))));
			for (int i2 = 1; i2 < Factory_list.size(); i2++) {
				out2.println(gson.toJson(Factory_list.get(i2)));
			}
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Factory_equipment.getInstance().setVisible(false);
		Factory_equipment.getInstance().dispose();
		Factory_equipment.getInstance().notmain(factory, user_id, p);
		if(j1 == 0) {
			Warning.getInstance().notmain(19);
		}
		if(j3 == 1) {
			Warning.getInstance().notmain(33);
		}
		if(j4 == 1) {
			Notification.getInstance().notmain(7);
		}
	}

	public void back_equipment(String id, String factory,String user_id, int p) {
		int j1 = 0;
		int j3 = 0;
		int j4 = 0;
		for(int i1 = 0; i1 < Equipment_list.size(); i1++) {
			if(Equipment_list.get(i1).getId().equals(id) && Equipment_list.get(i1).getState() != 0) {
				j1 = 1;
	 			for(int i2  = 0; i2 < Factory_list.size(); i2++) {
					if(Factory_list.get(i2).getName().equals(factory)) {
						int j2 = 0;
						for(int i3 = 0; i3 < Factory_list.get(i2).getEq_list().size(); i3++) {
							if(Factory_list.get(i2).getEq_list().get(i3).equals(id)) {
								j2 = 1;
								j3 = 1;
								Factory_list.get(i2).getEq_list().remove(i3);
							}
						}
						if(j2 == 0) {
							j4 = 1;
						}
					}
				}
			}
		}
		PrintWriter out1;
		PrintWriter out2;
		try {
			out1 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Factorys.txt"))));
			out1.println(gson.toJson(Factory_list.get(0)));
			out1.close();

			out2 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Factorys.txt", true))));
			for (int i2 = 1; i2 < Factory_list.size(); i2++) {
				out2.println(gson.toJson(Factory_list.get(i2)));
			}
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Factory_equipment.getInstance().setVisible(false);
		Factory_equipment.getInstance().dispose();
		Factory_equipment.getInstance().notmain(factory, user_id, p);
		if(j1 == 0) {
			Warning.getInstance().notmain(19);
		}
		if(j3 == 1) {
			Notification.getInstance().notmain(8);
		}
		if(j4 == 1) {
			Warning.getInstance().notmain(34);
		}
		
	}
	
	public void factory_order0(String id, String user_id, int p) {
		if (p < 2) {
			Warning.getInstance().notmain(31);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Factory_list.size(); i1++) {
				if (id.equals(Factory_list.get(i1).getId())) {
					if (p != 3 && Factory_list.get(i1).getAdministrator().equals(user_id) == false) {
						Warning.getInstance().notmain(32);
					} else {
						Factory_order.getInstance().notmain(Factory_list.get(i1).getName(), user_id, p);
					}
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(30);
			}
		}
	}
	
	public DefaultTableModel factory_order_table(String factory) {
		String[] cols = { "ID", "名称", "经销商", "产品", "数量", "设备", "地址", "截止日期", "状态", "工厂" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Order_list.size(); i++) {
			if (Order_list.get(i).getFactory().equals(factory)) {
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
		}
		return dt;
	}
	
	public void take_order(String id, String factory, String user_id, int p) {
		int j1 = 0;
		for (int i1 = 0; i1 < Order_list.size(); i1++) {
			if (Order_list.get(i1).getId().equals(id) || Order_list.get(i1).getState() == 1) {
				j1 = 1;
				Order_list.get(i1).changeState(2);
				Order_list.get(i1).changeFactory(factory);
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
				Factory_order.getInstance().setVisible(false);
				Factory_order.getInstance().dispose();
				Factory_order.getInstance().notmain(factory, user_id, p);
				Notification.getInstance().notmain(10);
			}
		}
		if(j1 == 0) {
			Warning.getInstance().notmain(48);
		}
	}
	
	public DefaultTableModel search_factorys(String key) {
		String[] cols = { "ID", "名称", "描述", "管理者", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Factory_list.size(); i++) {
			String state = null;
			switch (Factory_list.get(i).getState()) {
			case 1:
				state = "开启";
				break;
			case 0:
				state = "停用";
				break;
			}
			if(Search.instance.isMatch(key, Factory_list.get(i).getName())) {
				dt.addRow(new String[] { Factory_list.get(i).getId(), Factory_list.get(i).getName(),
						Factory_list.get(i).getDescription(), Factory_list.get(i).getAdministrator(), state });
			}
		}
		return dt;
	}
	
	private Factory_model() {
		
	}
	
	public static Factory_model instance = new Factory_model();

	public static Factory_model getInstance() {
		return instance;
	}

	
}
