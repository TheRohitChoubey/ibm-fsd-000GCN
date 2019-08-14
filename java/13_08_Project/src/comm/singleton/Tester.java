package comm.singleton;

import comm.array.ArrayDemo;

public class Tester {

	public static void main(String[] args) {
		Messaging m=Messaging.createMessagingObject("Rohit");
		System.out.println(m);
		
		ArrayDemo arraydemoobj = new ArrayDemo();
		arraydemoobj.createArray(26);
		
		System.out.println(" "+arraydemoobj.getArray());
	}

}
