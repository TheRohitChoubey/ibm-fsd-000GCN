package comm.singleton;

public class Messaging{
	private String message;
	private static Messaging messaging;
	
	private Messaging() {
		
	}
	
	private Messaging(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messaging [message=" + message + "]";
	}
	
	public static Messaging createMessagingObject() {
		if(messaging == null) {
			messaging = new Messaging();
		}
		return messaging;
	}
	
	public static Messaging createMessagingObject(String msg) {
			messaging = new Messaging(msg);
		return messaging;
	}
	
	
}
