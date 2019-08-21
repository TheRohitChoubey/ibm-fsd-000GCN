package com.example_Thread;

import java.sql.ResultSet;
import java.util.*;

public interface EmployeeDao {
	public void createEmployee(Employee employee);
	public ResultSet getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee delEmployeeById(int id);
}
