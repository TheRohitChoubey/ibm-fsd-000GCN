package com.example_1_Client_Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example_Thread.Employee;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ClientInput extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInput frame = new ClientInput();
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
	public ClientInput() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(163, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Id");
		lblNewLabel.setBounds(91, 14, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textField.getText();
				try {
					Employee emp = NetworkingClient.ClientConnect(id);
					textField_1.setText(id);
					textField_2.setText(emp.getFirstName());
					textField_3.setText(emp.getLastName());
					textField_4.setText(emp.getEmail());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnFind.setBounds(269, 10, 89, 23);
		contentPane.add(btnFind);
		
		textField_1 = new JTextField();
		textField_1.setBounds(34, 81, 27, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(71, 81, 104, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(195, 81, 119, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 81, 100, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(40, 56, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setBounds(91, 56, 65, 14);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(224, 56, 65, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(346, 56, 46, 14);
		contentPane.add(lblEmail);
	}
}
