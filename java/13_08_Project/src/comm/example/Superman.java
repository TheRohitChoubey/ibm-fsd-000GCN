package comm.example;

public class Superman extends Flyer {

	@Override
	public void takeOff() {
		System.out.println("Superman can take off");
	}

	@Override
	public void land() {
		System.out.println("Superman can land");
	}

	@Override
	public void fly() {
		System.out.println("Superman can fly");
	}

}
