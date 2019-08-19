package com.example1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ListDemo {
	public static void main(String[] args) {
		Collection<String> list = new ArrayList<String>();
		list.add("John");
		list.add("John");
		Set<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		list.addAll(set);
		System.out.println(list.isEmpty());
	}

}
