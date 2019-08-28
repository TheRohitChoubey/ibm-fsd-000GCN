package com.example_1_Client_Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
/* SERVER may enhance to work for multiple clients */
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import com.example_Thread.Employee;
import com.example_Thread.EmployeeService;
import com.example_Thread.EmployeeServiceImpl;
import java.sql.*;


public class NetworkingServer implements Serializable {
    
    public static void main(String [] args) throws SQLException {
    	EmployeeService service = new EmployeeServiceImpl();
        ServerSocket server = null;
        Socket client;
        
        // Default port number we are going to use
        int portnumber = 12345;
       
        // Create Server side socket
        try {
            server = new ServerSocket(portnumber);
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("ServerSocket is created " + server);
        
        // Wait for the data from the client and reply
        while(true) {
            
            try {
                
                // Listens for a connection to be made to
                // this socket and accepts it. The method blocks until
                // a connection is made
                System.out.println("Waiting for connect request...");
                client = server.accept();
                
                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
                
                // Read data from the client
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new
                        InputStreamReader(clientIn));
                String id = br.readLine();
                System.out.println("Message received from client = " + id);
                
                // Send response to the client
                if (id != null && !id.equalsIgnoreCase("bye")) {
                	Employee rse =service.getEmployeeById(Integer.parseInt(id));
                	
                	ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
                    clientOut.writeObject(rse);
                }
                // Close sockets
                if (id != null && id.equalsIgnoreCase("bye")) {
                    server.close();
                    client.close();
                    break;
                }
                
            } catch (IOException ie) {
            }
        }
    }
}