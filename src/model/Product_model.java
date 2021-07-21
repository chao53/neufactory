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
import frame.Change_product;
import frame.Notification;
import frame.Product_man;
import frame.Warning;

public class Product_model {

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

	public void add_product(String name, String description, String user_id, int p) {
		if (p == 0) {
			Warning.getInstance().notmain(35);
		} else {
			int j = 0;
			for (int i = 0; i < Product_list.size(); i++) {
				if (Product_list.get(i).getName().equals(name)) {
					j = 1;
				}
			}
			if (j == 1) {
				Warning.getInstance().notmain(39);
			} else {
				String id = "P" + String.format("%03d", Product_list.size() + 1);
				Product ta = new Product(id, name, description);
				Product_list.add(ta);
				PrintWriter out1;
				try {
					out1 = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(new FileOutputStream("file//Products.txt", true))));
					out1.println(gson.toJson(ta));
					out1.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (Product_man.getInstance().isVisible()) {
					Product_man.getInstance().setVisible(false);
					Product_man.getInstance().dispose();
					Product_man.getInstance().notmain(user_id, p);
				}
				Notification.getInstance().notmain(1);
			}
		}
	}

	public DefaultTableModel products_table() {
		String[] cols = { "ID", "名称", "描述", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Product_list.size(); i++) {
			String state = null;
			switch (Product_list.get(i).getExist()) {
			case 1:
				state = "正常";
				break;
			case 0:
				state = "已删除";
				break;
			}
			dt.addRow(new String[] { Product_list.get(i).getId(), Product_list.get(i).getName(),
					Product_list.get(i).getDescription(), state });
		}
		return dt;
	}

	public void del_product(String id, String user_id, int p) {
		if (p < 3) {
			Warning.getInstance().notmain(37);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Product_list.size(); i1++) {
				if (id.equals(Product_list.get(i1).getId())) {
					Product_list.get(i1).changeExist(0);
					PrintWriter out1;
					PrintWriter out2;
					try {
						out1 = new PrintWriter(
								new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Products.txt"))));
						out1.println(gson.toJson(Product_list.get(0)));
						out1.close();

						out2 = new PrintWriter(new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream("file//Products.txt", true))));
						for (int i2 = 1; i2 < Product_list.size(); i2++) {
							out2.println(gson.toJson(Product_list.get(i2)));
						}
						out2.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Product_man.getInstance().setVisible(false);
					Product_man.getInstance().dispose();
					Product_man.getInstance().notmain(user_id, p);
					Notification.getInstance().notmain(6);
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(36);
			}
		}
	}

	public void change_product0(String id, String user_id, int p) {
		if (p < 3) {
			Warning.getInstance().notmain(38);
		} else {
			int j1 = 0;
			for (int i1 = 0; i1 < Product_list.size(); i1++) {
				if (id.equals(Product_list.get(i1).getId())) {
					Change_product.getInstance().notmain(id, user_id, p);
					j1 = 1;
				}
			}
			if (j1 == 0) {
				Warning.getInstance().notmain(36);
			}
		}
	}

	public void change_product(String id, String description, String user_id, int p) {

		for (int i1 = 0; i1 < Product_list.size(); i1++) {
			if (id.equals(Product_list.get(i1).getId())) {
				Product_list.get(i1).changeDescription(description);
			}
		}
		PrintWriter out1;
		PrintWriter out2;
		try {
			out1 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file//Products.txt"))));
			out1.println(gson.toJson(Product_list.get(0)));
			out1.close();

			out2 = new PrintWriter(
					new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file/Products.txt", true))));
			for (int i2 = 1; i2 < Product_list.size(); i2++) {
				out2.println(gson.toJson(Product_list.get(i2)));
			}
			out2.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Product_man.getInstance().setVisible(false);
		Product_man.getInstance().dispose();
		Product_man.getInstance().notmain(user_id, p);
		Notification.getInstance().notmain(4);

	}

	public DefaultTableModel search_product(String key) {
		String[] cols = { "ID", "名称", "描述", "状态" };
		String[][] rows = {};
		DefaultTableModel dt = new DefaultTableModel(rows, cols);
		for (int i = 0; i < Product_list.size(); i++) {
			if (Search.instance.isMatch(key, Product_list.get(i).getName())) {
				String state = null;
				switch (Product_list.get(i).getExist()) {
				case 1:
					state = "正常";
					break;
				case 0:
					state = "已删除";
					break;
				}
				dt.addRow(new String[] { Product_list.get(i).getId(), Product_list.get(i).getName(),
						Product_list.get(i).getDescription(), state });
			}
		}
		return dt;
	}

	private Product_model() {

	}

	public static Product_model instance = new Product_model();

	public static Product_model getInstance() {
		return instance;
	}
}
