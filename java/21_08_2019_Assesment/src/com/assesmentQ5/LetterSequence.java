package com.assesmentQ5;

import java.util.*;

public class LetterSequence {
	private String sentence;

	public TreeMap<Character, Integer> computeFrequency(String s) {
		TreeMap<Character, Integer> list = new TreeMap<Character, Integer>();
		for (Character c : s.toCharArray()) {
			if (list.containsKey(c)) {
				list.put(c, list.get(c) + 1);
			} else {
				list.put(c, 1);
			}
		}
		return list;
	}

	public void displayLetterFrequency(TreeMap<Character, Integer> frequencyMap) {
		for (Map.Entry e : frequencyMap.entrySet()) {
			System.out.print(e.getKey() + " - ");
			for (int i = 0; i < (Integer) e.getValue(); i++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}

}
