package comm.example;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean setDay(int d) {
		if(d>30) {
			System.out.println("Day can't be greater than 30");
			return false;
		}
		else
		{
			day=d;
			return true;
		}
	}
	
	public boolean setMonth(int m) {
		if(m>12) {
			System.out.println("Month can't be greater than 12");
			return false;
		}
		else
		{
			month=m;
			return true;
		}
	}
	
	public boolean setYear(int y) {
		if(y<1990&&y>2019) {
			System.out.println("Wrong Year");
			return false;
		}
		else
		{
			year=y;
			return true;
		}
	}

}
