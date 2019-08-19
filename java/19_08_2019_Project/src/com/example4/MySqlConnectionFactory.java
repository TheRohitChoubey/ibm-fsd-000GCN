package com.example4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {
	
	private static Connection connection=null;
	private static MySqlConnectionFactory connectionFactory;
	
	private MySqlConnectionFactory()throws SQLException
	{
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr","root","root");
	}
	
	
	public static MySqlConnectionFactory createConnection()throws SQLException
	{
		if(connectionFactory==null)
		{
			connectionFactory=new MySqlConnectionFactory();
		}
		return connectionFactory;
	}
	public Connection getConnection()throws SQLException
	{
		return connection;
	}

}