package comm.example2;

public class Model {
	private int side;

	
	public int getSide() {
		return side;
	}


	public void setSide(int side) {
		this.side = side;
	}
	
	public int area(int j) {
		return j*j;
	}

	public class Square{
		
		public int volume(int j) {
			return j*j*j;
		}
	}
	
	public static void main(String[] args) {
		Model m =new Model();
		System.out.println(m.area(5));
		
		Model.Square s = m.new Square();
		System.out.println(s.volume(5));
	}
}
