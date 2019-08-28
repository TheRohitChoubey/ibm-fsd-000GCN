package com.example_JDBC;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class JdbcDemo1 {
	private static Properties properties = null;
	private static Scanner scanner = new Scanner(System.in);
	static {
		properties = new Properties();
		properties.put("JDBC_URL", "jdbc:mysql://localhost:3306/hr");
		properties.put("USER", "root");
		properties.put("PASSWORD", "root");
	}

	public JdbcDemo1() {
		super();

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// register the driver
		/*
		 * 
		 * DriverManager.registerDriver(new org.h2.Driver());
		 * Class.forName("org.h2.Driver");
		 * 
		 * //Connection
		 * connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/xIBM",
		 * "root","root"); Connection
		 * connection=DriverManager.getConnection(properties.getProperty("JDBC_URL"),
		 * properties.getProperty("USER"),properties.getProperty("PASSWORD")); Statement
		 * statement=connection.createStatement(); ResultSet
		 * resultSet=statement.executeQuery("select * from course");
		 * System.out.println("ID NAME PRICE"); while(resultSet.next()) {
		 * //System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "
		 * +resultSet.getInt(3)); System.out.printf("\n%d %s %d",
		 * resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)); }
		 */

		MySqlConnectionFactory factory = MySqlConnectionFactory.createConnection();

		Connection connection = factory.getConnection();
		System.out.println(connection);
		PreparedStatement pst = connection.prepareStatement("insert into course values(?,?,?)");
		System.out.print("ID: ");
		int id = scanner.nextInt();
		System.out.print("NAME: ");
		String name = scanner.next();
		System.out.print("AMOUNT: ");
		int amount = scanner.nextInt();
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, amount);
		int count = pst.executeUpdate();
		System.out.println(count + " row(s) updated");

		System.out.print("ID to be deleted: ");
		id = scanner.nextInt();

		pst = connection.prepareStatement("delete from course where id = ?");
		pst.setInt(1, id);
		count = pst.executeUpdate();
		System.out.println(count + " row(s) deleted");

		pst = connection.prepareStatement("update course set amount= ? where id = ?");

		System.out.print("ID to be updated: ");
		id = scanner.nextInt();

		System.out.print("New Amount: ");
		amount = scanner.nextInt();

		pst.setInt(1, amount);
		pst.setInt(2, id);

		count = pst.executeUpdate();
		System.out.println(count + " row(s) updated");

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from hr.course");

		System.out.printf(" Id Name Amount");
		while (rs.next()) {
			System.out.printf("\n %d %s %d",rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	}

}