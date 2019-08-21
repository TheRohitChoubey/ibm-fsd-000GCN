package com.example_Thread;

import java.sql.*;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	private MyConnectionFactory factory = null;
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public EmployeeDaoImpl() throws SQLException {
		super();
		factory = MyConnectionFactory.createObject();
		connection = factory.getConnection();
	}

	@Override
	public ResultSet getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from employee");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = new Employee();
		try {
			statement = connection.createStatement();
			resultSet = null;
			resultSet = statement.executeQuery("select * from employee where id = "+id);
			resultSet.next();
			e = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
					resultSet.getString(4));
			System.out.println("Id = "+resultSet.getInt(1));
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return e;
	}

	@Override
	public Employee delEmployeeById(int id) {
		Employee e = new Employee();
		try {
			pStatement = connection.prepareStatement("delete from employee where id = ?");
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		return e;
	}
	
	@Override
	public void createEmployee(Employee employee) {
		try {
			pStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getFirstName());
			pStatement.setString(3, employee.getLastName());
			pStatement.setString(4, employee.getEmail());
			pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("duplicate id");

			e.printStackTrace();
		} finally {

		}

	}

}