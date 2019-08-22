package com.example1_IOStream;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyByFileReaderWriter {

	public static void main(String[] args) throws IOException {
		try {
			FileReader in = new FileReader(new File("farrago.txt"));
			FileWriter out = new FileWriter(new File("outagain.txt"));
			
			BufferedReader inpuStream = new BufferedReader(in);
			PrintWriter outputStream = new PrintWriter(out);
			
			String l;
			while((l=inpuStream.readLine())!= null) {
				System.out.println(l);
				outputStream.println(l);
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

