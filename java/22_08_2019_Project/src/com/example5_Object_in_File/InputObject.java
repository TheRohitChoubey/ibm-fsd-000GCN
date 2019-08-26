package com.example5_Object_in_File;

import java.io.*;

public class InputObject {

	public static void main(String[] args) throws IOException{
		Employee emp = new Employee();
		try {
			 FileOutputStream out = new FileOutputStream("farrago.txt");
			 ObjectOutputStream oos = new ObjectOutputStream(out);
			 oos.writeObject(emp);
			 oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			 FileInputStream in = new FileInputStream("farrago.txt");
			 ObjectInputStream oos = new ObjectInputStream(in);
			 //emp = (Employee)(oos.readObject());
			 System.out.println(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}