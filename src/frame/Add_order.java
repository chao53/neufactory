package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Add_order extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public void notmain(String user_id, int p) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					setTitle("新建订单");
					setIconImage(Toolkit.getDefaultToolkit().getImage("img\\xm.png"));
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(650, 200, 497, 527);
					contentPane = new JPanel();
					contentPane.setBackground(Color.WHITE);
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					setContentPane(contentPane);
					contentPane.setLayout(null);
					
					textField = new JTextField();
					textField.setBounds(192, 40, 219, 24);
					contentPane.add(textField);
					textField.setColumns(10);
					
					textField_2 = new JTextField();
					textField_2.setBounds(192, 188, 219, 24);
					contentPane.add(textField_2);
					textField_2.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("请输入订单名称");
					lblNewLabel.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel.setBounds(57, 40, 135, 18);
					contentPane.add(lblNewLabel);
					
					JLabel lblNewLabel_2 = new JLabel("请输入产品数量");
					lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_2.setBounds(57, 190, 135, 18);
					contentPane.add(lblNewLabel_2);
					
					DefaultComboBoxModel<String> cb1 = Controller.getInstance().product_combobox();
					JComboBox<String> comboBox = new JComboBox<String>(cb1);
					comboBox.setMaximumRowCount(6);
					comboBox.setFont(new Font("黑体", Font.PLAIN, 17));
					comboBox.setBounds(192, 87, 219, 24);
					contentPane.add(comboBox);
					
					JLabel lblNewLabel_3 = new JLabel("");
					lblNewLabel_3.setIcon(new ImageIcon("img\\bg2.jpg"));
					lblNewLabel_3.setBounds(276, 386, 206, 99);
					contentPane.add(lblNewLabel_3);
					
					DefaultComboBoxModel<String> cb2 = Controller.getInstance().equipment_combobox();
					JComboBox<String> comboBox_1 = new JComboBox<String>(cb2);
					comboBox_1.setFont(new Font("黑体", Font.PLAIN, 17));
					comboBox_1.setMaximumRowCount(6);
					comboBox_1.setBounds(192, 137, 219, 24);
					contentPane.add(comboBox_1);
					
					JButton btnNewButton_2 = new JButton("返回");
					btnNewButton_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2.setBounds(57, 341, 135, 43);
					contentPane.add(btnNewButton_2);
					
					JButton btnNewButton_2_1 = new JButton("发布");
					btnNewButton_2_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String name = textField.getText();
							String product = (String) comboBox.getSelectedItem();
							String equipment = (String) comboBox_1.getSelectedItem();
							String quantity = textField_2.getText();
							String address = textField_3.getText();
							String date = textField_4.getText();
							Controller.getInstance().add_order(name, product, quantity, equipment, address, date, user_id, p);
							frame.setVisible(false);
							frame.dispose();
						}
					});
					btnNewButton_2_1.setFont(new Font("黑体", Font.PLAIN, 17));
					btnNewButton_2_1.setBounds(276, 341, 135, 43);
					contentPane.add(btnNewButton_2_1);
					
					JLabel lblNewLabel_4 = new JLabel("请选择目标产品");
					lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_4.setBounds(57, 90, 125, 18);
					contentPane.add(lblNewLabel_4);
					
					JLabel lblNewLabel_5 = new JLabel("请指定生产设备");
					lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_5.setBounds(57, 140, 125, 18);
					contentPane.add(lblNewLabel_5);
					
					JLabel lblNewLabel_6 = new JLabel("请输入收货地址");
					lblNewLabel_6.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_6.setBounds(57, 240, 125, 18);
					contentPane.add(lblNewLabel_6);
					
					JLabel lblNewLabel_7 = new JLabel("请输入截止日期");
					lblNewLabel_7.setFont(new Font("黑体", Font.PLAIN, 17));
					lblNewLabel_7.setBounds(57, 290, 125, 18);
					contentPane.add(lblNewLabel_7);
					
					textField_3 = new JTextField();
					textField_3.setBounds(192, 238, 219, 24);
					contentPane.add(textField_3);
					textField_3.setColumns(10);
					
					textField_4 = new JTextField();
					textField_4.setBounds(192, 288, 219, 24);
					contentPane.add(textField_4);
					textField_4.setColumns(10);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Add_order() {

	}
	
	public static Add_order frame = new Add_order();
	
	public static Add_order getInstance() {
		return frame;
	}
}
