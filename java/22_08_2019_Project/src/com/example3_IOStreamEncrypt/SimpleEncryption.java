package com.example3_IOStreamEncrypt;
import java.io.*;

public class SimpleEncryption {
	private BufferedReader	reader;
	private BufferedWriter writer;

	public void encrypt(String source , String dest, int shift) throws IOException {
		reader = new BufferedReader(new FileReader(source));
		writer = new BufferedWriter(new FileWriter(dest));
		String line = reader.readLine();
		int data;
		while(line!=null) {
			int count = 0;
			for(int i =0; i<line.length();i++) {
				if(line.charAt(i)=='a' || line.charAt(i)=='e' ||line.charAt(i)=='i' ||line.charAt(i)=='o' ||line.charAt(i)=='u'||
						line.charAt(i)=='A' || line.charAt(i)=='E' ||line.charAt(i)=='I' ||line.charAt(i)=='O' 
						||line.charAt(i)=='U') {
					count++;
				}
				data = line.charAt(i) + shift;
				writer.write(data);
			}
			writer.write("--total vovel are "+count);
			writer.write('\n');
			line = reader.readLine();
		}
		reader.close();
		writer.close();
	}
	
	public void showEncrypt(String source) throws IOException {
		reader = new BufferedReader(new FileReader(source));
		String line = reader.readLine();
		while(line!=null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

}