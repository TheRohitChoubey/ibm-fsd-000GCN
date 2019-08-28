package com.example1_SwingDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example_Thread.EmployeeService;
import com.example_Thread.EmployeeServiceImpl;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ViewEmployeeData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static EmployeeService service;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		service = new EmployeeServiceImpl();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployeeData frame = new ViewEmployeeData();
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
	public ViewEmployeeData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnFetchData = new JButton("Fetch Data");
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSet resultSet = service.getAllEmployees();
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setRowHeaderView(btnFetchData);
	}

}
