package comm.example.p1;

public class MyDate {
	private int x;
	private int y;
	private int z;
	
	public MyDate() {
		this(10);
	}
	
	public MyDate(int x) {
		this(x,20);
	}
	
	public MyDate(int x,int y) {
		this(x,y,30);
	}
	
	public MyDate(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public String getDataXY() {
		return "x="+this.x+" y="+this.y+" z="+this.z;
	}
	
	public static void main(String[] args) {
		
		MyDate myDate= new MyDate();
		System.out.println(myDate.getDataXY());

	}

}
