package objectsData;

import java.util.ArrayList;

public class ClientData extends ObjectData{
	private long clientID;
	private String companyName;
	private int phoneNumber;
	private String email;
	private ReferenceName person;
	private Address address;
	private ArrayList<Long> activeShipment;
	
	public ClientData(long cid, String companyname, int phone, String email, String fn, String mn, String ln, String street, String city, int house, int zip) {
		this.clientID=cid;
		this.companyName=companyname;
		this.phoneNumber=phone;
		this.email= email;
		this.person= new ReferenceName(fn,mn,ln);
		this.address= new Address(street,house,city,zip);
		this.activeShipment= new ArrayList<Long>();
	}
	public void setPhoneNumber(int phone) {
		this.phoneNumber=phone;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPerson(String fn, String mn, String ln) {
		this.person= new ReferenceName(fn,mn,ln);
	}
	public void addActiveShipment(Long JourneyID) {
		this.activeShipment.add(JourneyID);
	}
	public long getClientID() {
		return this.clientID;
	}
	public String getCompanyName() {
		return this.companyName;
	}
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getEmail() {
		return this.email;
	}
	public ReferenceName getPerson() {
		return this.person;
	}
	public Address getAddress() {
		return this.address;
	}
	public ArrayList<Long> getActiveShipment(){
		return this.activeShipment;
	}
}
