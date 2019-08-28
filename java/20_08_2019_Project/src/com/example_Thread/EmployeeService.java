package com.example_Thread;

import java.sql.ResultSet;
import java.util.List;


public interface EmployeeService {
	public void createEmployee(Employee employee);
	public ResultSet getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee delEmployeeById(int id);

}