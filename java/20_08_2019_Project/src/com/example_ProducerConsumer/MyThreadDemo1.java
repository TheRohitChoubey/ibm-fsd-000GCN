package com.example_ProducerConsumer;

public class MyThreadDemo1 implements Runnable {
	public static void main(String[] args) {

		MyThreadDemo1 myThread1 = new MyThreadDemo1();
		Thread t1 = new Thread(myThread1);
		Thread t2 = new Thread(myThread1);
		t1.start();
		System.out.println(t1.isAlive());
		t2.start();
		System.out.println(t2.isAlive());
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				System.out.println("==> : " + i);
				if (i == 10) {
					Thread.yield();
				}
			}
		} catch (Exception e) {

		}
	}
}
