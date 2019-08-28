package com.example3_IOStreamEncrypt;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		SimpleEncryption e =new SimpleEncryption();
		e.encrypt("data.txt", "encrypt.txt", 4);
		e.showEncrypt("encrypt.txt");

	}

}