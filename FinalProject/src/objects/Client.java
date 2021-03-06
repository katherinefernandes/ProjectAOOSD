package objects;

import java.util.*;
import dataBase.DataBase;
import dataWrappers.Address;
import dataWrappers.PhoneNumber;
import dataWrappers.ReferenceName;

/**
 * This class contains all the information required for a client
 * @author Mamuna Azam and Simon 
 *
 */
public class Client extends BusinessObject{
	private long ID;
	private String companyName;
	private PhoneNumber phoneNumber;
	private String email;
	private ReferenceName person;
	private Address address;
	private List<Long> activeShipments;
	private List<Long> finishedShipments;

	public Client(long ID, String companyName, int countryCode, long phoneNumber, String email, List<String> firstName,
			List<String> middleName, List<String> lastName, String street, String city, int house, String zip) {
		this.ID = ID;
		this.companyName = companyName;
		this.phoneNumber = new PhoneNumber(countryCode,phoneNumber);
		this.email = email;
		this.person = new ReferenceName(firstName,middleName,lastName);
		this.address = new Address(street,house,city,zip);
		this.activeShipments = new ArrayList<>();
		this.finishedShipments = new ArrayList<>();
	}
	public void setPhoneNumber(int country,long phone) {
		this.phoneNumber= new PhoneNumber(country,phone);
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPerson(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		this.person= new ReferenceName(firstName,middleName,lastName);
	}
	public String getCompanyName() {
		return this.companyName;
	}
	public PhoneNumber getPhoneNumber() {
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
	public void addActiveShipment(long JourneyID) {
		this.activeShipments.add(JourneyID);
	}
	private void addFinishedShipment(long JourneyID) {
		this.finishedShipments.add(JourneyID);
	}
	public void setFinishedShipment(long JourneyID) {
		this.finishedShipments.add(JourneyID);
	}
	public List<Long> getActiveShipments(){
		return this.activeShipments;
	}
	public List<Long> getFinishedShipments(){
		return this.finishedShipments;
	}
	private void removeActiveShipment(long journeyID){
		activeShipments.remove(journeyID);
	}
	public void save() {
		DataBase.save(this);
	}
	public long getID() {
		return ID;
	}
	public List<String> getAllValues(){
		List<String> values = new ArrayList<>();
		values.add(String.valueOf(getID()));
		values.add(String.valueOf(getCompanyName()));
		values.add(String.valueOf(getPhoneNumber().getCountryCode()));
		values.add(String.valueOf(getPhoneNumber().getPhone()));
		values.add(String.valueOf(getEmail()));
		values.addAll(getPerson().getFirstName());
		values.addAll(getPerson().getMiddleName());
		values.addAll(getPerson().getLastName());
		values.add(String.valueOf(getAddress().getStreetName()));
		values.add(String.valueOf(getAddress().getHouseNumber()));
		values.add(String.valueOf(getAddress().getCity()));
		values.add(String.valueOf(getAddress().getZipCode()));
		for(long journeyID : getActiveShipments()) {
			values.add(String.valueOf(journeyID));
		}
		for(long journeyID : getFinishedShipments()) {
			values.add(String.valueOf(journeyID));
		}
		return values;
	}

	/**
	 * This method is used to update the journey information when a journey ends
	 * @param journeyID
	 */
	public void updateJourneyInformation(long journeyID) {
		removeActiveShipment(journeyID);
		addFinishedShipment(journeyID);
		save();
	}
	
	
}
