package dataWrappers;

import java.util.*;

public class ReferenceName {
	private List<String> firstName;
	private List<String> middleName;
	private List<String> lastName;
	public ReferenceName(List<String> fn, List<String> mn, List<String> ln) {
		this.firstName=fn;
		this.middleName=mn;
		this.lastName=ln;
	}
	public List<String> getFirstName() {
		return this.firstName;
	}
	public List<String> getMiddleName() {
		return this.middleName;
	}
	public List<String> getLastName() {
		return this.lastName;
	}
}
