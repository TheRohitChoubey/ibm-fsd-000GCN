package comm.example2;

public class ObjectEqualityException extends Exception {
	private static final long serialVersionID = -4623299805044150018L;
	
	private String message;	
	
	public ObjectEqualityException() {
		super();
	}

	public ObjectEqualityException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionid() {
		return serialVersionID;
	}
}
