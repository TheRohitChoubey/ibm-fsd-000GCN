
package com.example4_FileAndDatabase;

import java.io.*;
import java.sql.SQLException;

import com.example_Thread.Employee;
import com.example_Thread.EmployeeService;
import com.example_Thread.EmployeeServiceImpl;

public class InputClass {

	public static void main(String[] args) throws IOException, SQLException {
		EmployeeService service = new EmployeeServiceImpl();
		try {
			FileReader in = new FileReader(new File("farrago.txt"));

			BufferedReader inpuStream = new BufferedReader(in);

			String sd;

			while ((sd = inpuStream.readLine())!= null) { 	
				int id = Integer.parseInt(sd);
				String firstName = inpuStream.readLine();
				String lastName = inpuStream.readLine();
				String email = inpuStream.readLine();
				
				service.createEmployee(new Employee(id, firstName, lastName, email));
			}
			System.out.println("FileWriterReader ");

			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}