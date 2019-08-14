package comm.example1;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		String fname,lname;
		Data d1[] = new Data[20];
		Scanner sc = new Scanner(System.in);
		d1[0] = new Data();
		int i=1;
		try {
			do {
				System.out.println("Enter First Name : ");
				fname = sc.next();
				System.out.println("Enter Last Name : ");
				lname = sc.next();
				d1[i] = new Data(fname,lname);
				int j =i-1;
				while(j>=0) {
					d1[i].isEquals(d1[j]);
					j--;
				}
				i++;
			}while(i<20);
		} catch (FirstLastNameNotValid e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
