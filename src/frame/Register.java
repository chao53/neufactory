package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void notmain(String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setTitle("注册新用户");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(650, 200, 461, 517);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JTextField textField_yhm = new JTextField();
					textField_yhm.setBounds(133, 37, 242, 24);
					contentPane.add(textField_yhm);
					textField_yhm.setColumns(10);
					
					JTextField textField_sj = new JTextField();
					textField_sj.setBounds(133, 87, 242, 24);
					contentPane.add(textField_sj);
					textField_sj.setColumns(10);
					
					JTextField textField_mm2 = new JTextField();
					textField_mm2.setBounds(133, 187, 242, 24);
					contentPane.add(textField_mm2);
					textField_mm2.setColumns(10);
					
					JTextField textField_mm = new JTextField();
					textField_mm.setBounds(133, 137, 242, 24);
					contentPane.add(textField_mm);
					textField_mm.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel.setBounds(240, 391, 202, 86);
					contentPane.add(lblNewLabel);
					
					JTextField textField_yzm = new JTextField();
					textField_yzm.setBounds(133, 287, 96, 24);
					contentPane.add(textField_yzm);
					textField_yzm.setColumns(10);
					
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setIcon(new ImageIcon("img\\yzm.png"));
					lblNewLabel_1.setBounds(240, 280, 135, 37);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel_2 = new JLabel("看不清楚？点我也没用！");
					lblNewLabel_2.setForeground(new Color(0, 0, 255));
					lblNewLabel_2.setBounds(240, 315, 175, 18);
					contentPane.add(lblNewLabel_2);
					
					JLabel lblNewLabel_3 = new JLabel("用户名");
					lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3.setBounds(47, 40, 72, 18);
					contentPane.add(lblNewLabel_3);
					
					JLabel lblNewLabel_3_1 = new JLabel("手机号码");
					lblNewLabel_3_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3_1.setBounds(47, 90, 72, 18);
					contentPane.add(lblNewLabel_3_1);
					
					JLabel lblNewLabel_3_2 = new JLabel("设置密码");
					lblNewLabel_3_2.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3_2.setBounds(47, 140, 72, 18);
					contentPane.add(lblNewLabel_3_2);
					
					JLabel lblNewLabel_3_3 = new JLabel("确认密码");
					lblNewLabel_3_3.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3_3.setBounds(47, 190, 72, 18);
					contentPane.add(lblNewLabel_3_3);
					
					JLabel lblNewLabel_3_4 = new JLabel("验证码");
					lblNewLabel_3_4.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_3_4.setBounds(47, 290, 72, 18);
					contentPane.add(lblNewLabel_3_4);
					
					JButton btnNewButton_2 = new JButton("返回");
					btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2.setBounds(47, 346, 135, 43);
					contentPane.add(btnNewButton_2);
					
					JLabel lblNewLabel_4 = new JLabel("用户类型");
					lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_4.setBounds(47, 240, 72, 18);
					contentPane.add(lblNewLabel_4);
					
					JRadioButton jxs = new JRadioButton("经销商");
					jxs.setFont(new Font("黑体", Font.PLAIN, 17));
					JRadioButton gly = new JRadioButton("工厂管理员");
					gly.setFont(new Font("黑体", Font.PLAIN, 17));
					
					jxs.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jxs.setSelected(true);
							gly.setSelected(false);
						}
					});
					jxs.setBackground(Color.WHITE);
					jxs.setSelected(true);
					jxs.setBounds(155, 236, 84, 27);
					contentPane.add(jxs);
					
					gly.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							jxs.setSelected(false);
							gly.setSelected(true);
						}
					});
					gly.setSelected(false);
					gly.setBackground(Color.WHITE);
					gly.setBounds(262, 236, 120, 27);
					contentPane.add(gly);
					
					JButton btnNewButton_2_1 = new JButton("注册");
					btnNewButton_2_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String id =  textField_yhm.getText();
							String number = textField_sj.getText();
							String password = textField_mm.getText();
							String password2 = textField_mm2.getText();
							int power;
							if(jxs.isSelected()) {
								power = 1;
							}else {
								power = 2;
							}
							Controller.getInstance().register(id, number, password, password2, power, user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2_1.setBounds(240, 346, 135, 43);
					contentPane.add(btnNewButton_2_1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Register() {
		
	}
	private static Register frame = new Register();
	
	public static Register getInstance() {
		return frame;
	}
}
