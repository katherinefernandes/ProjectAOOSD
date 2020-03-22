package objectsData;

public class ReferenceName {
	private String firstName;
	private String middleName;
	private String lastName;
	public ReferenceName(String fn, String mn, String ln) {
		this.firstName=fn;
		this.middleName=mn;
		this.lastName=ln;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
}
