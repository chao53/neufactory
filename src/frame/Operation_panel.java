package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

public class Operation_panel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setTitle("东软云工厂系统");
					frame.setBackground(Color.WHITE);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 734, 499);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					String po = null;
					switch(p) {
					case 0:
						po = "游客";
						break;
					case 1:
						po = "经销商";
						break;
					case 2:
						po = "工厂管理员";
						break;
					case 3:
						po = "超级管理员";
						break;
					}
					JLabel lblNewLabel_id = new JLabel("你好！" + user_id);
					lblNewLabel_id.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_id.setBounds(480, 22, 200, 18);
					contentPane.add(lblNewLabel_id);
					
					JLabel lblNewLabel_p = new JLabel("权限级别:" + po);
					lblNewLabel_p.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_p.setBounds(480, 47, 200, 18);
					contentPane.add(lblNewLabel_p);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel.setBounds(510, 367, 206, 85);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon("img\\bg.png"));
					lblNewLabel_1.setBounds(-14, 0, 462, 95);
					contentPane.add(lblNewLabel_1);
					
					JButton btnNewButton = new JButton("退出系统");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton.setBounds(440, 302, 135, 43);
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_1 = new JButton("订单管理");
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Order_man.getInstance().notmain(user_id,p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1.setBounds(145, 302, 135, 43);
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_2 = new JButton("工厂管理");
					btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Factory_man.getInstance().notmain(user_id,p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2.setBounds(440, 202, 135, 43);
					contentPane.add(btnNewButton_2);
					
					JButton btnNewButton_3 = new JButton("用户管理");
					btnNewButton_3.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							User_man.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_3.setBounds(145, 102, 135, 43);
					contentPane.add(btnNewButton_3);
					
					JButton btnNewButton_4 = new JButton("产品管理");
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Product_man.getInstance().notmain(user_id,p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_4.setBounds(440, 102, 135, 43);
					contentPane.add(btnNewButton_4);
					
					JButton btnNewButton_5 = new JButton("设备管理");
					btnNewButton_5.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Equipment_man.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_5.setBounds(145, 202, 135, 43);
					contentPane.add(btnNewButton_5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private Operation_panel() {
	
		
		
	}
	private static Operation_panel frame = new Operation_panel();
	
	public static Operation_panel getInstance() {
		return frame;
	}
}
