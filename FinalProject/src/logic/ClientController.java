package logic;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

import applications.ClientApplication;
import businessObjects.Client;
import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import graphicalInterface.ClientMenu;import supportingClasses.ExtractingPortID;
import supportingClasses.ValidInput;
import supportingClasses.ValidInputType;
import supportingClasses.InputParser;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
/**
 * public class ClientController{}
 * connects the graphical User Interface to the logic behind the client menu 
 * @author daniela
 * 
 */
public class ClientController {
	private long clientID;
	private ClientApplication currentClient;
	private ValidInput validate;
	private ClientMenu clientmenu;
	private ArrayList<String> firstNameList;
	private ArrayList<String> middleNameList;
	private ArrayList<String> lastNameList;
	private Client client;
	private ArrayList<Container> container;
	private long portID;
	private long startPortID;
	private long destinationPortID;
	private boolean checkMessage;
/**
 * public ClientController(){}
 * ClientController is a construct of the ClientController Class which initialises the clientID (the object)
 * @param clientID gives the unique time stamp based ID representative for each client.
 */
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		validate = new ValidInput();
		currentClient = new ClientApplication(this.clientID);
		clientmenu = new ClientMenu(this);
		clientmenu.frame.setVisible(true);
	}
	
	public boolean getcheckMessage() {
		return this.checkMessage;
	}
	
	 
	
	
	/**
	 * public void saveReferencePerson(){}
	 * This method checks if the user input for the reference person is valid and depending on the outcome, either returns a success message and 
	 * saves the Reference Person into the database or returns an error message.
	 * @param firstName String representing the first name of the reference person
	 * @param middleName String representing the middleName of the reference person
	 * @param lastName String representing the lastName of the reference person
	 */
	public void saveReferencePerson(String firstName, String middleName, String lastName) { 
		System.out.println("inside the method savereferencePerson");
		checkMessage = false;
		if(validate.validateArrayOfNames(firstName) && validate.validateArrayOfNames(middleName) && validate.validateArrayOfNames(lastName)){
			firstNameList = InputParser.parsingNames(firstName);
			middleNameList = InputParser.parsingNames(middleName);
			lastNameList = InputParser.parsingNames(lastName);
			UpdateReferencePerson update = new UpdateReferencePerson(firstNameList,middleNameList,lastNameList);
			System.out.println("Going to try to update information");
			checkMessage = updateReferencePersonInformation(update);
		}
		else {
			System.out.println("The names are not valid");
		}
		if (checkMessage) {
			checkMessage = true;
			clientmenu.successFieldForName();
		}else {
			clientmenu.errorMessageForName();
		}
		
		
		 
	}

    /**
     * private boolean updateReferencePersonInformation(){}
     * This method stores a boolean value representing whether the Information was saved successfully or not 
     * @param update the object holding the new reference person information
     * @return variable holding the information whether the data was updated successfully or not
     */
	private boolean updateReferencePersonInformation(UpdateReferencePerson update) {
		checkMessage = false;
		if (currentClient.updateClientInformation(update)) {
			System.out.println("Update success, trying to display message");
			currentClient = new ClientApplication(this.clientID);
			checkMessage = true;
		} else {
			System.out.println("Some thing went wrong, try again");
			checkMessage = false;
		}
		return checkMessage;
	}
	
	
	
	
	/**
	 * public void savePhoneNumber(){}
	 * This method saves the phone number into the data base if the boolean value returned by the validatePhoneUpdateInput is true. 
	 * If checkMessage value is true a success message will be displayed in the gui, else an error message
	 * will be displayed.
	 * 
	 * @param countryCode represents the country code input from the user
	 * @param phone represents the phone number inputed by the user
	 */
	public void savePhoneNumber(String countryCode,String phone) {
		checkMessage =false;
		if(validatePhoneUpdateInputs(countryCode, phone)) {
			System.out.println("The phone number and country code were valid, now going to update information");
			UpdatePhoneNumber update = new UpdatePhoneNumber(Integer.valueOf(countryCode),Long.valueOf(phone));
			System.out.println("Updating information");
			checkMessage = updatePhoneNumberInformation(update);
			
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

	
	private boolean validatePhoneUpdateInputs(String countryCode, String phone) {
		return ValidInputType.validateLong(phone)&&ValidInputType.validateInteger(countryCode)&&validate.validatePhone(Long.valueOf(phone))&&validate.validateCountryCode(Integer.valueOf(countryCode));
	}

    /**
     * private boolean updatePhoneNumberInformation(){}
     * This method checks if the phone number information was successfully updated into the data base
     * @param update the object holding the new phone number information
     * @return boolean value stating whether the phone number was successfully updated or not
     */
	private boolean updatePhoneNumberInformation(UpdatePhoneNumber update) {
		 checkMessage=false;
		if (currentClient.updateClientInformation(update)) {
			currentClient = new ClientApplication(this.clientID); 
			checkMessage = true;
		}else {
			checkMessage = false;
		}
		return checkMessage;
	}
	
	
	
	
	
	/**
	 * private boolean checkEmailValidity(){}
	 * This method checks validity of the inputed email
	 * @param email represents the email address inputed by the user
	 * @return a true or false statement by calling the validateEmail() method from the ValidInput class.
	 */
	private boolean checkEmailValidity(String email) {
		return validate.validateEmail(email);
	}
	
	
	
	/**
	 * public void saveEmail(){}
	 * This method saves the email into the data base and displays a success message if the new inputed email is valid. If it is not valid 
	 * there will be a error message displayed
	 * @param email represents the new email imputed by the user
	 */
	public void saveEmail(String email) {
		checkMessage =false;
		if(checkEmailValidity(email)) {
			System.out.println("The email type is valid, now going to try setting it");
			UpdateEmail update = new UpdateEmail(email);
			checkMessage = updateEmail(update);
			
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

    /**
     * private boolean updateEmail(){}
     * This method checks if the email was successfully updated into the data base
     * @param update the object holding the new updated information
     * @return boolean value stating whether the email was successfully updated or not
     */
	private boolean updateEmail(UpdateEmail update) {
		checkMessage=true;
		if (currentClient.updateClientInformation(update)) {
			System.out.println("The email has been successfully updated");
			currentClient = new ClientApplication(this.clientID);
			checkMessage = true;
		} else {
			System.out.println("Something went wrong with the database");
			checkMessage = false;
		}
		return checkMessage;
	}
	
	
	
	/**
	 * public String getCurrentPhoneNumber(){}
	 * This method is responsible for storing the phone number information inputed by the user
	 * @return the complete phone number which includes the country code as well
	 */
	public String getCurrentPhoneNumber() {
		String phone = "";
		if(currentClient.getSetClient()) {
			client = currentClient.viewClient();
			phone = Integer.toString(client.getPhoneNumber().getCountryCode())+Long.toString(client.getPhoneNumber().getPhone());
		}
		return phone;
	}
	
	
	/**
	 * public String getCurrentEmail(){}
	 * This method stores the current user email
	 * @return the current email the user has
	 */
	public String getCurrentEmail() {
		String email ="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			email = client.getEmail();
		}
		return email;
	}
	
	
	/**
	 * public String getCompanyName(){}
	 * This method stores the Company name information
	 * @return the company Name by calling the getComapanyName() method.
	 */
	public String getCompanyName() {
		String company="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			company = client.getCompanyName();		
		}
		return company;
	}
	
	
	
	/**
	 * public String getReferencePerson(){}
	 * This method combines all the reference person information (first name, middle name, last name) into one string
	 * @return String containing the full name of the reference person
	 */
	public String getReferencePerson() {
		String personname="";
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			personname = arrayListToString(client.getPerson().getFirstName())+" "+arrayListToString(client.getPerson().getMiddleName())+" "+arrayListToString(client.getPerson().getLastName());
			
		}
		return personname;
	}
	
	
	/**
	 * private String arrayListToString(){}
	 * This method converts an array list into a String
	 * @param name the array list storing the name information
	 * @return the String Name containing the name information
	 */
	private String arrayListToString(List<String> name) {
		String Name="";
		for(int i=0;i<name.size();i++) {
			Name =Name+" "+name.get(i);
		}
		return Name;
	}
	
	
	
	/**
	 * private String arrayListJourneyToString(){}
	 * This method converts an array List into a String
	 * @param list represents the list containing the long type IDs
	 * @return The String holding the ID information
	 */
	private String arrayListJourneyToString(List<Long> list) {
		String IDs="";
		int counter=0;
		for (int i=0;i<list.size();i++) {
			IDs = IDs+"\nJourney: "+list.get(i);
			System.out.println(IDs);
			counter=counter+1;
			if(counter>2) { // test or remove
				break;
			}
		}
		return IDs;
	}
	
	
	
	/**
	 * public String getAddress(){}
	 * This method stores the address information into a string containing the City, Street, Building and zipCode information
	 * @return The string holding the full address information
	 */
	public String getAddress() {
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
	
	/**
	 * private String getActiveShipments(){}
	 * This method stores the active shipments information by calling the getActiveShipments() Method
	 * 
	 * @return a String holding the active Shipments information
	 */
	private String getActiveShipments() {
		String activeShipments ="The recently registered journeys: ";
		
		if (currentClient.getSetClient()) {
			client = currentClient.viewClient();
			activeShipments = activeShipments + arrayListJourneyToString(client.getActiveShipments());
		}
		return activeShipments;
	}
	
	/**
	 * private boolean getContainerByJourneyID(){}
	 * This method returns a boolean value depending whether the journeyID inputed exists in the database
	 * @param journeyID the String holding the journeyID
	 * @return a boolean value depending on the user input.
	 */
	private boolean findContainerByJourneyID(String journeyID) {
		if (checkIfJourneyIDisPartOfActiveShipment(journeyID)) {//test this
			System.out.println("The journeyID is valid and part of the activeshipments, now will try to find the container");
			FilterByJourneyID filter = new FilterByJourneyID(currentClient.viewClient(),Long.valueOf(journeyID));
		    container= currentClient.filterContainersOnAJourney(filter);
		    return findContainerByID();
		}
		return false;
	}

    /**
     * private boolean findContainerByID(){}
     * This method checks if the array contains any containers
     * @return boolean value depending on the outcome
     */
	private boolean findContainerByID() {//test this
		if (container.size()>0) {
			System.out.println("Container found, now the data can be read");
			return true;
		}else {
			System.out.println("No containers were found");
			return false;
		}
	}
	
	/**
	 * private boolean checkIfJourneyIDisPartOfActiveShipment(){}
	 * This method checks if the journey is a part of the active shipments
	 * @param journeyID the String ID representative for the journey
	 * @return a boolean value depending whether the journey is a part of the active shipments or not
	 */
	private boolean checkIfJourneyIDisPartOfActiveShipment(String journeyID) {
		String activeShipments = this.getActiveShipments();
		return activeShipments.contains(journeyID);
	}
	
	
	/**
	 * private boolean retrieveContainersByCargo(){}
	 * This method returns a boolean value depending on whether the cargo inputed by the user exists in the database.
	 * @param cargo the string holding the cargo information
	 * @return boolean value depending whether the inputed cargo exists in the database or not
	 */
	private boolean retrieveContainersByCargo(String cargo) {
		FilterByCargoName filter = new FilterByCargoName(currentClient.viewClient(),cargo);
		container = currentClient.filterContainersOnAJourney(filter);
		if(container.size()<=0) {//test this 
			System.out.println("There is no container containing this cargo"+cargo+ "for this client");
			return false;
		}
		System.out.println("Found some containers containing this cargo");
		return true;
	}
	
	
	/**
	 * private boolean getContainerByPortName(){}
	 * This method checks if there are active containers at a specific port and returns a boolean value depending on the outcome
	 * @param portname the String holding the Port Name information
	 * @return a boolean value showing whether there are containers present in a specific port or not
	 */
	private boolean getContainerByPortName(String portname) {//test this
		portID = ExtractingPortID.getPortID(portname);
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

	/**
	 * public String getStartPortName(){}
	 * This method holds the Start port information
	 * @return the start port name by searching the port based on the start port ID
	 */
	public String getStartPortName() {
		return getPortName(container.get(0).getStartPortID());
	}
	
	/**
	 * private String getPortName(){}
	 * This method returns the port name based on the port ID
	 * @param portID long holding the ID of the port
	 * @return a String holding the Port Name
	 */
	private String getPortName(long portID) {
		Port port;
		try {
			port = DataBase.getPort(portID);
		} catch (ElementSelectionException e) { //test this
			System.out.println("Cant find the port");
			throw new Error(e);
		}
		return port.getPortName();
	}
	
	/**
	 * public String getDestinationPortName(){}
	 * This method stores the name of the Destination Port
	 * @return the Port Name besed on the destination port ID
	 */
	public String getDestinationPortName() {
		return getPortName(container.get(0).getDestinationPortID());
	}
	
	/**
	 * public String getCargo(){}
	 * This method holds the Cargo information
	 * @return a String value holding the Cargo information
	 */
	public String getCargo() {
		return container.get(0).getCargo();
	}
	
	
	/**
	 * public String getArrivalDate(){}
	 * This method accesses the arrival date Information
	 * @return a String holding the arrival date information
	 */
	public String getArrivalDate() {
		return container.get(0).getArriveBy();
	}
	
	
	/**
	 * public String getLastUpdate(){}
	 * This methos holds the last updates by calling the getUpdated() method
	 * @return a String golding the last Updates
	 */
	public String getLastUpdate() {
		return container.get(0).getUpdated();
	}
	
	
	
	/**
	 * public String getInternalStatus(){}
	 * This method accesses the internal status of a specific container, by getting the temperature, humidity and pressure information
	 * @return a String holding the internal status of the container
	 */
	public String getInternalStatus() {
		System.out.println("size");
		System.out.println(container.size());
		String temp= Float.toString(container.get(0).getInternalStatus().getTemperature());
		String humidity = Float.toString(container.get(0).getInternalStatus().getHumidity());
		String pressure = Float.toString(container.get(0).getInternalStatus().getAtmosphere());
		
		return "Temperature: "+temp+"\nHumidity: "+humidity+"\nPressure: "+pressure;
	}
	
	
	/**
	 * public String getCurrentLocation(){}
	 * This method accesses the current location of a container by getting the latitude and longitude information
	 * @return a String holding the position of a specific container
	 */
	public String getCurrentLocation() {
		String latitude = Float.toString(container.get(0).getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.get(0).getCurrentPosition().getLongitude());
		return "Latitude: "+latitude+"  Longitude: "+longitude;
	}
	
	
	/**
	 * public String getMulitpleContainersData(){}
	 * This method limits the String holding the container information to up to 2 containers only.
	 * @return a String holding the information about the containers
	 */
	public String getMulitpleContainersData() {
		String result ="Displaying Up to most 2 Containers: ";
		int contains = 0;
		for(int i=0;i<container.size()&&contains>2;i++) { //test this
			result =result+containerDataToString(container.get(i));
			contains++;
		}
		return result;
	}
	
	/**
	 * private String containerDataToString(){}
	 * This method converts the container information to a string 
	 * @param container the object holding the container data
	 * @return the string containing the container information
	 */
	private String containerDataToString(Container container) {//test this
		String result="\n";
		result = result +"\nJourney ID: "+container.getJourneyID();
		result = result +"\nStart Port: "+getPortName(container.getStartPortID());
		result = result +"\nDestination Port: "+getPortName(container.getDestinationPortID());
		result = result +"\nCargo: "+container.getCargo();
		result = result +"\nInternal Status: "+getInternalStatus(container);
		String latitude = Float.toString(container.getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.getCurrentPosition().getLongitude());
		result = result +"\nCurrent Location:"+"Latitude: "+latitude+"Longitude: "+longitude;
		result = result +"\nArrival Date: "+container.getArriveBy();
		result = result +"\nLast Updated: "+container.getUpdated();
		return result;
	}
	
	
	/**
	 * private String getInternalStatus(){}
	 * This method accesses the internal status of a container
	 * @param container the object holding the container information
	 * @return a String holding the internal status of a container
	 */
	
	private String getInternalStatus(Container container) { //test this
		String temp= Float.toString(container.getInternalStatus().getTemperature());
		String humidity = Float.toString(container.getInternalStatus().getHumidity());
		String pressure = Float.toString(container.getInternalStatus().getAtmosphere());
		
		return "Temperature: "+temp+"\nHumidity: "+humidity+"\nPressure: "+pressure;
	}

	
	/**
	 * private boolean checkStartPortName(){}
	 * This method checks is the Start Port exists in the database  and if the port exists it checks if there's an available container at that port
	 * @param portname String holding the port name information
	 * @return a boolean value depending on the outcome
	 */
	private boolean checkStartPortName(String portname) {
		startPortID = ExtractingPortID.getPortID(portname);
		System.out.println("Checking if the port name exists");
	   if (startPortID==1l) {//test this
		   System.out.println("Port name doesnot exist");
		   return false;
	   };
	   System.out.println("Port name is valid");
	    return true;
	}
	
	
	
	/**
	 * private boolean checkDestinationPortName(){}
	 * This method checks if the destination port inputed by the user is a port present into the database
	 * @param portname String holding the destination port Name
	 * @return a boolean value depending whether the port exists or not
	 */
	private boolean checkDestinationPortName(String portname) {
		destinationPortID = ExtractingPortID.getPortID(portname);
		if(destinationPortID==1l) { //test this
			System.out.println("Destination port does not exit");
			return false;
		}
		System.out.println("Destination port exists");
		return true;
	}
	
	
	

	
	
	/**
	 * private boolean setArriveByString(){}
	 * This method sets the Arrival date of a container by taking a date input from the user and checking it's validity
	 * @param date String holding the inputed arrival date
	 * @return boolean value depending whether the date format is acceptable or not
	 */
	private boolean CheckArriveBy(String date) {

		System.out.println("Checking arrive by");
		
		return validate.validateDate(date);
	}
	
	/**
	 * private boolean registerJourney(){}
	 * This method registers a new journey by asking the user to input specific information about the container.
	 * @param cargo String holding the cargo information
	 * @param atm String holding the pressure information
	 * @param temp String holding the optimal temperature information
	 * @param humidity String holding the optimal humidity information
	 * @param arriveby String holding the arrival date information
	 *@return boolean returning whether the container was registered or not//removing this
	 */
	private void registerJourney(String cargo, String atm, String temp, String humidity, String arriveby) {
		float temperature = Float.valueOf(temp);
		float humidity2 = Float.valueOf(humidity);
		float atmosphere = Float.valueOf(atm);
		System.out.println("Going to try registering");
		currentClient.registerContainerForAJourney(startPortID, destinationPortID, cargo, temperature, atmosphere, humidity2, arriveby);
	}
	
	
	
	
	/**
	 * public void saveJourney(){}
	 * This method registers a new journey by asking the user to input different information and checks  
	 * @param startPortName
	 * @param destinationPortName
	 * @param cargo
	 * @param atm
	 * @param temp
	 * @param humidity
	 * @param arriveby
	 */
	public void saveJourney(String startPortName, String destinationPortName, String cargo, String atm, String temp, String humidity,
			String arriveby) {
		checkMessage = checkStartPortName( startPortName);
		if (checkMessage) {
			checkMessage = checkDestinationPortName(destinationPortName);
		}else  {//test this
			System.out.println("There is no startPortName");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(!checkMessage) {//test this
			System.out.println("Destination port not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		
		checkMessage = validate.validateName(cargo);
		System.out.println(cargo+cargo.length());
		if(checkMessage) {
			checkMessage =ValidInputType.validateFloat(atm);
			checkMessage = ValidInputType.validateFloat(temp);
			checkMessage = ValidInputType.validateFloat(humidity);
		}else {//test this
			System.out.println("Cargo is not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(checkMessage) {
			checkMessage = CheckArriveBy(arriveby);
		}else {//test this
			System.out.println("One of the internal status things is invalid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		if(checkMessage) {
			System.out.println("Everything is valid, now trying to register");
			registerJourney(cargo,  atm, temp,  humidity, arriveby);
			clientmenu.successFieldForAddJourney();
		}else {//test this
			System.out.println("Arriveby is not valid");
			clientmenu.errorMessageForAddJourney();
			return;
		}
		
	}
	
	/**
	 * public String searchContainer(){}
	 * This method searches a container based on either the JourneyID, the cargo or the port name
	 * @param journeyID String containing the journey ID
	 * @param cargo String containing the cargo information
	 * @param portName String containing the port name
	 * @return returns the ID of the container that matches the criteria inputed by the user
	 */
	public String searchContainer(String journeyID, String cargo, String portName) {
		boolean checkCriteria = false;
		checkMessage = false;
		long containerID = 1L;
		if(!journeyID.isEmpty()) {
			checkMessage = findContainerByJourneyID(journeyID);
			checkCriteria =true;
		}
		if(!checkMessage&&!cargo.isEmpty()) {
			checkMessage = retrieveContainersByCargo(cargo);
		}
		if(!checkMessage&&!portName.isEmpty()) {//test this
			checkMessage = getContainerByPortName(portName);
		}
		if(checkMessage) {
			clientmenu.setFieldsContainerData();
			
			if(checkCriteria) {
				clientmenu.setFieldsContainerData();
				System.out.println("Container ID for graphs");
				System.out.println(container.get(0).getID());
				containerID=container.get(0).getID();
				clientmenu.viewOneContainerPanel();
				
			}else {//test this
				clientmenu.setFieldsContainerData();
				clientmenu.viewMultipleContainerPanel();
			}
		}else { //test this
			System.out.println("no container found by the above criterias");
			clientmenu.containerSearchError();
		}
		return Long.toString(containerID);
		
	}
	
	
	/**
	 * public String getSuccessfulJourneys() {}
	 * This method collects the information about a successful journey and stores it into a variable called result
	 * @return result which stores the successful journey information
	 */
	public String getSuccessfulJourneys() {//not tested
		String result = "---------------------------------------";
		for(long journeys : currentClient.viewClient().getFinishedShipments()) {
			result = result +"\nJourney ID: "+journeys;
			result = result +"\nContained: "+getCargoByJourneyID(journeys);
			result = result +"\nReached: "+getFinalDestinationByJourneyID(journeys);
			 result =result + "---------------------------------------";
		}
		return "";
	}
	
	
	
	/**
	 * private String getFinalDestinationByJourneyID(){}
	 * This method returns the final destination port characterising a specific journey or if the port doesn't exist it returns an error
	 * @param journeys stores the journey ID 
	 * @return either the port name or a string "Unknown" 
	 */
	private String getFinalDestinationByJourneyID(long journeys) {//not tested
		List<Container> containers = DataBase.searchHistory(Long.toString(journeys));
		if (containers.size()>0) {
			return getPortName(containers.get(0).getDestinationPortID());
		}
		System.out.println("Could not find the container in history for the journey ID: "+journeys);
		return "Unknown";
	}
	
	
	/**
	 * private String getCargoByJourneyID(){}
	 * This method holds the information about the cargo of a specific ID from the history
	 * @param journeys Long storing the journey ID
	 * @return the cargo of the container or the "unknown" message.
	 */
	private String getCargoByJourneyID(long journeys) {//not tested
		List<Container> containers = DataBase.searchHistory(Long.toString(journeys));
		if (containers.size()>0) {
			return containers.get(0).getCargo();
		}
		System.out.println("Could not find the container in history for the journey ID: "+journeys);
		return "Unknown";
	}
	
	
	/**
	 * public String getAllActiveShipments(){}
	 * This method holds the information about all the active Shipments
	 * @return all the current active shipments.
	 */
	public String getAllActiveShipments() {
		String result = "All Active Journeys: ";
		
		for(long Journeys : currentClient.viewClient().getActiveShipments()) {
			result = result+"\nJourney ID: "+Journeys;
			result = result +"-----------------------------------------------------";
		}
		return result;
	}
	
}
