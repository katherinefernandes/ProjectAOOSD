package logic;


import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import dataWrappers.ReferenceName;
import applications.CompanyApplication;
import businessObjects.Client;
import businessObjects.Container;
import businessObjects.Port;
import exceptions.ElementSelectionException;
import graphicalInterface.LogisticMenu;
import searchClients.SearchByEmail;
import searchClients.SearchByName;
import searchClients.SearchByPhone;
import searchClients.SearchByReferencePerson;
import supportingClasses.DataForViewAllJourneys;
import supportingClasses.ValidInput;
import supportingClasses.InputParser;
import updateContainer.UpdateLocation;
import updateContainer.UpdateStatus;
/**
 * This class connects the logic behind the Logistics Company to the graphical user interface
 * @author daniela
 *
 */
public class LogisticController {
	private CompanyApplication logistic;
	private String companyName;
	private String email;
	private ValidInput validate;
	private int cc;
	private Long phonenumber;
	private ArrayList<String> firstName;
	private ArrayList<String> middleName= new ArrayList<String>();
	private ArrayList<String> lastName;
	private String street;
	private String city;
	private Integer building;
	private String zipcode;
	private long containerID;
	private SearchByEmail optionEmail;
	private List<Client> clients;
	private SearchByName optionName;
	private SearchByPhone optionPhone;
	private ArrayList<String> firstN;
	private ArrayList<String> middleN;
	private ArrayList<String> lastN;
	private ReferenceName searchRefPerson;
	private SearchByReferencePerson optionRefPerson;
	private LogisticMenu logisticMenu;
	private boolean	checkMessage ;
	/**
	 * This constructor initialises the logistics company menu 
	 */
	public LogisticController(){
		logistic = new CompanyApplication();
		validate = new ValidInput();
		logisticMenu = new LogisticMenu(this);
	}

	//TODO methods called in interface should have names that of the form "saveRefrencePersonPressed" to make it clear that we're separating view from controller

	/**
	 * private boolean setCompanyNam(){}
	 * This method sets the new company name
	 * @param text string that holds the value of the company name
	 * @return true
	 */
	private void setCompanyName(String text) {
		this.companyName=text;
	}

 
	private void setEmail(String email) {
		this.email = email;	
	}


//	
//	private boolean setCountryCode(String countryCode) {
//
//		try {
//			cc = Integer.valueOf(countryCode);
//			System.out.println("string is correct");
//			return validate.validateCountryCode(cc);
//		}catch(NumberFormatException e) {
//			System.out.println("the countrycode is not valid");
//			return false;
//		}
//	}
	
	
	private void setCountryCode(String countryCode) {
		this.cc = Integer.valueOf(countryCode);
	}

    /**
     * private boolean setPhoneNumber(){}
     * This method sets the phone number inputed by the user
     * @param phone String that holds the value of the phone number
     * @return boolean value depending whether the input is valid or not
     */
//	private boolean setPhoneNumber(String phone) {
//			try {
//				phonenumber = Long.valueOf(phone);
//				System.out.println("string is correct");
//				return validate.validatePhone(phonenumber);
//				}catch(NumberFormatException e) {
//					System.out.println("the countrycode is not valid");
//					return false;
//				}
//	}
	
	private void setPhoneNumber(String phone) {
		phonenumber = Long.valueOf(phone);
	}

    /**
     * private boolean setFirstName(){}
     * This method sets the first name 
     * @param name1 holds the value inputed by the user for the first name of the reference person
     * @return a boolean value depending whether the name is valid or not
     */
	private void setFirstName(String name1) {

		firstName = InputParser.parsingNames(name1);
		//return validate.validateName(name1);
	}

    /**
     * private boolean setMiddleName(){}
     * This method sets the middle name of the reference person
     * @param name2 holds the string containing the middle name or middle names (that's why we use the parser)
     * @return boolean depending whether the input is valid
     */
	private void setMiddleName(String name2) {

		middleName = InputParser.parsingNames(name2);
		//return validate.validateName(name2);
	}

    /**
     * private boolean setLastName(){}
     * This method sets the Last Name of the reference person
     * @param name stores the string holding the last name of the reference person
     * @return boolean depending whether the name inputed is valid or not
     */
	private void setLastName(String name) {
		lastName = InputParser.parsingNames(name);
		//return validate.validateName(name);
	}

    /**
     * private boolean setStreetName(){}
     * This method sets the street Name
     * @param street holds the string containing the inputed street name 
     * @return true (we assumed any street would be valid) 
     */
	private void setStreetName(String street) {

		this.street=street;

	}

    /**
     * private boolean setCity(){}
     * This method sets the City
     * @param text String containing the city name
     * @return boolean depending whether the City is Valid or not
     */
	private void setCity(String text) {

		this.city = text;
		//return validate.validateName(text);
	}
	
	
  
    /**
     * 
     * @param text
     * @return
     */
	private void setBuilding(String text) {
//		try {
//			this.building = Integer.valueOf(text);
//			System.out.println("Building number is correct");
//			return true;
//			}catch(NumberFormatException e) {
//				System.out.println("the building number is not valid");
//				return false;
//			}
		this.building = Integer.valueOf(text);
	}


	private void setPostcode(String postcode) {

		this.zipcode= postcode;
		//return validate.validatePostCode(postcode);
	}


	private boolean addClient() {

		logistic.setAddNewClient();
		logistic.addClient(email, companyName, cc, phonenumber, firstName, middleName, lastName, street, city, zipcode, building);
		return logistic.getAddNewClient();
	}


	private boolean setContainerForUpdate(String text) {

		try {
			containerID= Long.valueOf(text);
			System.out.println("String is correct");
			logistic.getContainer(containerID);
			return logistic.getSetContainer();
			}catch(NumberFormatException e) {
				System.out.println("the containerID is not valid");
				return false;
			}catch(ElementSelectionException e) {
				System.out.println("The counterID is not correct");
				return false;
			}
	}


	


	public boolean updateStatus(String pressure, String humidity, String temperature) {
		float temp;
		float humi;
		float pres; 
		try {
			temp= Float.valueOf(temperature);
			System.out.println("Correct temperature");
			}catch(NumberFormatException e) {
				System.out.println("the temp is not valid");
				return false;
			}
		try {
			humi= Float.valueOf(humidity);
			System.out.println("Correct humidity");
			}catch(NumberFormatException e) {
				System.out.println("the humidity is not valid");
				return false;
			}
		try {
			pres= Float.valueOf(pressure);
			System.out.println("Correct pressure");
			}catch(NumberFormatException e) {
				System.out.println("the pressure is not valid");
				return false;
			}
		UpdateStatus update = new UpdateStatus( temp, humi,pres);
		
		return logistic.updateContainerInformation(update);
	}
	private String getPortName(long portID) {
		Port port;
		try {
			port = DataBase.getPort(portID);
		} catch (ElementSelectionException e) {

			System.out.println("Cant find the port");
			throw new Error(e);
		}
		return port.getPortName();
	}

	public String getContainerData() {
		Container container = logistic.viewContainer();
		String result="\n";
		result = result +"\nJourney ID: "+container.getJourneyID();
		result = result +"\nStart Port: "+getPortName(container.getStartPortID());
		result = result +"\nDestination Port: "+getPortName(container.getDestinationPortID());
		result = result +"\nCargo: "+container.getCargo();
		result = result +"\nInternal Status: "+getInternalStatus(container);
		String latitude = Float.toString(container.getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.getCurrentPosition().getLongitude());
		result = result +"\nCurrent Location:"+"Latitude: "+latitude+" Longitude: "+longitude;
		result = result +"\nArrival Date: "+container.getArriveBy();
		result = result +"\nLast Updated: "+container.getUpdated();
		return result;
	}

	private String getInternalStatus(Container container) {		String temp= Float.toString(container.getInternalStatus().getTemperature());
		String humidity = Float.toString(container.getInternalStatus().getHumidity());
		String pressure = Float.toString(container.getInternalStatus().getAtmosphere());
		
		return "Temperature: "+temp+"\nHumidity: "+humidity+"\nPressure: "+pressure;
	}


	private boolean updatePosition(String longitude, String latitude) {
		//TODO try to avoid abbreviations in names
		float longit;
		float lati;
		try {
			longit= Float.valueOf(longitude);
			System.out.println("Correct string longitude");
			}catch(NumberFormatException e) {
				System.out.println("the  longitude is not valid");
				return false;
			}
		try {
			lati= Float.valueOf(latitude);
			System.out.println("Correct string latitude");
			}catch(NumberFormatException e) {
				System.out.println("the  latitude is not valid");
				return false;
			}
		if (validate.validateLocation(lati)&&validate.validateLocation(longit)) {
			UpdateLocation update = new UpdateLocation( longit,lati);
			return logistic.updateContainerInformation(update);
		}
		return false;
	}

	public boolean findClientByEmail(String searchEmail) {

		optionEmail = new SearchByEmail(searchEmail);
		clients= logistic.search(optionEmail);
		if (clients.size()>0) {
			
			return true;
		}
		return false; 
		
	}


	public boolean findClientByCompanyName(String searchName) {

		optionName = new SearchByName(searchName);
		clients = logistic.search(optionName);
		if(clients.size()>0) {
			return true;
		}
		return false;
	}


	public boolean findClientByPhone(String phone) {

		long phonenumber;
		try {
			phonenumber= Long.valueOf(phone);
			System.out.println("Correct string phonenumber");
			optionPhone = new SearchByPhone(phonenumber);
			clients = logistic.search(optionPhone);
			}catch(NumberFormatException e) {
				System.out.println("the  latitude is not valid");
				return false;
			}
		if (clients.size()>0) {
			return true;
		}
		return false;
	}


	public boolean findClientByReferencePerson(String text, String string, String text2) {
		firstN = InputParser.parsingNames(text);
		
		middleN = InputParser.parsingNames(string);
		
		lastN = InputParser.parsingNames(text2);
		
		searchRefPerson = new ReferenceName(firstN, middleN, lastN);
		
		optionRefPerson = new SearchByReferencePerson(searchRefPerson);
		
		clients = logistic.search(optionRefPerson);
		if(clients.size()>0) {
			return true;
		}
		return false;
	}


	public String viewClient() {

		String result ="Displaying Up to most 3 Clients: ";
		int counter =0;
		for(int i=0;i<clients.size();i++) {
			result =result+clientDataToString(clients.get(i));
			counter++;
			if(counter>2) {
				break;
			}
		}
		return result;
	}
	private String clientDataToString(Client client) {
		String result ="\n";
		result = result +"\nClient ID: "+client.getID();
		result = result +"\nCompany Name: "+client.getCompanyName();
		result =result +"\nEmail: "+client.getEmail();
		result = result +"\nReference Person: "+arraylisttostring(client.getPerson().getFirstName())+arraylisttostring(client.getPerson().getMiddleName())+arraylisttostring(client.getPerson().getLastName());
		result = result +"\nPhone number: "+Integer.toString(client.getPhoneNumber().getCountryCode())+Long.toString(client.getPhoneNumber().getPhone());
		return result;
	}
	private String arraylisttostring(List<String> string) {
		String result="";
		for(int i=0;i<string.size();i++) {
			result = result +" "+ string.get(i);
		}
		return result;
	}


	
	public void addNewClient(String postcode, String building, String city, String street, String lastname, String middlename,String firstname, String phone, String countrycode, String email,String companyname) {
		setCompanyName(companyName);
		if(validate.validateEmail(email)) {
			setEmail(email);
		}
		
		else {
			System.out.println("email name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		
		
		if(validate.validateCountryCode(cc)) {
			setCountryCode(countrycode);
		}
		
		else {
			System.out.println("country code has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		
		 
		if(validate.validatePhone(Long.valueOf(phone))) {
			setPhoneNumber(phone);
		}
		
		
		else {
			System.out.println("phonenumber has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (validate.validateName(firstname)) {
			setFirstName(firstname);
		}
		
		else {
			System.out.println("Invalid first name");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (validate.validateName(middlename)) {
			setMiddleName(middlename);
		}else {
			System.out.println("middle name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (validate.validateName(lastname)) {
			setLastName(lastname);
		}else {
			System.out.println("last name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(validate.validateName(street)) {
			setStreetName(street);
		}else {
			System.out.println("Street name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(validate.validateName(city)) {
			setCity(city);
		}else {
			System.out.println("City name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(validate.validateLocation(Float.valueOf(building))) {
			setBuilding(building);
			
		}else {
			System.out.println("cbuilding has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(validate.validatePostCode(postcode)) {
			setPostcode(postcode);
		}else {
			System.out.println("Post code has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		
		if(addClient()) {
			logisticMenu.successFieldForAddClient();
		}else {
			logisticMenu.errorMessageForAddClient();
		}
		
	}


	public void updateContainerPosition(String containerID, String logitude, String latitude) {

		checkMessage = setContainerForUpdate(containerID);
		if (checkMessage){
			checkMessage = updatePosition(logitude,latitude);
		}else {
			System.out.println("Container ID is invalid, try again");
			logisticMenu.errorPositionUpdate();
			return;
		}
		if(checkMessage) {
			System.out.println("Valid info");
			
			
		}else {
			
			System.out.println("Something went wrong in update..");
			logisticMenu.errorPositionUpdate(); 
		}
	}


	public void updateContainerStatus(String containerID, String press, String humid, String temp) {
		
		checkMessage = setContainerForUpdate(containerID);
		
		if (checkMessage){
			checkMessage =updateStatus(press,humid,temp);
		}else {
			System.out.println("Invalid container ID");
			logisticMenu.errorStatusUpdate();
			return;
		}
		if(checkMessage) {
			System.out.println("Valid info");
			
			return;
		}else {
			System.out.println("Something went wrong in status update");
			logisticMenu.errorStatusUpdate();
			return;
		}
		
	}
	
	public boolean checkMessage() {
		return checkMessage;
	}


	public void searchClient(String email, String company, String phone, String firstname, String middle, String last) {
		//TODO this could probably be done in a for loop
		checkMessage=false;
		if (!email.isEmpty()) {
			checkMessage = findClientByEmail(email);
			
		} 
		if(!checkMessage&&!company.isEmpty()) {
			checkMessage = findClientByCompanyName(company);
			
		}
		if(!checkMessage&&!phone.isEmpty()) {
			checkMessage =findClientByPhone(phone);
		}
		if(!checkMessage&&!(firstname.isEmpty()&&last.isEmpty())) {
			if(middle.isEmpty()) {
				checkMessage = findClientByReferencePerson(firstname,"",last);
			}else {
				checkMessage = findClientByReferencePerson(firstname,middle,last);
			}
		}
		
		if(checkMessage) {
			System.out.println("Success search");
			return;
		}else {
			System.out.println("Not success");
			logisticMenu.errorSearch();
		}
	}


	public String getAllJourneys() {
		
		return new DataForViewAllJourneys().getResult();
	}
	

	
}
