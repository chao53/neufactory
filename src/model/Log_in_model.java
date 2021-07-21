package model;

import java.io.*;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;

import entity.*;
import frame.*;

public class Log_in_model {

	Gson gson = new Gson();
	ArrayList<User> User_list = new ArrayList<User>();
	ArrayList<Equipment> Equipment_list = new ArrayList<Equipment>();
	ArrayList<Factory> Factory_list = new ArrayList<Factory>();
	ArrayList<Order> Order_list = new ArrayList<Order>();
	ArrayList<Product> Product_list = new ArrayList<Product>();

	private Log_in_model() {

	}

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

	public void register(String id, String number, String password, String password2, int power, String user_id,
			int p) {
		int j = 1;
		for (int i = 0; i < id.length(); i++) {
			if (id.charAt(i) == ' ') {
				Warning.getInstance().notmain(1);
				j = 0;
			}
		}
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == ' ') {
				Warning.getInstance().notmain(2);
				j = 0;
			}
		}
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == ' ') {
				Warning.getInstance().notmain(3);
				j = 0;
			}
		}
		if (id == null || number == null || password == null || password2 == null || id.isEmpty() || number.isEmpty()
				|| password.isEmpty() || password2.isEmpty()) {
			Warning.getInstance().notmain(4);
			j = 0;
		}
		if (password.equals(password2) == false) {
			Warning.getInstance().notmain(5);
			j = 0;
		}
		for (int i = 0; i < User_list.size(); i++) {
			if (id.equals(User_list.get(i).getId())) {
				Warning.getInstance().notmain(6);
				j = 0;
			}
		}
		if (j == 1) {
			User ta = new User(id, password, number, power);
			User_list.add(ta);
			PrintWriter out1;
			try {
				out1 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Users.txt", true))));
				out1.println(gson.toJson(ta));
				out1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (User_man.getInstance().isVisible()) {
				User_man.getInstance().setVisible(false);
				User_man.getInstance().dispose();
				User_man.getInstance().notmain(user_id, p);
			}
			Notification.getInstance().notmain(1);
		}
	}

	public void log_in(String id, String password) {
		int j = 0;
		for (int i = 0; i < User_list.size(); i++) {
			if (id.equals(User_list.get(i).getId()) && User_list.get(i).getExist() == 1) {
				j = 1;
				if (password.equals(User_list.get(i).getPassword())) {
					Log_in.getInstance().setVisible(false);
					Log_in.getInstance().dispose();
					Operation_panel.getInstance().notmain(User_list.get(i).getId(), User_list.get(i).getPower());
					Notification.getInstance().notmain(2);
					j = 2;
				}
			}
		}
		if (j == 0) {
			Warning.getInstance().notmain(7);
		}
		if (j == 1) {
			Warning.getInstance().notmain(8);
		}
	}

	public void vist() {
		Log_in.getInstance().setVisible(false);
		Log_in.getInstance().dispose();
		Operation_panel.getInstance().notmain("游客", 0);
	}

	public DefaultTableModel users_table() {
		String[] cols = { "ID", "手机号码", "权限", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < User_list.size(); i++) {
			String pow = null;
			String exist = null;
			switch (User_list.get(i).getPower()) {
			case 0:
				pow = "游客";
				break;
			case 1:
				pow = "经销商";
				break;
			case 2:
				pow = "工厂管理员";
				break;
			case 3:
				pow = "超级管理员";
				break;
			}
			switch (User_list.get(i).getExist()) {
			case 1:
				exist = "正常";
				break;
			case 0:
				exist = "已删除";
				break;
			}
			dt.addRow(new String[] { User_list.get(i).getId(), User_list.get(i).getNumber(), pow, exist });
		}
		return dt;
	}

	public void del_user(String id, String user_id, int p) {
		if (p == 0) {
			Warning.getInstance().notmain(12);
		} else if (p != 3 && id.equals(user_id) == false) {
			Warning.getInstance().notmain(13);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < User_list.size(); i1++) {
				if (id.equals(User_list.get(i1).getId())) {
					if(User_list.get(i1).getExist() == 0) {
						Warning.getInstance().notmain(7);
					}else if (User_list.get(i1).getPower() == 3) {
						Warning.getInstance().notmain(11);
					} else {
						int j2 = 1;
						if (user_id.equals(User_list.get(i1).getId())) {
							j2 = 0;
						}
						User_list.get(i1).changeExist(0);
						PrintWriter out1;
						PrintWriter out2;
						try {
							out1 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Users.txt"))));
							out1.println(gson.toJson(User_list.get(0)));
							out1.close();

							out2 = new PrintWriter(new BufferedWriter(
									new OutputStreamWriter(new FileOutputStream("file//Users.txt", true))));
							for (int i2 = 1; i2 < User_list.size(); i2++) {
								out2.println(gson.toJson(User_list.get(i2)));
							}
							out2.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						User_man.getInstance().setVisible(false);
						User_man.getInstance().dispose();
						if (j2 == 1) {
							User_man.getInstance().notmain(user_id, p);
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

	public void change_user0(String id, String user_id, int p) {
		if (p == 0) {
			Warning.getInstance().notmain(15);
		} else if (p != 3 && id.equals(user_id) == false) {
			Warning.getInstance().notmain(14);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < User_list.size(); i1++) {
				if (id.equals(User_list.get(i1).getId())) {
					Change_user.getInstance().notmain(id, user_id, p);
					j1 = 1;
				}
				
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(7);
			}
		}
	}

	public void change_user(String id, String number, String password, String password2, String user_id, int p) {
		if (password.equals(password2)) {
			for (int i1 = 0; i1 < User_list.size(); i1++) {
				if (id.equals(User_list.get(i1).getId())) {
					User_list.get(i1).changeNumber(number);
					User_list.get(i1).changePassword(password);
				}
			}
			PrintWriter out1;
			PrintWriter out2;
			try {
				out1 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Users.txt"))));
				out1.println(gson.toJson(User_list.get(0)));
				out1.close();

				out2 = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Users.txt", true))));
				for (int i2 = 1; i2 < User_list.size(); i2++) {
					out2.println(gson.toJson(User_list.get(i2)));
				}
				out2.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User_man.getInstance().setVisible(false);
			User_man.getInstance().dispose();
			User_man.getInstance().notmain(user_id, p);
			Notification.getInstance().notmain(4);
		} else {
			Warning.getInstance().notmain(5);
		}
	}

	public DefaultTableModel search_user(String key) {
		String[] cols = { "ID", "手机号码", "权限", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < User_list.size(); i++) {
			if (Search.getInstance().isMatch(key, User_list.get(i).getId())) {
				String pow = null;
				String exist = null;
				switch (User_list.get(i).getPower()) {
				case 0:
					pow = "游客";
					break;
				case 1:
					pow = "经销商";
					break;
				case 2:
					pow = "工厂管理员";
					break;
				case 3:
					pow = "超级管理员";
					break;
				}
				switch (User_list.get(i).getExist()) {
				case 1:
					exist = "正常";
					break;
				case 0:
					exist = "已删除";
					break;
				}
				dt.addRow(new String[] { User_list.get(i).getId(), User_list.get(i).getNumber(), pow, exist });
			}
		}
		return dt;
	}

	private static Log_in_model instance = new Log_in_model();

	public static Log_in_model getInstance() {
		return instance;
	}
}
