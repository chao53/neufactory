package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Controller;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Change_user extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void notmain(String id, String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setTitle("修改用户信息");
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(650, 200, 543, 318);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JTextField textField = new JTextField();
					textField.setBounds(204, 28, 286, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					JTextField textField_1 = new JTextField();
					textField_1.setBounds(204, 69, 286, 24);
					contentPane.add(textField_1);
					textField_1.setColumns(10);
					
					JTextField textField_2 = new JTextField();
					textField_2.setBounds(204, 112, 286, 24);
					contentPane.add(textField_2);
					textField_2.setColumns(10);
					
					JButton btnNewButton_1 = new JButton("确定");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String number = textField.getText();
							String password = textField_1.getText();
							String password2 = textField_2.getText();
							Controller.getInstance().change_user(id, number, password, password2, user_id, p);	
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1.setBounds(204, 190, 135, 43);
					contentPane.add(btnNewButton_1);
					
					JButton btnNewButton_1_1 = new JButton("返回");
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.setBounds(24, 190, 135, 43);
					contentPane.add(btnNewButton_1_1);
					
					JLabel lblNewLabel = new JLabel("请输入新的手机号码");
					lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel.setBounds(24, 30, 165, 18);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_1 = new JLabel("请输入新的密码");
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(24, 71, 123, 18);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setIcon(new ImageIcon("img\\fxxm.png"));
					lblNewLabel_2.setBounds(383, 149, 123, 127);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel("再次输入新的密码");
					lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3.setBounds(25, 114, 150, 18);
					contentPane.add(lblNewLabel_3);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Change_user() {		
	}
	public static Change_user frame = new Change_user();
	public static Change_user getInstance() {
		return frame;
	}
}
