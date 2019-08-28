package com.example_ProducerConsumer;

public class ProducerConsumerTester{
	
	private static final MyStack myStack=new MyStack();

	public static void main(String[] args) {
		StackProducer prod = new StackProducer(myStack);
		Thread t1 = new Thread(prod);
		t1.start();
		
		StackConsumer cons = new StackConsumer(myStack);
		Thread t2 = new Thread(cons);
		t2.start();
	}

}