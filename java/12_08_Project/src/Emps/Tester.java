package Emps;

public class Tester {

	public static void main(String[] args) {
		Employee e = null;
		e= new PermanentEmployee("Rohit","Choubey","CSE",200);
		
		System.out.println(e.getDetails());
		
		e= new ContractualEmployee("Mohit","Choubey","ME",400);
		System.out.println(e.getDetails());
	}

}
