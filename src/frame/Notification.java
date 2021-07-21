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

public class Notification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(int j) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String notification = null;
					switch(j) {
					case 1:
						notification = "注册成功！";
						break;
					case 2:
						notification = "登录成功！";
						break;
					case 3:
						notification = "删除成功！";
						break;
					case 4:
						notification = "修改成功！";
						break;
					case 5:
						notification = "添加成功！";
						break;
					case 6:
						notification = "操作成功！";
						break;
					case 7:
						notification = "租借成功！";
						break;
					case 8:
						notification = "归还成功！";
						break;
					case 9:
						notification = "发布成功！";
						break;
					case 10:
						notification = "接单成功！";
						break;
					case 11:
						notification = "接单成功！";
						break;
					}
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setTitle(notification);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 482, 300);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JButton btnNewButton_1_1 = new JButton("确定");
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1.setBounds(156, 191, 135, 43);
					contentPane.add(btnNewButton_1_1);
					
					JLabel lblNewLabel_1 = new JLabel(notification,JLabel.CENTER);
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(0, 13, 460, 30);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\xm.png"));
					lblNewLabel.setBounds(105, 56, 135, 122);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setIcon(new ImageIcon("img\\fxxm.png"));
					lblNewLabel_2.setBounds(223, 56, 138, 122);
					contentPane.add(lblNewLabel_2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Notification() {
		
	}
	private static Notification frame = new Notification();
	
	public static Notification getInstance() {
		return frame;
		//instance 就是 frame
	}
}
