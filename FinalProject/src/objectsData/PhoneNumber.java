package objectsData;

public class PhoneNumber {
	private int country;
	private int phone;
	
	public PhoneNumber(int country, int phone) {
		this.country=country;
		this.phone=phone;
	}
	public int getCountryCode() {
		return country;
	}
	public int getPhone() {
		return phone;
	}

}
