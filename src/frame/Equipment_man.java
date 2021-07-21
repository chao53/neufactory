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

public class Equipment_man extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public void notmain(String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("设备管理");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 819, 472);
					contentPane = new JPanel();

					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBounds(600, 335, 200, 102);
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					contentPane.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("添加设备");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton.setBounds(632, 32, 135, 43);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String factory = "产能中心";
							Add_equipment.getInstance().notmain(factory,user_id, p);
						}
					});
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_4 = new JButton("删除设备");
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Del_equipment.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4.setBounds(632, 97, 135, 43);
					contentPane.add(btnNewButton_4);
					
					JButton btnNewButton_1 = new JButton("返回");
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(632, 291, 135, 43);
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Operation_panel.getInstance().notmain(user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_4_1 = new JButton("修改设备信息");
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Change_equipment0.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1.setBounds(632, 162, 135, 43);
					contentPane.add(btnNewButton_4_1);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(14, 37, 573, 297);
					contentPane.add(scrollPane);
					
					DefaultTableModel dt = Controller.getInstance().equipment_table();
					JTable table = new JTable(dt);
					table.setFont(new Font("黑体", Font.PLAIN, 14));
					scrollPane.setViewportView(table);
					
					JButton btnNewButton_4_1_1 = new JButton("远程开关机");
					btnNewButton_4_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Switch_equipment.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_4_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4_1_1.setBounds(632, 225, 135, 43);
					contentPane.add(btnNewButton_4_1_1);
					
					JLabel lblNewLabe_jx = new JLabel("检索");
					lblNewLabe_jx.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabe_jx.setBounds(17, 369, 42, 15);
					contentPane.add(lblNewLabe_jx);
					
					JTextField textField = new JTextField();
					textField.setText("请输入设备名称的关键字");
					textField.setBounds(73, 365, 364, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_cx = new JButton("查询");
					btnNewButton_cx.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String key = textField.getText();
							table.removeAll();
							DefaultTableModel dt2 = Controller.getInstance().search_equipment(key);
							JTable table2 = new JTable(dt2);
							table2.setFont(new Font("黑体", Font.PLAIN, 14));
							scrollPane.setViewportView(table2);
						}
					});
					btnNewButton_cx.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_cx.setBounds(451, 355, 135, 43);
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
	private Equipment_man() {
		
	}
	private static Equipment_man frame = new Equipment_man();
	
	public static Equipment_man getInstance() {
		return frame;//frame 就是 instance
	}
}
