package Emps;

public class ContractualEmployee extends Employee {
	
	private int ratePerHour;
	
	public ContractualEmployee() {
		super();
	}
	
	public ContractualEmployee(String fn, String ln, String dp,int rpm) {
		super(fn,ln,dp);
		this.ratePerHour = rpm;
	}
	
	@Override
	protected String getDetails() {
		return super.getDetails()+" Rate per Hour = "+this.ratePerHour;
	}
}
