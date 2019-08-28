package com.assesmentQ5;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static TreeMap<Character, Integer> list = new TreeMap<Character, Integer>();
	
	public static void main(String[] args) {
		System.out.println("Enter the sentence :");
		String sentence = scanner.nextLine();
		sentence = sentence.replaceAll("\\s+","");
		LetterSequence ls = new LetterSequence();
		list =ls.computeFrequency(sentence);
		
		ls.displayLetterFrequency(list);
	}
}
