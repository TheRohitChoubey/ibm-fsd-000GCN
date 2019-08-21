package com.assesmentQ1;
import java.util.*;

public class AgeComparator implements Comparator<Employee> {

	

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

}
