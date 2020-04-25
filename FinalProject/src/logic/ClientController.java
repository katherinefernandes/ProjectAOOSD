package logic;


import java.time.DateTimeException;
import java.util.ArrayList;

import applications.ClientApplication;
import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import exceptions.ElementNotFoundException;
import graphicalInterface.newClientMenu;

import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.ExtractingPortID;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import xmlParser.PortXMLManipulation;

public class ClientController {
	private long clientID;
	private ClientApplication currentClient;
	private ValidInput validate;
	private newClientMenu clientmenu;
	private ArrayList<String> firstNameList;
	private ArrayList<String> middleNameList;
	private ArrayList<String> lastNameList;
	private ClientData client;
	private ArrayList<ContainerData> container;
	private long portID;
	private PortXMLManipulation databasePort;
	private long startPortID;
	private long destinationPortID;
	private ExtractingPortID extractingPortID;

	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		validate = new ValidInput();
		extractingPortID = new ExtractingPortID();
		currentClient = new ClientApplication(this.clientID);
		databasePort = new PortXMLManipulation();
		clientmenu = new newClientMenu(this);
		clientmenu.frame.setVisible(true);
	}
	public void saveReferencePerson(String firstName, String middleName, String lastName) {
		System.out.println("inside the method savereferencePerson");
		boolean checkMessage = false;
		if(checkNameValidity(firstName) && validate.validateName(middleName) && checkNameValidity(lastName)){
			firstNameList = parseInput.parsingNames(firstName);
			middleNameList = parseInput.parsingNames(middleName);
			lastNameList = parseInput.parsingNames(lastName);
			UpdateReferencePerson update = new UpdateReferencePerson(firstNameList,middleNameList,lastNameList);
			System.out.println("Going to try to update information");
			if (currentClient.updateClientInformation(update)) {
				System.out.println("Update success, trying to display message");
				currentClient = new ClientApplication(this.clientID);
				checkMessage = true;
			} else {
				System.out.println("Some thing went wrong, try again");
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
	
	
	public void savePhoneNumber(String countryCode,String phone) {
		boolean checkMessage =false;
		if(checkPhoneValidity(phone)&&checkCountryCodeValidity(countryCode)) {
			System.out.println("The phone number and country code were valid, now going to update information");
			UpdatePhoneNumber update = new UpdatePhoneNumber(Integer.valueOf(countryCode),Long.valueOf(phone));
			System.out.println("Updating information");
			if (currentClient.updateClientInformation(update)) {
				System.out.println("Everything went alright");
				currentClient = new ClientApplication(this.clientID);
				checkMessage = true;
			}else {
				System.out.println("Something went wrong with the database update");
				checkMessage = false;
			}
			
		}
		else {
			 System.out.println("The phone number or the countrycode type is not valid");
			 checkMessage =  false;
		}
		if (checkMessage) {
			clientmenu.successFieldForPhone();
		}else {
			clientmenu.errorMessageForPhone();
		}
		
	}
	
	private boolean checkEmailValidity(String email) {
		return validate.validateEmail(email);
	}
	
	public void saveEmail(String email) {
		boolean checkMessage =false;
		if(checkEmailValidity(email)) {
			System.out.println("The email type is valid, now going to try setting it");
			UpdateEmail update = new UpdateEmail(email);
			if (currentClient.updateClientInformation(update)) {
				System.out.println("The email has been successfully updated");
				currentClient = new ClientApplication(this.clientID);
				checkMessage = true;
			} else {
				System.out.println("Something went wrong with the database");
				checkMessage = false;
			}
			
		}
		else {
			System.out.println("The email type is not valid");
			checkMessage = false;
		}
		if (checkMessage) {
			clientmenu.successFieldForEmail();
		}else {
			clientmenu.errorMessageForEmail();
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
		    container= currentClient.filterContainersOnAJourney(filter);
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
		container = currentClient.filterContainersOnAJourney(filter);
		if(container.size()<=0) {
			System.out.println("There is no container containing this cargo"+cargo+ "for this client");
			return false;
		}
		System.out.println("Found some containers containing this cargo");
		return true;
	}
	public boolean getContainerByPortName(String portname) {
		// TODO Auto-generated method stub
		portID = extractingPortID.getPortID(portname);
		if (portID==1l) {
			System.out.println("The portname is not present in the database");
			return false;
		}else {
			FilterByPortName filter = new FilterByPortName(currentClient.viewClient(),portID);
			container = currentClient.filterContainersOnAJourney(filter);
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
		int contains = 0;
		for(int i=0;i<container.size();i++) {
			result =result+containerDataToString(container.get(i));
			contains++;
			if(contains>2) {
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
	private boolean checkStartPortName(String portname) {

		startPortID = extractingPortID.getPortID(portname);
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
	private boolean checkDestinationPortName(String portname) {

		destinationPortID = extractingPortID.getPortID(portname);
		if(destinationPortID==1l) {
			System.out.println("Destination port does not exit");
			return false;
		}
		System.out.println("Destination port exists");
		currentClient.updateDestinationPort(destinationPortID);
		
		
		return true;
	}
	private boolean checkFloat(String floatnumber) {

		try {
			Float.valueOf(floatnumber);
			System.out.println("number value is correct");
			return true;
		}catch(NumberFormatException e) {
			System.out.println("The internal status values are not valid");
			return false;
		}
	}
	private boolean setArriveByString(String date) {

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
	private boolean registerJourney(String cargo, String atm, String temp, String humidity, String arriveby) {

		float temperature = Float.valueOf(temp);
		float humidity2 = Float.valueOf(humidity);
		float atmosphere = Float.valueOf(atm);
		System.out.println("Going to try registering");
		currentClient.registerContainerForAJourney(startPortID, destinationPortID, cargo, temperature, atmosphere, humidity2, arriveby);
		boolean result = currentClient.getContainerRegistered();
		currentClient = new ClientApplication(this.clientID);
		return result;
	}
	public void saveJourney(String startPortName, String destinationPortName, String cargo, String atm, String temp, String humidity,
			String arriveby) {
		boolean checkMessage = checkStartPortName( startPortName);
		if (checkMessage) {
			checkMessage = checkDestinationPortName(destinationPortName);
		}else  {
			System.out.println("There is no startPortName");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(!checkMessage) {
			System.out.println("Destination port not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		
		checkMessage = validate.validateName(cargo);
		System.out.println(cargo+cargo.length());
		if(checkMessage) {
			checkMessage =checkFloat(atm);
			checkMessage = checkFloat(temp);
			checkMessage = checkFloat(humidity);
		}else {
			System.out.println("Cargo is not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(checkMessage) {
			checkMessage =setArriveByString(arriveby);
		}else {
			System.out.println("One of the internal status things is invalid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(checkMessage) {
			System.out.println("Everything is valid, now trying to register");
			checkMessage = registerJourney(cargo,  atm, temp,  humidity, arriveby);
		}else {
			System.out.println("Arriveby is not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(checkMessage) {
			clientmenu.successFieldForAddJourney();
			clientmenu.updateActiveShipments();
		}else {
			System.out.println("something went wrong when registering the journey");
			clientmenu.errorMessageForAddJourney();
		}
		
	}
	public void searchContainer(String journeyID, String cargo, String portName) {
		boolean checkCriteria = false;
		boolean checkMessage = false;
		if(!journeyID.isEmpty()) {
			checkMessage = getContainerByJourneyID(journeyID);
			checkCriteria =true;
		}
		if(!checkMessage&&!cargo.isEmpty()) {
			checkMessage = getContainerByCargo(cargo);
		}
		if(!checkMessage&&!portName.isEmpty()) {
			checkMessage = getContainerByPortName(portName);
		}
		if(checkMessage) {
			clientmenu.setFieldsContainerData();
			if(checkCriteria) {
				clientmenu.viewOneContainerPanel();
			}else {
				clientmenu.viewMultipleContainerPanel();
			}
		}else {
			System.out.println("no container found by the above criterias");
			clientmenu.containerSearchError();
		}
		
	}
	public String setSuccessfulJourneys() {
		
		return "";
	}
	
}
