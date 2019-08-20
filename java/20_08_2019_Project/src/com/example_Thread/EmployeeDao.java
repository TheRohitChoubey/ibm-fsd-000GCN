package com.example_Thread;

import java.util.*;

public interface EmployeeDao {
	public void createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
}
