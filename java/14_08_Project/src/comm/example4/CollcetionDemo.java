package comm.example4;

import java.io.StreamCorruptedException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class CollcetionDemo {
	static Scanner sc = new Scanner(System.in);

	private String str[];
	private Set set;

	public CollcetionDemo() throws InputMismatchException {
		System.out.println("Number of Elements in the Array : ");
		str = new String[sc.nextInt()];
		set = new HashSet();
		for (int i = 0; i < str.length; i++) {
			System.out.println("Name : ");
			str[i] = sc.next().toString();
			if(!set.add(str[i])) {
				System.out.println("Duplicate elemnt found not added in set");
			}
		}
		
		
	}
	
	public void displayCollection() {
		Iterator i = set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
	}
}













