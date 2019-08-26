package com.example_1_Client_Server;
/* CLIENT */
import java.io.*;
import java.net.*;
import java.sql.*;

import com.example_Thread.Employee;

public class NetworkingClient {
    
    public static Employee ClientConnect(String msg) throws ClassNotFoundException, SQLException {
        
        Socket client = null;
        
        // Default port number we are going to use
        int portnumber = 12345;
      
            try {
                
                // Create a client socket
                
                client = new Socket(InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created " + client);
                
                // Create an output stream of the client socket
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                
                pw.println(msg);
                
             // Create an input stream of the client socket
                ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());
                Employee e = (Employee)clientIn.readObject();
                // Read data from the input stream of the client socket.
                pw.close();
                client.close();
                return e;
                
            } catch (IOException ie) {
                System.out.println("I/O error - Start server and turn off Firewall" + ie);
            }
            return null;
    }
}