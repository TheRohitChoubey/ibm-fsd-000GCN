package cd_type_webapp.dao;

public class CDDao {
	private String firstname;
	private String lastname;
	private String cd_type;
	
	public CDDao(String firstname, String lastname, String cd_type) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.cd_type = cd_type;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCd_type() {
		return cd_type;
	}
	public void setCd_type(String cd_type) {
		this.cd_type = cd_type;
	}
	
	
}
