package logic;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import exceptions.ElementNotFoundException;
import graphicalInterface.newClientStuff;
//import graphicalInterface.newClientStuff;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import users.CurrentClientV2;
import xmlParser.PortXMLManipulation;

public class ClientController {
	private long clientID;
	private CurrentClientV2 currentClient;
	private ValidInput validate;
	private newClientStuff clientmenu;
	private ArrayList<String> firstNameList;
	private ArrayList<String> middleNameList;
	private ArrayList<String> lastNameList;
	private ClientData client;
	private ArrayList<ContainerData> container;
	private long portID;
	private PortXMLManipulation databasePort;
	private long startPortID;
	private long destinationPortID;
	
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		validate = new ValidInput();
		currentClient = new CurrentClientV2(this.clientID);
		databasePort = new PortXMLManipulation();
		clientmenu = new newClientStuff(this);
		clientmenu.frame.setVisible(true);
	}
	public void saveReferencePerson(String firstName, String middleName, String lastName) {
		System.out.println("inside the method savereferencePerson");
		boolean checkMessage = false;
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
				checkMessage = true;
			} else {
				System.out.println("Some thing went wrong in saving to the databaseClient");
				checkMessage = false;
			}
		}
		else {
			System.out.println("The names are not valid");
			checkMessage = false;	
		}
		if (checkMessage) {
			clientmenu.successFieldForName();
		}else {
			clientmenu.errorMessageForName();
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
		int counter=0;
		for (int i=0;i<shipments.size();i++) {
			IDs = IDs+"\nJourney: "+shipments.get(i);
			System.out.println(IDs);
			counter=counter+1;
			if(counter>2) {
				break;
			}
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
		String activeShipments ="The recently registered journeys: ";
		
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			activeShipments = activeShipments+arrayListJourneyToString(client.getActiveShipment());
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
		}catch(ElementNotFoundException e) {
			System.out.println("The counterID is not correct");
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

	public String getStartPortName() {
		// TODO Auto-generated method stub
		return getPortName(container.get(0).getStartPortID());
	}
	private String getPortName(long portID) {
		PortData port;
		try {
			port = databasePort.getEntry(portID);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cant find the port");
			throw new Error(e);
		}
		return port.getPortName();
	}
	public String getDestinationPortName() {
		// TODO Auto-generated method stub
		return getPortName(container.get(0).getDestinationPortID());
	}
	public String getCargo() {
		// TODO Auto-generated method stub
		return container.get(0).getCargo();
	}
	public String getArrivalDate() {
		// TODO Auto-generated method stub
		return container.get(0).getArriveBy();
	}
	public String getLastUpdate() {
		// TODO Auto-generated method stub
		return container.get(0).getUpdated();
	}
	public String getInternalStatus() {
		// TODO Auto-generated method stub
		String temp= Float.toString(container.get(0).getInternalStatus().getTemperature());
		String humidity = Float.toString(container.get(0).getInternalStatus().getHumidity());
		String pressure = Float.toString(container.get(0).getInternalStatus().getAtmosphere());
		
		return "Temperature: "+temp+"\nHumidity: "+humidity+"\nPressure: "+pressure;
	}
	public String getCurrentLocation() {
		// TODO Auto-generated method stub
		String latitude = Float.toString(container.get(0).getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.get(0).getCurrentPosition().getlongitude());
		return "Latitude: "+latitude+"  Longitude: "+longitude;
	}
	public String getMulitpleContainersData() {
		// TODO Auto-generated method stub
		String result ="Displaying Up to most 2 Containers: ";
		int counter =0;
		for(int i=0;i<container.size();i++) {
			result =result+containerDataToString(container.get(i));
			counter++;
			if(counter>1) {
				break;
			}
		}
		
		
		
		return result;
	}
	private String containerDataToString(ContainerData container) {
		String result="\n";
		result = result +"\nJourney ID: "+container.getJourneyID();
		result = result +"\nStart Port: "+getPortName(container.getStartPortID());
		result = result +"\nDestination Port: "+getPortName(container.getDestinationPortID());
		result = result +"\nCargo: "+container.getCargo();
		result = result +"\nInternal Status: "+getInternalStatus(container);
		String latitude = Float.toString(container.getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.getCurrentPosition().getlongitude());
		result = result +"\nCurrent Location:"+"Latitude: "+latitude+"Longitude: "+longitude;
		result = result +"\nArrival Date: "+container.getArriveBy();
		result = result +"\nLast Updated: "+container.getUpdated();
		return result;
	}
	private String getInternalStatus(ContainerData container) {
		// TODO Auto-generated method stub
		String temp= Float.toString(container.getInternalStatus().getTemperature());
		String humidity = Float.toString(container.getInternalStatus().getHumidity());
		String pressure = Float.toString(container.getInternalStatus().getAtmosphere());
		
		return "Temperature: "+temp+"\nHumidity: "+humidity+"\nPressure: "+pressure;
	}
	public boolean checkStartPortName(String portname) {
		// TODO Auto-generated method stub
		startPortID = currentClient.getPortID(portname);
		System.out.println("Checking if the port name exists");
	   if (startPortID==1l) {
		   System.out.println("Port name doesnot exist");
		   return false;
	   };
	   System.out.println("Port name is valid");
	    currentClient.getAContainer(startPortID);
	    System.out.println("Checking if the container is set");
	    if (currentClient.getFoundContainer()) {
	    	System.out.println("Container found");
	    	return true;
	    }
	    System.out.println("Container not found nor set, something wrong with currentclient method");
		return false;
	}
	public boolean checkDestinationPortName(String portname) {
		// TODO Auto-generated method stub
		destinationPortID = currentClient.getPortID(portname);
		if(destinationPortID==1l) {
			System.out.println("Destination port does not exit");
			return false;
		}
		System.out.println("Destination port exists");
		currentClient.updateDestinationPort(destinationPortID);
		
		
		return true;
	}
	public boolean checkFloat(String floatnumber) {
		// TODO Auto-generated method stub
		try {
			Float.valueOf(floatnumber);
			System.out.println("number value is correct");
			return true;
		}catch(NumberFormatException e) {
			System.out.println("The internal status values are not valid");
			return false;
		}
	}
	public boolean setArriveByString(String date) {
		// TODO Auto-generated method stub
		// we need to fix the parse date ... 
		//we need to set the arriveby in here as welll and then replace from line 426
		System.out.println("Checking arrive by");
		try {
			parseInput.getDate(date);
			return true;
		}catch(DateTimeException e ){
				System.out.println("Not accurate date format");
		}catch ( java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("Not accurate date format");
		}
		return false;
	}
	public boolean registerJourney(String cargo, String atm, String temp, String humidity, String arriveby) {
		// TODO Auto-generated method stub
		float temperature = Float.valueOf(temp);
		float humidity2 = Float.valueOf(humidity);
		float atmosphere = Float.valueOf(atm);
		System.out.println("Going to try registering");
		currentClient.registerContainer(startPortID, destinationPortID, cargo, temperature, atmosphere, humidity2, arriveby);
		boolean result = currentClient.getContainerRegistered();
		currentClient = new CurrentClientV2(this.clientID);
		return result;
	}
	
}
