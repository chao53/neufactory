package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Message extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//instance 就是 frame
	public void notmain() {
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

	private Message() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
		setTitle("神秘讯息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 200, 524, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("收到");
		btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(314, 162, 135, 43);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("超级管理员(最高权限,为所欲为）账号：000    密码:000");
		lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(12, 13, 480, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("工厂管理员1号               账号：111    密码:111");
		lblNewLabel_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(17, 44, 460, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\xm.png"));
		lblNewLabel.setBounds(65, 109, 172, 148);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("经销商1号                   账号：222    密码:222");
		lblNewLabel_1_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
		lblNewLabel_1_1_1.setBounds(15, 75, 462, 30);
		contentPane.add(lblNewLabel_1_1_1);
	}
	private static Message frame = new Message();
	
	public static Message getInstance() {
		return frame;
	}
	//frame 就是 instance
}
