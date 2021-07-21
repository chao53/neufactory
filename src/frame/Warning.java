package frame;

import java.awt.EventQueue;
import java.awt.Font;

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

public class Warning extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void notmain(int s) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String warning = null;
					switch(s) {
//************************************user*********************************************************************
					case 1:
						warning = "用户名不能有空格！";
						break;
					case 2:
						warning = "密码不能有空格！";
						break;
					case 3:
						warning = "手机号码格式错误！";
						break;
					case 4:
						warning = "信息不能为空！";
						break;
					case 5:
						warning = "两次输入的密码不同！";
						break;
					case 6:
						warning = "已有相同用户名被注册！";
						break;
					case 7:
						warning = "用户名不存在！";
						break;
					case 8:
						warning = "密码错误！用户将被锁定1秒钟！";
						break;
					case 9:
						warning = "";
						break;
					case 10:
						warning = "";
						break;
					case 11:
						warning = "没人能删除超级管理员！即使是他自己！";
						break;
					case 12:
						warning = "你没用权限删除任何用户！";
						break;
					case 13:
						warning = "你只能删除自己的账号！";
						break;
					case 14:
						warning = "你只能修改自己的账号！";
						break;
					case 15:
						warning = "你没用权限修改任何账号！";
						break;
//********************************equipment**************************************************************************						
					case 16:
						warning = "超级管理员才能为产中心添加设备！";
						break;
					case 17:
						warning = "你没有权限删除任何设备！";
						break;
					case 18:
						warning = "你只能删除自己工厂的设备！";
						break;
					case 19:
						warning = "设备不存在！";
						break;
					case 20:
						warning = "你没有权限操控任何设备！";
						break;
					case 21:
						warning = "你只能操控自己工厂的设备！";
						break;
					case 22:
						warning = "你没有权限修改任何设备信息！";
						break;
					case 23:
						warning = "你只能修改自己工厂设备的信息！";
						break;
//*************************************factory**************************************************************************
					case 24:
						warning = "你无权注册工厂！";
						break;
					case 25:
						warning = "已有名称相同的工厂被注册！";
						break;
					case 26:
						warning = "你没有权限启用或停用任何工厂！";
						break;
					case 27:
						warning = "你只能停用或启用自己的工厂！";
						break;
					case 28:
						warning = "你没有权限修改任何工厂信息！";
						break;
					case 29:
						warning = "你只能修改自己工厂的信息！";
						break;
					case 30:
						warning = "工厂不存在！";
						break;
					case 31:
						warning = "你没有权限管理任何工厂！";
						break;
					case 32:
						warning = "你只能管理自己的工厂！";
						break;
					case 33:
						warning = "你已租借该设备！";
						break;
					case 34:
						warning = "你并没有租借该设备！";
						break;
//********************************product************************************************************************************
					case 35:
						warning = "游客不能创建商品！";
						break;
					case 36:
						warning = "商品不存在！";
						break;
					case 37:
						warning = "超级管理员才能删除产品！";
						break;
					case 38:
						warning = "超级管理员才能修改产品信息！";
						break;
					case 39:
						warning = "已有相同名字的产品被注册！";
						break;
//********************************order************************************************************************************
					case 40:
						warning = "只有经销商和超级管理员能发布订单！";
						break;
					case 41:
						warning = "信息不能为空！";
						break;
					case 42:
						warning = "设备已被删除,发布失败！";
						break;
					case 47:
						warning = "产品已被删除，发布失败！";
						break;
					case 43:
						warning = "已有同名订单被发布！";
						break;
					case 44:
						warning = "你无权删除任何订单！";
						break;
					case 45:
						warning = "你只能删除自己发布的订单！";
						break;
					case 46:
						warning = "你不能删除已被接单的订单！";
						break;
					case 48:
						warning = "订单不存在！";
						break;
					case 49:
						warning = "你无权修改订单！";
						break;
					case 50:
						warning = "你只能修改自己创建的订单！";
						break;
					case 51:
						warning = "你只能签收自己创建的订单！";
						break;
					case 52:
						warning = "不能签收已签收的订单！";
						break;
					case 53:
						warning = "你无权签收订单！";
						break;
					case 54:
						warning = "不能签收未被接的订单！";
						break;
					}
		
					
					frame.setVisible(true);
					frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					frame.setTitle(warning);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 419, 230);
					JPanel contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					frame.setContentPane(contentPane);
					contentPane.setLayout(null);
					
					JButton btnNewButton_1_1 = new JButton("返回");
					btnNewButton_1_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_1_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_1_1.setBounds(214, 100, 135, 43);
					contentPane.add(btnNewButton_1_1);
					
					JLabel lblNewLabel_1 = new JLabel(warning,JLabel.CENTER);
					lblNewLabel_1.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_1.setBounds(0, 13, 420, 30);
					contentPane.add(lblNewLabel_1);
					
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon("img\\xm.png"));
					lblNewLabel.setBounds(65, 30, 172, 148);
					contentPane.add(lblNewLabel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Warning() {
		
	}
	private static Warning frame = new Warning();
	
	public static Warning getInstance() {
		return frame;
	}
}
