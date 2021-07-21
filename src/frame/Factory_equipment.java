package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import service.Controller;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;

public class Factory_equipment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(String name, String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setTitle("工厂设备管理(" + name + ")");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 789, 523);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel.setBounds(565, 393, 206, 91);
					contentPane.add(lblNewLabel);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(31, 49, 509, 153);
					contentPane.add(scrollPane);
					DefaultTableModel dt1 = Controller.getInstance().factory_equipment_table(name);
					JTable table = new JTable(dt1);
					scrollPane.setViewportView(table);
					
					JButton btnNewButton_2 = new JButton("添加设备");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Add_equipment.getInstance().notmain(name, user_id, p);
						}
					});
					btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2.setBounds(590, 30, 135, 43);
					contentPane.add(btnNewButton_2);
					
					JButton btnNewButton_2_1 = new JButton("远程开关机");
					btnNewButton_2_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Switch_equipment.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_2_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_1.setBounds(590, 95, 135, 43);
					contentPane.add(btnNewButton_2_1);
					
					JButton btnNewButton_2_2 = new JButton("移除设备");
					btnNewButton_2_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Del_equipment.getInstance().notmain(user_id, p);
						}
					});
					btnNewButton_2_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_2.setBounds(590, 160, 135, 43);
					contentPane.add(btnNewButton_2_2);
					
					JButton btnNewButton_2_3 = new JButton("租用设备");
					btnNewButton_2_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Rent_equipment.getInstance().notmain(name, user_id, p);
						}
					});
					btnNewButton_2_3.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_3.setBounds(590, 225, 135, 43);
					contentPane.add(btnNewButton_2_3);
					
					JButton btnNewButton_2_4 = new JButton("返回");
					btnNewButton_2_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_4.setBounds(590, 355, 135, 43);
					contentPane.add(btnNewButton_2_4);
					
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(31, 246, 509, 152);
					contentPane.add(scrollPane_1);
					DefaultTableModel dt2 = Controller.getInstance().factory_equipment_table("产能中心");
					JTable table_1 = new JTable(dt2);
					scrollPane_1.setViewportView(table_1);
					
					JButton btnNewButton_2_5 = new JButton("归还设备");
					btnNewButton_2_5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Back_equipment.getInstance().notmain(name, user_id, p);
						}
					});
					btnNewButton_2_5.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_5.setBounds(590, 290, 135, 43);
					contentPane.add(btnNewButton_2_5);
					
					JLabel lblNewLabel_1 = new JLabel("你工厂的设备");
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(31, 13, 151, 23);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("产能中心的设备");
					lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_2.setBounds(31, 215, 135, 18);
					contentPane.add(lblNewLabel_2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Factory_equipment() {
		
	}
	
	public static Factory_equipment frame = new Factory_equipment();
	
	public static Factory_equipment getInstance() {
		return frame;
	}
}
