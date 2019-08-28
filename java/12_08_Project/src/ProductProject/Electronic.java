package ProductProject;

public class Electronic extends Product {
	private String Ename,manufactureDate;

	public Electronic(String en,String md,int rate) {
		super(rate);
		this.Ename = en;
		this.manufactureDate = md;
	}
	
	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	
}
