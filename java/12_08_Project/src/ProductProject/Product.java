package ProductProject;

public class Product {
	private int rate;
	private static int item;
	
	static {
		item=0;
	}
	
	public Product(int rt) {
		this.rate = rt;
	}
	
	public static int getItem() {
		return ++item;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
}
