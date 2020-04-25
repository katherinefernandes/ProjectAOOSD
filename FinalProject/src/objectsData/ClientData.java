package objectsData;

import java.util.*;

import dataBase.DataBase;
import xmlParser.XMLField;

public class ClientData extends IdentifiableData{
	private String companyName;
	private PhoneNumber phoneNumber;
	private String email;
	private ReferenceName person;
	private Address address;
	private List<Long> activeShipments;
	private List<Long> finishedShipments;

	//TODO make names follow naming-conventions
	public ClientData(long cid, String companyname, int country, long phone, String email, ArrayList<String> fn, ArrayList<String> mn, ArrayList<String> ln, String street, String city, int house, String zip) {
		this.tagName = "Client";
		this.ID=cid;
		this.companyName=companyname;
		this.phoneNumber= new PhoneNumber(country,phone);
		this.email= email;
		this.person= new ReferenceName(fn,mn,ln);
		this.address= new Address(street,house,city,zip);
		this.activeShipments= new ArrayList<Long>();
		this.finishedShipments = new ArrayList<>();
		XMLField companyName = new XMLField("CompanyName",companyname);
		XMLField countryCode = new XMLField("CountryCode",String.valueOf(country));
		XMLField baseNumber = new XMLField("PhoneBaseNumber",String.valueOf(phone));
		List<XMLField> phoneList = new ArrayList<>();
		phoneList.add(countryCode);
		phoneList.add(baseNumber);
		XMLField phoneNumber = new XMLField("PhoneNumber",phoneList);
		XMLField emailXML = new XMLField("Email",email);
		List<XMLField> nameList = new ArrayList<>();
		for(String name : fn) {
			nameList.add(new XMLField("FirstName",name));
		}
		for(String name : mn) {
			nameList.add(new XMLField("MiddleName",name));
		}
		for(String name : ln) {
			nameList.add(new XMLField("LastName",name));
		}
		XMLField nameXML = new XMLField("RefrencePersonName",nameList);
		List<XMLField> addressList = new ArrayList<>();
		addressList.add(new XMLField("StreetName",street));
		addressList.add(new XMLField("HouseNumber",String.valueOf(house)));
		addressList.add(new XMLField("City",city));
		addressList.add(new XMLField("ZipCode",String.valueOf(zip)));
		XMLField addressXML = new XMLField("Address",addressList);
		XMLField activeShipments = new XMLField("ActiveShipments","JourneyID",new ArrayList<String>());
		XMLField finishedShipments = new XMLField("FinishedShipments","JourneyID",new ArrayList<String>());
		XMLField[] array = {companyName,phoneNumber,emailXML,nameXML,addressXML,activeShipments,finishedShipments};
		xmlFields = Arrays.asList(array);
	}
	public void setPhoneNumber(int country,long phone) {
		this.phoneNumber= new PhoneNumber(country,phone);
		
		int index = indexOfTagname(xmlFields,"PhoneNumber");
		try {
			List<XMLField> phoneField = xmlFields.get(index).getCompound();
			phoneField.get(0).setValue(String.valueOf(country));
			phoneField.get(1).setValue(String.valueOf(phone));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void setEmail(String email) {
		this.email=email;
		int index = indexOfTagname(xmlFields,"Email");
		try {
			xmlFields.get(index).setValue(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setPerson(ArrayList<String> fn, ArrayList<String> mn, ArrayList<String> ln) {
		this.person= new ReferenceName(fn,mn,ln);
		int index = indexOfTagname(xmlFields,"RefrencePersonName");
		List<XMLField> nameList = new ArrayList<>();
		for(String name : fn) {
			nameList.add(new XMLField("FirstName",name));
		}
		for(String name : mn) {
			nameList.add(new XMLField("MiddleName",name));
		}
		for(String name : ln) {
			nameList.add(new XMLField("LastName",name));
		}
		try {
			xmlFields.get(index).setCompound(nameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addActiveShipment(long JourneyID) {
		this.activeShipments.add(JourneyID);
		int index = indexOfTagname(xmlFields,"ActiveShipments");
		try {
			xmlFields.get(index).addValue(String.valueOf(JourneyID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addFinishedShipment(long JourneyID) {
		this.finishedShipments.add(JourneyID);
		int index = indexOfTagname(xmlFields,"FinishedShipments");
		try {
			xmlFields.get(index).addValue(String.valueOf(JourneyID));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public List<Long> getActiveShipments(){
		return this.activeShipments;
	}
	public List<Long> getFinishedShipments(){
		return this.finishedShipments;
	}
	public void save() {
		DataBase.save(this);
	}
}
