package com.example2_IOStreamSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class ReaderWriter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderWriter frame = new ReaderWriter();
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
	public ReaderWriter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(88, 11, 239, 136);
		contentPane.add(txtArea);
		
		JButton btnNewButton = new JButton("Write");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String content = txtArea.getText();
				try {
					FileWriter out = new FileWriter(new File("outagain.txt"));
					PrintWriter outputStream = new PrintWriter(out);
					String l=content;
						outputStream.println(l);
					
					System.out.println("FileWriterReader ");
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(100, 174, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Read");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = "";
				try {
					FileReader in = new FileReader(new File("farrago.txt"));
					BufferedReader inpuStream = new BufferedReader(in);
					String l;
					while((l=inpuStream.readLine())!= null) {
						System.out.println(l);
						content+= l+"\n";
					}
					txtArea.setText(content);
					
					System.out.println("FileWriterReader ");
					in.close();
				} catch (Exception ea) {
					// TODO Auto-generated catch block
					ea.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(226, 174, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
