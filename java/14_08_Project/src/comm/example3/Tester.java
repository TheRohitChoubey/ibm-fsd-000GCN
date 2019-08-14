package comm.example3;

import static java.lang.System.*;

import java.util.*;

public class Tester {

	private static Scanner scanner = new Scanner(in);

	public static void main(String[] args) {
		String name = null;
		try {
			out.println("Coach Name : ");
			name = scanner.next();
			TennisCoach myCoach = new TennisCoach();
			myCoach.createCoach(name, Level.MEDIUM);
			out.println(myCoach.getCoachDetails().toString());
		} catch (InputMismatchException e) {
			e.printStackTrace();
			err.println(e.toString());
		}

	}

}
