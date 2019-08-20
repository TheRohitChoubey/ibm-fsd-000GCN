package com.example_ProducerConsumer;

public class MyThread3 extends Thread {
	@Override
	public void run() {
		super.run();
	}
	
	public static void main(String[] args) {
		MyThread3 three = new MyThread3();
		three.start();
	}
}
