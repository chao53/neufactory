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

public class Factory_man extends JFrame {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(String user_id,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("工厂管理");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 819, 557);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBounds(601, 422, 200, 98);
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					contentPane.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("注册工厂");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton.setBounds(632, 32, 135, 43);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Add_factory.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_4 = new JButton("启用或停用工厂");
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 14));
					btnNewButton_4.setBounds(632, 97, 135, 43);
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Switch_factory.getInstance().notmain(user_id, p);
						}
					});

					contentPane.add(btnNewButton_4);
					
					JButton btnNewButton_1 = new JButton("返回");
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(632, 371, 135, 43);
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Operation_panel.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_4_1 = new JButton("工厂订单管理");
					btnNewButton_4_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1.setBounds(632, 231, 135, 43);
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Factory_order0.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_4_1);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(14, 32, 578, 382);
					contentPane.add(scrollPane);
					
					DefaultTableModel dt = Controller.getInstance().factorys_table();
					table = new JTable(dt);
					table.setFont(new Font("黑体", Font.PLAIN, 14));
					scrollPane.setViewportView(table);
					
					JLabel lblNewLabe_jx = new JLabel("检索");
					lblNewLabe_jx.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabe_jx.setBounds(23, 447, 42, 15);
					contentPane.add(lblNewLabe_jx);
					
					JTextField textField = new JTextField();
					textField.setText("请输入工厂名称的关键字");
					textField.setBounds(79, 443, 364, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_cx = new JButton("查询");
					btnNewButton_cx.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String key = textField.getText();
							table.removeAll();
							DefaultTableModel dt2 = Controller.getInstance().search_factory(key);
							JTable table2 = new JTable(dt2);
							table2.setFont(new Font("黑体", Font.PLAIN, 14));
							scrollPane.setViewportView(table2);
						}
					});
					btnNewButton_cx.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_cx.setBounds(457, 434, 135, 43);
					contentPane.add(btnNewButton_cx);
					
					JButton btnNewButton_4_1_1 = new JButton("修改工厂信息");
					btnNewButton_4_1_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1_1.setBounds(632, 162, 135, 43);
					btnNewButton_4_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Change_factory0.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_4_1_1);
					
					JButton btnNewButton_4_1_1_1 = new JButton("工厂设备管理");
					btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Factory_equipment0.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4_1_1_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1_1_1.setBounds(632, 301, 135, 43);
					contentPane.add(btnNewButton_4_1_1_1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Factory_man() {
		
	}
	private static Factory_man frame = new Factory_man();
	private JTable table;
	
	public static Factory_man getInstance() {
		return frame;
	}
}
