package com.example1_MultiCast_Server;

import java.net.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.net.*;

public class ServerApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerApp frame = new ServerApp();
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
	public ServerApp() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String msg = "Default";
		try {
			ServerApp s = new ServerApp();
			// Default port number we are going to use
			int portnumber = 1236;

			// Create a MulticastSocket
			MulticastSocket serverMulticastSocket = new MulticastSocket(portnumber);
			System.out.println("MulticastSocket is created...");

			// Determine the IP address of a host, given the host name
			InetAddress group = InetAddress.getByName("226.0.0.1");

			// getByName- returns IP address of given host
			serverMulticastSocket.joinGroup(group);
			System.out.println("joinGroup method is called...");
			boolean infinite = true;

			// Continually receives data and prints them
			while (infinite) {
				byte buf[] = new byte[1024];
				DatagramPacket data = new DatagramPacket(buf, buf.length);
				serverMulticastSocket.receive(data);
				msg = new String(data.getData()).trim();
				System.out.println("Message received from client = " + msg);

			}
			serverMulticastSocket.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 26, 352, 175);
		contentPane.add(textArea);
		textArea.setText(msg);
		

	}
}
