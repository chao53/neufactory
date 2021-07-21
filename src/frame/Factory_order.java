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

public class Factory_order extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(String name, String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setTitle("工厂订单管理(" + name + ")");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 1400, 523);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel.setBounds(1176, 389, 206, 91);
					contentPane.add(lblNewLabel);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(31, 49, 1118, 153);
					contentPane.add(scrollPane);
					DefaultTableModel dt1 = Controller.getInstance().factory_order_table(name);
					JTable table = new JTable(dt1);
					scrollPane.setViewportView(table);
					
					JButton btnNewButton_2 = new JButton("订单接单");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Take_order.getInstance().notmain(name, user_id, p);;
						}
					});
					btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2.setBounds(1203, 49, 135, 43);
					contentPane.add(btnNewButton_2);
					
					JButton btnNewButton_2_4 = new JButton("返回");
					btnNewButton_2_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_4.setBounds(1203, 246, 135, 43);
					contentPane.add(btnNewButton_2_4);
					
					JScrollPane scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(31, 246, 1118, 152);
					contentPane.add(scrollPane_1);
					DefaultTableModel dt2 = Controller.getInstance().factory_order_table("");
					JTable table_1 = new JTable(dt2);
					scrollPane_1.setViewportView(table_1);
					
					JLabel lblNewLabel_1 = new JLabel("已接的订单");
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(31, 13, 151, 23);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("待接的订单");
					lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_2.setBounds(31, 215, 135, 18);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel("注：一旦接单，不能反悔");
					lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 15));
					lblNewLabel_3.setBounds(1176, 105, 179, 18);
					contentPane.add(lblNewLabel_3);
					
					JLabel lblNewLabel_4 = new JLabel("如有变更，请与经销商联");
					lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 15));
					lblNewLabel_4.setBounds(1176, 121, 179, 18);
					contentPane.add(lblNewLabel_4);
					
					JLabel lblNewLabel_5 = new JLabel("系。");
					lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 15));
					lblNewLabel_5.setBounds(1176, 136, 72, 18);
					contentPane.add(lblNewLabel_5);
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
	private Factory_order() {
		
	}
	
	public static Factory_order frame = new Factory_order();
	
	public static Factory_order getInstance() {
		return frame;
	}
}
