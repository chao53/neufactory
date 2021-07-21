package service;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import model.*;

public class Controller {

	private Controller() {

	}

//***********************************User*********************************************************************************
//************************************************************************************************************************
	public void register(String id, String number, String password, String password2, int power, String user_id,
			int p) {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().register(id, number, password, password2, power, user_id, p);
		Log_in_model.getInstance().refresh();
	}

	public void log_in(String id, String password) {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().log_in(id, password);
	}

	public void visit() {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().vist();
	}

	public DefaultTableModel users_table() {
		Log_in_model.getInstance().refresh();
		DefaultTableModel dt = Log_in_model.getInstance().users_table();
		return dt;
	}

	public void del_user(String id, String user_id, int p) {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().del_user(id, user_id, p);

	}

	public void change_user0(String id, String user_id, int p) {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().change_user0(id, user_id, p);
	}

	public void change_user(String id, String number, String password, String password2, String user_id, int p) {
		Log_in_model.getInstance().refresh();
		Log_in_model.getInstance().change_user(id, number, password, password2, user_id, p);
	}

	public DefaultTableModel search_user(String key) {
		Log_in_model.getInstance().refresh();
		DefaultTableModel dt = Log_in_model.getInstance().search_user(key);
		return dt;
	}

//***************************************Equipment***************************************************************************
//***************************************************************************************************************************

	public void add_equipment(String name, String description, String factory,String user_id,int p) {
		Equipment_model.instance.refresh();
		Equipment_model.instance.add_equipment(name, description, factory, user_id, p);
	}

	public DefaultTableModel equipment_table() {
		Equipment_model.getInstance().refresh();
		DefaultTableModel dt = Equipment_model.getInstance().equipments_table();
		return dt;
	}
	
	public void del_equipment(String id,String user_id,int p) {
		Equipment_model.instance.refresh();
		Equipment_model.instance.del_equipment(id, user_id, p);
	}
	
	public void change_equipment0(String id, String user_id, int p) {
		Equipment_model.getInstance().refresh();
		Equipment_model.getInstance().change_equipment0(id, user_id, p);
	}
	
	public void change_equipment(String id, String description, String user_id, int p) {
		Equipment_model.getInstance().refresh();
		Equipment_model.getInstance().change_equipment(id, description, user_id, p);
	}
	
	public void switch_equipment(String id, String user_id, int p) {
		Equipment_model.instance.refresh();
		Equipment_model.instance.switch_equipment(id, user_id, p);
	}
	
	public DefaultTableModel search_equipment(String key) {
		Equipment_model.getInstance().refresh();
		DefaultTableModel dt = Equipment_model.getInstance().search_equipment(key);
		return dt;
	}
	
//***************************************Factory***************************************************************************
//*************************************************************************************************************************
	
	public void add_factory(String name, String description,String user_id,int p) {
		Factory_model.instance.refresh();
		Factory_model.instance.add_factory(name, description, user_id, p);
	}
	
	public DefaultTableModel factorys_table() {
		Factory_model.getInstance().refresh();
		DefaultTableModel dt = Factory_model.getInstance().factorys_table();
		return dt;
	}
	
	public void switch_factory(String id, String user_id, int p) {
		Factory_model.instance.refresh();
		Factory_model.instance.switch_factory(id, user_id, p);
	}
	
	public void change_factory0(String id, String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().change_factory0(id, user_id, p);
	}
	
	public void change_factory(String id, String description, String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().change_factory(id, description, user_id, p);
	}
	
	public void factory_equipment0(String id, String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().factory_equipment0(id, user_id, p);
	}
	
	public DefaultTableModel factory_equipment_table(String factory) {
		Factory_model.getInstance().refresh();
		DefaultTableModel dt = Factory_model.getInstance().factory_equipment_table(factory);
		return dt;
	}
	
	public void rent_equipment(String id, String factory,String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().rent_equipment(id, factory, user_id, p);
	}
	
	public void back_equipment(String id, String factory,String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().back_equipment(id, factory, user_id, p);
	}
	
	public void factory_order0(String id, String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().factory_order0(id, user_id, p);
	}	
	
	public DefaultTableModel factory_order_table(String factory) {
		Factory_model.getInstance().refresh();
		DefaultTableModel dt = Factory_model.getInstance().factory_order_table(factory);
		return dt;
	}
	
	public void take_order(String id, String factory,String user_id, int p) {
		Factory_model.getInstance().refresh();
		Factory_model.getInstance().take_order(id,factory,user_id, p);
	}
	
	public DefaultTableModel search_factory(String key) {
		Factory_model.getInstance().refresh();
		DefaultTableModel dt = Factory_model.getInstance().search_factorys(key);
		return dt;
	}
		
//***************************************Equipment***************************************************************************
//***************************************************************************************************************************

	public void add_product(String name, String description,String user_id,int p) {
		Product_model.instance.refresh();
		Product_model.instance.add_product(name, description, user_id, p);
	}
	
	public DefaultTableModel products_table() {
		Product_model.getInstance().refresh();
		DefaultTableModel dt = Product_model.getInstance().products_table();
		return dt;
	}
	
	public void del_product(String id, String user_id, int p) {
		Product_model.getInstance().refresh();
		Product_model.instance.del_product(id, user_id, p);
	}
	
	public void change_product0(String id, String user_id, int p) {
		Product_model.getInstance().refresh();
		Product_model.getInstance().change_product0(id, user_id, p);
	}
	
	public void change_product(String id, String description, String user_id, int p) {
		Product_model.getInstance().refresh();
		Product_model.getInstance().change_product(id, description, user_id, p);
	}
	
	public DefaultTableModel search_product(String key) {
		Product_model.getInstance().refresh();
		DefaultTableModel dt = Product_model.getInstance().search_product(key);
		return dt;
	}
	
//****************************************Order******************************************************************************
//***************************************************************************************************************************
	
	public void add_order(String name, String product,String quantity, String equipment,
			String address,String date, String user_id, int p) {
		Order_model.getInstance().refresh();
		Order_model.getInstance().add_order(name, product, quantity, equipment, address, date, user_id, p);
	}
	
	public DefaultComboBoxModel<String> product_combobox(){
		Order_model.getInstance().refresh();
		DefaultComboBoxModel<String> cb = Order_model.instance.product_combobox();
		return cb;
	}
	
	public DefaultComboBoxModel<String> equipment_combobox(){
		Order_model.getInstance().refresh();
		DefaultComboBoxModel<String> cb = Order_model.instance.equipment_combobox();
		return cb;
	}
	
	public DefaultTableModel orders_table() {
		Order_model.getInstance().refresh();
		DefaultTableModel tb = Order_model.instance.orders_table();
		return tb;
	}
	
	public void del_order(String id, String user_id, int p) {
		Order_model.getInstance().refresh();
		Order_model.getInstance().del_order(id, user_id, p);
	}
	
	public void change_order0(String id, String user_id, int p) {
		Order_model.getInstance().refresh();
		Order_model.getInstance().change_order0(id, user_id, p);
	}
	
	public void change_order(String id, String description, String user_id, int p) {
		Order_model.getInstance().refresh();
		Order_model.getInstance().change_order(id, description, user_id, p);
	}
	
	public DefaultTableModel search_order(String key) {
		Order_model.getInstance().refresh();
		DefaultTableModel dt = Order_model.getInstance().search_orders(key);
		return dt;
	}
	
	public void complete_order(String id, String user_id, int p) {
		Order_model.getInstance().refresh();
		Order_model.getInstance().complete_order(id, user_id, p);
	}
	
//***************************************************************************************************************************************	
	private static Controller instance = new Controller();

	public static Controller getInstance() {
		return instance;
	}

	
}
