package com.example1_IOStream;
import java.io.*;
public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		try {
			FileReader in = new FileReader(new File("farrago.txt"));
			FileWriter out = new FileWriter(new File("outagain.txt"));
			
			int c;
			
			while((c=in.read())!= -1) {
				System.out.println((char)c);
				out.write(c);
			}
			
			System.out.println("FileWriterReader ");
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
