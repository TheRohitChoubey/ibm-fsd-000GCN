package comm.example;

public class Bird extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("Bird can take off");
	}

	@Override
	public void land() {
		System.out.println("Bird can land");
	}

	@Override
	public void fly() {
		System.out.println("Bird can fly");
	}
	
}
