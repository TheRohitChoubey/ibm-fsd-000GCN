package Emps;

public class PermanentEmployee extends Employee {
	
	private int salary;
	
	public PermanentEmployee() {
		super();
	}
	
	public PermanentEmployee(String fn, String ln, String dp,int sal) {
		super(fn,ln,dp);
		this.salary = sal;
	}
	
	@Override
	protected String getDetails() {
		return super.getDetails()+" Salary = "+this.salary;
	}
}
