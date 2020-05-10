package dataWrappers;
/**
 * Used to contain the information about the phonenumber
 * @author Mamuna
 *
 */
public class PhoneNumber {
	private int country;
	private long phone;
	
	public PhoneNumber(int country, long phone) {
		this.country=country;
		this.phone=phone;
	}
	public int getCountryCode() {
		return country;
	}
	public long getPhone() {
		return phone;
	}

}
