package com.example1_MultiCast_Server;
import java.net.*;
import java.io.*;

public class MulticastChatClient {
    
    public static void ClientSide(String msg)
    throws Exception {
        
        
        // Default port number we are going to use
        int portnumber = 1236;
        
        
        // Create a MulticastSocket
        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);
        
        // Determine the IP address of a host, given the host name
        InetAddress group =
                InetAddress.getByName("226.0.0.1");
        
        // Joins a multicast group
        chatMulticastSocket.joinGroup(group);
        
        // Prompt a user to enter a message
        System.out.println("Type a message for the server:");
        
        
        // Send the message to Multicast address
        DatagramPacket data = new
                DatagramPacket(msg.getBytes(), 0,
                msg.length(), group, portnumber);
        chatMulticastSocket.send(data);
        
        // Close the socket
        chatMulticastSocket.close();
    }
}