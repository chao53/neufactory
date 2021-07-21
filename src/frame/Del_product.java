package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Controller;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Del_product extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setTitle("移除商品");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(650, 200, 525, 203);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JTextField textField = new JTextField();
					textField.setBounds(220, 29, 112, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\fxxm.png"));
					lblNewLabel.setBounds(363, 13, 122, 127);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("请输入要移除的商品ID");
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(32, 31, 187, 18);
					contentPane.add(lblNewLabel_1);
					
					JButton btnNewButton_1_1 = new JButton("确定");
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String id = textField.getText();
							Controller.getInstance().del_product(id, user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.setBounds(197, 89, 135, 43);
					contentPane.add(btnNewButton_1_1);
					
					JButton btnNewButton_1_1_1 = new JButton("返回");
					btnNewButton_1_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1_1.setBounds(35, 89, 135, 43);
					contentPane.add(btnNewButton_1_1_1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Del_product() {
		
	}
	public static Del_product frame = new Del_product();
	
	public static Del_product getInstance() {
		return frame;
	}
}
