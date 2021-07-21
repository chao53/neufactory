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
import java.awt.Font;
import javax.swing.JTextField;

public class User_man extends JFrame {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(String user_id,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("用户管理");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 822, 416);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBounds(598, 283, 206, 98);
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					contentPane.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("新建用户(注册)");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 14));
					btnNewButton.setBounds(632, 32, 135, 43);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Register.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_4 = new JButton("删除用户");
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Del_user.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4.setBounds(632, 97, 135, 43);
					contentPane.add(btnNewButton_4);
					
					JButton btnNewButton_1 = new JButton("返回");
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(632, 227, 135, 43);
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Operation_panel.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_4_1 = new JButton("修改用户信息");
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Change_user0.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1.setBounds(632, 162, 135, 43);
					contentPane.add(btnNewButton_4_1);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(14, 32, 578, 238);
					contentPane.add(scrollPane);
					
					DefaultTableModel dt = Controller.getInstance().users_table();
					JTable table = new JTable(dt);
					table.setFont(new Font("黑体", Font.PLAIN, 15));
					scrollPane.setViewportView(table);
					
					JLabel lblNewLabe_jx = new JLabel("检索");
					lblNewLabe_jx.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabe_jx.setBounds(24, 312, 42, 18);
					contentPane.add(lblNewLabe_jx);
					
					JTextField textField = new JTextField();
					textField.setText("请输入用户ID的关键字");
					textField.setBounds(80, 310, 364, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_cx = new JButton("查询");
					btnNewButton_cx.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String key = textField.getText();
							table.removeAll();
							DefaultTableModel dt2 = Controller.getInstance().search_user(key);
							JTable table2 = new JTable(dt2);
							table2.setFont(new Font("黑体", Font.PLAIN, 15));
							scrollPane.setViewportView(table2);
						}
					});
					btnNewButton_cx.setFont(new Font("黑体", Font.PLAIN, 15));
					btnNewButton_cx.setBounds(458, 301, 135, 43);
					contentPane.add(btnNewButton_cx);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private User_man() {
		
		
	}
	private static User_man frame = new User_man();

	public static User_man getInstance() {
		return frame;
	}
}
