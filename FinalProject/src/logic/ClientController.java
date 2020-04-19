package logic;

import java.util.ArrayList;

import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
//import graphicalInterface.newClientStuff;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import users.CurrentClientV2;

public class ClientController {
	private long clientID;
	private CurrentClientV2 currentClient;
	private ValidInput validate;
	//private newClientStuff clientmenu;
	private ArrayList<String> firstNameList;
	private ArrayList<String> middleNameList;
	private ArrayList<String> lastNameList;
	private ClientData client;
	private ArrayList<ContainerData> container;
	private long portID;
	
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		validate = new ValidInput();
		currentClient = new CurrentClientV2(this.clientID);
	}
	public boolean saveReferencePerson(String firstName, String middleName, String lastName) {
		System.out.println("inside the method savereferencePerson");
		if(checkNameValidity(firstName) && checkNameValidity(middleName) && checkNameValidity(lastName)){
			firstNameList = parseInput.parsingNames(firstName);
			middleNameList = parseInput.parsingNames(middleName);
			lastNameList = parseInput.parsingNames(lastName);
			UpdateReferencePerson update = new UpdateReferencePerson(firstNameList,middleNameList,lastNameList);
			System.out.println("Going to try to update information");
			//clientmenu.displaySuccess();
			if (currentClient.updateClientInformation(update)) {
				System.out.println("Update success, trying to display message");
				currentClient = new CurrentClientV2(this.clientID);
				return true;
			} else {
				System.out.println("Some thing went wrong in saving to the databaseClient");
				return false;
			}
		}
		
		else {
			System.out.println("The names are not valid");
			return false;	
		}
		
		
		
	}
	
	
	
	private boolean checkNameValidity(String name) {
		System.out.println(name);
		ArrayList<String> Name = parseInput.parsingNames(name); 
		for(int i=0;i<Name.size();i++) {
			if(!validate.validateName(Name.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkPhoneValidity(String phone) {
		try {
			return validate.validatePhone(Long.valueOf(phone));
		}catch(NumberFormatException e) {
			return false;
		}
	}
	private boolean checkCountryCodeValidity(String CountryCode) {
		return validate.validateCountryCode(Integer.valueOf(CountryCode));
	}
	
	
	public boolean savePhoneNumber(String countryCode,String phone) {
		if(checkPhoneValidity(phone)&&checkCountryCodeValidity(countryCode)) {
			System.out.println("The phone number and country code were valid, now going to update information");
			UpdatePhoneNumber update = new UpdatePhoneNumber(Integer.valueOf(countryCode),Long.valueOf(phone));
			System.out.println("Updating information");
			if (currentClient.updateClientInformation(update)) {
				System.out.println("Everything went alright");
				currentClient = new CurrentClientV2(this.clientID);
				return true;
			}else {
				System.out.println("Something went wrong with the database update");
				return false;
			}
			
		}
		else {
			 System.out.println("The phone number or the countrycode type is not valid");
			 return false;
		}
		
	}
	
	private boolean checkEmailValidity(String email) {
		return validate.validateEmail(email);
	}
	
	public boolean saveEmail(String email) {
		if(checkEmailValidity(email)) {
			System.out.println("The email type is valid, now going to try setting it");
			UpdateEmail update = new UpdateEmail(email);
			if (currentClient.updateClientInformation(update)) {
				System.out.println("The email has been successfully updated");
				currentClient = new CurrentClientV2(this.clientID);
				return true;
			} else {
				System.out.println("Something went wrong with the database");
				return false;
			}
			
		}
		else {
			System.out.println("The email type is not valid");
			return false;
		}
		
	}
	public String getCurrentPhoneNumber() {
		// TODO Auto-generated method stub
		String phone = "";
		if(currentClient.getSetClient()) {
			client = currentClient.viewClient();
			phone = Integer.toString(client.getPhoneNumber().getCountryCode())+Long.toString(client.getPhoneNumber().getPhone());
		}
		return phone;
	}
	public String getCurrentEmail() {
		// TODO Auto-generated method stub
		String email ="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			email = client.getEmail();
		}
		return email;
	}
	public String getCompanyName() {
		// TODO Auto-generated method stub
		String company="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			company = client.getCompanyName();		
		}
		return company;
	}
	public String getReferencePerson() {
		// TODO Auto-generated method stub
		String personname="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			personname = arrayListToString(client.getPerson().getFirstName())+" "+arrayListToString(client.getPerson().getMiddleName())+" "+arrayListToString(client.getPerson().getLastName());
			
		}
		return personname;
	}
	private String arrayListToString(ArrayList<String> name) {
		String Name="";
		for(int i=0;i<name.size();i++) {
			Name =Name+" "+name.get(i);
		}
		return Name;
	}
	
	private String arrayListJourneyToString(ArrayList<Long> shipments) {
		String IDs="";
		for (int i=0;i<shipments.size();i++) {
			IDs = "\nJourney: "+shipments.get(i);
		}
		return IDs;
	}
	
	public String getAddress() {
		// TODO Auto-generated method stub
		String address ="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			address = "City: "+client.getAddress().getCity();
			address = address +"\nStreet: "+client.getAddress().getStreetName();
			address = address+"\nBuilding: "+Integer.toString(client.getAddress().getHouseNumber());
			address = address +"\nZipCode: "+client.getAddress().getZipCode();
		}
		return address;
	}
	public String getActiveShipments() {
		// TODO Auto-generated method stub
		String activeShipments ="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			activeShipments = arrayListJourneyToString(client.getActiveShipment());
		}
		return activeShipments;
	}
	public boolean getContainerByContainerID(String containerID) {
		// TODO Auto-generated method stub
		container = new ArrayList<ContainerData>();
		try {
			currentClient.getContainer(Long.valueOf(containerID));
			if (currentClient.getFoundContainer()) {
				container.add(currentClient.viewContainer());
				System.out.println("The container has been found, now the data can be displayed safely");
				return true;
			}else {
				System.out.println("The container does not exist");
				return false;
			}
		}catch(NumberFormatException e) {
			System.out.println("The value in the containerID field is not valid format");
			return false;
		}
	}
	public boolean getContainerByJourneyID(String journeyID) {
		// TODO Auto-generated method stub
		if (checkIfJourneyIDisPartOfActiveShipment(journeyID)) {
			System.out.println("The journeyID is valid and part of the activeshipments, now will try to find the container");
			FilterByJourneyID filter = new FilterByJourneyID(currentClient.viewClient(),Long.valueOf(journeyID));
		    container= currentClient.getFilteredContainersOnAJourney(filter);
			System.out.println("Container found, now the data can be read");
			return true;
		}
		return false;
	}
	private boolean checkIfJourneyIDisPartOfActiveShipment(String journeyID) {
		String activeShipments = this.getActiveShipments();
		if (activeShipments.contains(journeyID)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean getContainerByCargo(String cargo) {
		// TODO Auto-generated method stub
		FilterByCargoName filter = new FilterByCargoName(currentClient.viewClient(),cargo);
		container = currentClient.getFilteredContainersOnAJourney(filter);
		if(container.size()<=0) {
			System.out.println("There is no container containing this cargo"+cargo+ "for this client");
			return false;
		}
		System.out.println("Found some containers containing this cargo");
		return true;
	}
	public boolean getContainerByPortName(String portname) {
		// TODO Auto-generated method stub
		portID = currentClient.getPortID(portname);
		if (portID==1l) {
			System.out.println("The portname is not present in the database");
			return false;
		}else {
			FilterByPortName filter = new FilterByPortName(currentClient.viewClient(),portID);
			container = currentClient.getFilteredContainersOnAJourney(filter);
			if (container.size()>0) {
				System.out.println("some containers found at the port name given");
				return true;
			}else {
				System.out.println("No containers found at the port name given");
				return false;
			}
		}
	}
}
