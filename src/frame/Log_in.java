package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Log_in extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//instance 就是 frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Log_in() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 369);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(409, 242, 206, 80);
		lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
		contentPane.add(lblNewLabel);
		
		JTextField textField_zh = new JTextField();
		textField_zh.setBounds(158, 44, 227, 24);
		contentPane.add(textField_zh);
		textField_zh.setColumns(10);
		
		JTextField textField_mm = new JTextField();
		textField_mm.setBounds(158, 116, 227, 24);
		textField_mm.setColumns(10);
		contentPane.add(textField_mm);
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(72, 47, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(72, 119, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("神秘按钮");
		btnNewButton.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Message.getInstance().notmain();
			}
		});
		btnNewButton.setBounds(424, 35, 135, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("游客模式");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.getInstance().visit();
			}
		});
		btnNewButton_1.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton_1.setBounds(424, 107, 135, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("登录");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField_zh.getText();
				String password = textField_mm.getText();
				Controller.getInstance().log_in(id, password);
				textField_zh.setText("");
				textField_mm.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton_2.setBounds(250, 176, 135, 43);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("退出");
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(424, 176, 135, 43);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("注册");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register.getInstance().notmain("游客", 0);
			}
		});
		btnNewButton_2_1.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton_2_1.setBounds(72, 176, 135, 43);
		contentPane.add(btnNewButton_2_1);
	}
	
	private static Log_in frame = new Log_in();
	
	public static Log_in getInstance() {
		return frame;
	}
	//frame 就是 instance
}
