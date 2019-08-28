package com.example1_IOStream;
import java.io.*;

public class FileInputOutputStream {
	public static void main(String[] args) throws IOException {
		try {
			FileInputStream in = new FileInputStream(new File("farrago.txt"));
			FileOutputStream out = new FileOutputStream(new File("outagain.txt"));
			
			int c;
			
			while((c=in.read())!= -1) {
				System.out.println(c);
				out.write(c);
			}
			
			System.out.println("FileOutPutStream ");
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
