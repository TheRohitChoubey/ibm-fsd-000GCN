package com.example1_TestCaseWriting;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TestCalculator extends TestCase {
	
	private int x;
	private int y;
	
	
	
	public TestCalculator(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		System.out.println("initialize method");
		x=5;
		y=7;
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		System.out.println("Clean-up method");
		x=0;
		y=0;
	}
	
	@Test
	public void testAdd() {
		System.out.println("Add");
		Calculator c = new Calculator();
		assertEquals(x+y, c.addMethod());
	}
	
	
	
}
