package comm.example;

public class Tester {

	public static void main(String[] args) {
		/*
		Flyer f = new Bird();
		f.fly();
		f.land();
		f.takeOff();
		
		f = new Superman();
		f.fly();
		f.land();
		f.takeOff();
		*/
		
		Model model =new Line(0,10);
		System.out.println(model.isGreater(new Line(0,20)));
		System.out.println(model.isLesser(new Line(0,20)));
		System.out.println(model.isEquals(new Line(0,20)));
	}

}
