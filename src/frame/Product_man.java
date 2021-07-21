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

public class Product_man extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(String user_id ,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("产品管理");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 819, 426);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setBounds(601, 292, 200, 98);
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					contentPane.add(lblNewLabel);
					
					JButton btnNewButton = new JButton("新增产品");
					btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton.setBounds(632, 32, 135, 43);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Add_product.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton);
					
					JButton btnNewButton_4 = new JButton("删除产品");
					btnNewButton_4.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_4.setBounds(632, 97, 135, 43);
					btnNewButton_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Del_product.getInstance().notmain(user_id, p);
						}
					});
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
					
					JButton btnNewButton_4_1 = new JButton("修改产品信息");
					btnNewButton_4_1.setFont(new Font("黑体", Font.PLAIN, 16));
					btnNewButton_4_1.setBounds(632, 162, 135, 43);
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Change_product0.getInstance().notmain(user_id, p);
						}
					});
					contentPane.add(btnNewButton_4_1);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(14, 32, 578, 238);
					contentPane.add(scrollPane);
					
					DefaultTableModel dt = Controller.getInstance().products_table();
					JTable table = new JTable(dt);
					table.setFont(new Font("黑体", Font.PLAIN, 14));
					scrollPane.setViewportView(table);
					
					JLabel lblNewLabe_jx = new JLabel("检索");
					lblNewLabe_jx.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabe_jx.setBounds(14, 317, 42, 18);
					contentPane.add(lblNewLabe_jx);
					
					JTextField textField = new JTextField();
					textField.setText("请输入产品名称的关键字");
					textField.setBounds(70, 315, 364, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JButton btnNewButton_cx = new JButton("查询");
					btnNewButton_cx.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_cx.setBounds(457, 305, 135, 43);
					btnNewButton_cx.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String key = textField.getText();
							table.removeAll();
							DefaultTableModel dt2 = Controller.getInstance().search_product(key);
							JTable table2 = new JTable(dt2);
							table2.setFont(new Font("黑体", Font.PLAIN, 14));
							scrollPane.setViewportView(table2);
						}
					});
					contentPane.add(btnNewButton_cx);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Product_man() {
		
	}
	private static Product_man frame = new Product_man();
	
	public static Product_man getInstance() {
		return frame;
	}
}