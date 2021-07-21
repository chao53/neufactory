package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.Controller;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Font;

public class Order_man extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(String user_id,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("订单管理");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 1400, 494);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBounds(1182, 356, 200, 98);
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					contentPane.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("发布订单");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton.setBounds(1210, 32, 135, 43); 
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Add_order.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_4 = new JButton("删除订单");
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4.setBounds(1210, 97, 135, 43);
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Del_order.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_4);
					
					JButton btnNewButton_1 = new JButton("返回");
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(1210, 292, 135, 43);
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Operation_panel.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_4_1 = new JButton("修改订单");
					btnNewButton_4_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4_1.setBounds(1210, 162, 135, 43);
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Change_order0.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_4_1);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(14, 32, 1157, 303);
					contentPane.add(scrollPane);
					
					DefaultTableModel dt = Controller.getInstance().orders_table();
					JTable table = new JTable(dt);
					table.setFont(new Font("黑体", Font.PLAIN, 14));
					scrollPane.setViewportView(table);
					
					JLabel lblNewLabe_jx = new JLabel("检索");
					lblNewLabe_jx.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabe_jx.setBounds(14, 370, 42, 18);
					contentPane.add(lblNewLabe_jx);
					
					JTextField textField = new JTextField();
					textField.setText("请输入订单名称的关键字");
					textField.setBounds(70, 370, 952, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_cx = new JButton("查询");
					btnNewButton_cx.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_cx.setBounds(1036, 370, 135, 43);
					btnNewButton_cx.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String key = textField.getText();
							table.removeAll();
							DefaultTableModel dt2 = Controller.getInstance().search_order(key);
							JTable table2 = new JTable(dt2);
							table2.setFont(new Font("黑体", Font.PLAIN, 14));
							scrollPane.setViewportView(table2);
						}
					});
					contentPane.add(btnNewButton_cx);
					
					JButton btnNewButton_1_1 = new JButton("完成订单");
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.setBounds(1210, 227, 135, 43);
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Complete_order.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_1_1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Order_man() {
		
	}
	private static Order_man frame = new Order_man();
	
	public static Order_man getInstance() {
		return frame;
	}
	
}