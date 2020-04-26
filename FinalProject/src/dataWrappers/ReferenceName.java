package dataWrappers;

import java.util.ArrayList;

public class ReferenceName {
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	public ReferenceName(ArrayList<String> fn, ArrayList<String> mn, ArrayList<String> ln) {
		this.firstName=fn;
		this.middleName=mn;
		this.lastName=ln;
	}
	public ArrayList<String> getFirstName() {
		return this.firstName;
	}
	public ArrayList<String> getMiddleName() {
		return this.middleName;
	}
	public ArrayList<String> getLastName() {
		return this.lastName;
	}
}
