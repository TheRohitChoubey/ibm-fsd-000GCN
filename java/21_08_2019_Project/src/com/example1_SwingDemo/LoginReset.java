package com.example1_SwingDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example_Thread.Employee;
import com.example_Thread.EmployeeService;
import com.example_Thread.EmployeeServiceImpl;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
public class LoginReset extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnRest;
	private JLabel lblIdToBe;
	private JTextField textField_4;
	private JButton btnDelete;
	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	private static EmployeeService service;
	private JButton btnDelete_1;
	private JButton btnShowTable;
	public static void main(String[] args) throws SQLException {
		service = new EmployeeServiceImpl();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginReset frame = new LoginReset();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginReset() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(132, 28, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(42, 31, 46, 14);
		contentPane.add(lblId);

		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(42, 56, 69, 20);
		contentPane.add(lblName);

		JLabel lblEmail = new JLabel("Last Name");
		lblEmail.setBounds(42, 87, 69, 14);
		contentPane.add(lblEmail);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(42, 117, 46, 14);
		contentPane.add(lblEmail_1);

		textField_1 = new JTextField();
		textField_1.setBounds(132, 59, 124, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(132, 84, 124, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(132, 114, 124, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.createEmployee(new Employee(Integer.parseInt(textField.getText()), 
						textField_1.getText(), textField_2.getText(), textField_3.getText()));
			}
		});
		btnLogin.setBounds(50, 165, 89, 23);
		contentPane.add(btnLogin);

		btnRest = new JButton("Reset");
		btnRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField.setText("");
			}
		});
		btnRest.setBounds(167, 165, 89, 23);
		contentPane.add(btnRest);

		lblIdToBe = new JLabel("Id to be Deleted");
		lblIdToBe.setBounds(42, 212, 97, 14);
		contentPane.add(lblIdToBe);

		textField_4 = new JTextField();
		textField_4.setBounds(167, 209, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.delEmployeeById(Integer.parseInt(textField_4.getText()));
			}
		});
		btnDelete_1.setBounds(117, 237, 89, 23);
		contentPane.add(btnDelete_1);
		
		btnShowTable = new JButton("Show Table");
		btnShowTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEmployeeData();
			}
		});
		btnShowTable.setBounds(310, 227, 89, 23);
		contentPane.add(btnShowTable);
		
		JButton btnShowTwoTable = new JButton("Show two Table");
		btnShowTwoTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ViewTwoTable();
			}
		});
		btnShowTwoTable.setBounds(281, 113, 89, 23);
		contentPane.add(btnShowTwoTable);

		
	}
}
