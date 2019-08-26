package com.example1_TestCaseWriting;

import static org.junit.Assert.*;

import junit.framework.*;


public class AllTestClassFiles extends TestCase {
	
	public static TestSuite createTestSuite() {
		TestSuite testSuite = new TestSuite("TestCalculator");
		testSuite.addTest(new TestCalculator("add"));
		return testSuite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(createTestSuite());
	}
}
