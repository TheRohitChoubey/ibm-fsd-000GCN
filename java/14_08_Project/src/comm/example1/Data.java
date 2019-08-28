package comm.example1;

import java.io.Serializable;

public class Data implements Serializable {
	private String fname;
	private String lname;

	public Data() {
		super();
	}

	public Data(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		return result;
	}

	public Data isEquals(Object obj) throws FirstLastNameNotValid {
		Data d = (Data) obj;
		if (this.fname.equals(d.fname) && this.lname.equals(d.lname)) {
			throw new FirstLastNameNotValid("Same name exist");
		}
		return d;
	}

	public Data enterData(String fn, String ln) throws FirstLastNameNotValid {

		if (Character.isUpperCase(fn.charAt(0)) == false || Character.isUpperCase(ln.charAt(0)) == false) {
			throw new FirstLastNameNotValid("Wrong Format of First Name Last Name");
		} else {
			System.out.println("Correct Format");
			this.fname = fn;
			this.lname = ln;
			return new Data(fn, ln);
		}
	}

}
