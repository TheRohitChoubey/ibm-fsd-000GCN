package ProductProject;

public class Tv extends Electronic {
	private String brand;
	
	public Tv(String en,String md,String br,int rate) {
		super(en,md,rate);
		this.brand = br;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
