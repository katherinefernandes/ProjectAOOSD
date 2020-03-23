package objectsData;

import java.util.ArrayList;

public class ReferenceName {
	private String firstName;
	private ArrayList<String> middleName;
	private String lastName;
	public ReferenceName(String fn, ArrayList<String> mn, String ln) {
		this.firstName=fn;
		this.middleName=mn;
		this.lastName=ln;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public ArrayList<String> getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
}
