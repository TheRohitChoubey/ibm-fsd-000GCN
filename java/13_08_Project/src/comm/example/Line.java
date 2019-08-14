package comm.example;

public class Line extends Model {

	private int startPoint;
	private int endPoint;
	
	public Line(int sP,int eP) {
		this.startPoint=sP;
		this.endPoint = eP;
	}
	
	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	
	public int calculateLength() {
		return this.getEndPoint()-this.getStartPoint();
	}

	public boolean isGreater(Object obj2) {
		Line l1 = (Line)obj2;
		return this.calculateLength()>l1.calculateLength();
	}

	public boolean isLesser(Object obj2) {
		Line l1 = (Line)obj2;
		return this.calculateLength()<l1.calculateLength();
	}

	public boolean isEquals(Object obj2) {
		Line l1 = (Line)obj2;
		return this.calculateLength()==l1.calculateLength();
	}
	
	

}
