package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Controller;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_product extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(String user_id,int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setTitle("添加商品");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(650, 200, 461, 418);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel.setBounds(238, 287, 205, 90);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("所有人都能添加商品，除了游客！");
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(41, 46, 332, 18);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("请输入商品名称");
					lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_2.setBounds(41, 99, 125, 18);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel("请输入商品描述");
					lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3.setBounds(41, 158, 125, 18);
					contentPane.add(lblNewLabel_3);
					
					JTextField textField = new JTextField();
					textField.setBounds(173, 97, 200, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JTextField textField_1 = new JTextField();
					textField_1.setBounds(173, 156, 200, 24);
					contentPane.add(textField_1);
					textField_1.setColumns(10);
					
					JButton btnNewButton_1 = new JButton("添加");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String name =  textField.getText();
							String description = textField_1.getText();
							Controller.getInstance().add_product(name, description, user_id,p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(238, 222, 135, 43);
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_1_1 = new JButton("返回");
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.setBounds(41, 222, 135, 43);
					contentPane.add(btnNewButton_1_1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Add_product() {

	}
	
	public static Add_product frame = new Add_product();
	
	public static Add_product getInstance() {
		return frame;
	}
}
