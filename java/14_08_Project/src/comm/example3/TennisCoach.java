package comm.example3;

public class TennisCoach implements Coach {
	private String name;
	private Level level;

	public TennisCoach() {
		super();
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice back volley today";
	}

	public void createCoach(String name, Level level) {
		this.setName(name);
		this.setLevel(level);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getCoachDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Todays workout plan : " + getDailyWorkOut() + " \n");
		sb.append("Name of the coach : " + getName() + " \n");
		sb.append("Level of the coach : " + getLevel() + " \n");
		sb.append("Coach's level rank is : " + level.getLevelCode() + " \n");
		return sb.toString();

	}
}
