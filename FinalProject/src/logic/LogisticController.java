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
	
	public LogisticController(){
		logistic = new CompanyApplication();
		validate = new ValidInput();
		logisticMenu = new LogisticMenu(this);
	}

	//TODO unify way of sending information from interface to controller
	//TODO reduce method to one level of abstraction
	//TODO methods called in interface should have names that of the form "saveRefrencePersonPressed" to make it clear that we're separating view from controller
	//TODO Is it really valuable to have all these getters and setters return booleans? Seems largely unnecessary, and in conflict with the single responsibility principle
	//It could be okay in some contexts, but I don't think we should follow the pattern as a rule.
	private boolean setCompanyName(String text) {

		this.companyName=text;
		return true;
	}


	private boolean setEmail(String email) {

		this.email = email;
		return validate.validateEmail(email);
	}


	private boolean setCountryCode(String countryCode) {

		try {
			cc = Integer.valueOf(countryCode);
			System.out.println("string is correct");
			return validate.validateCountryCode(cc);
		}catch(NumberFormatException e) {
			System.out.println("the countrycode is not valid");
			return false;
		}
	}


	private boolean setPhoneNumber(String phone) {
			try {
				phonenumber = Long.valueOf(phone);
				System.out.println("string is correct");
				return validate.validatePhone(phonenumber);
				}catch(NumberFormatException e) {
					System.out.println("the countrycode is not valid");
					return false;
				}
	}


	private boolean setFirstName(String name1) {

		firstName = InputParser.parsingNames(name1);
		return validate.validateName(name1);
	}


	private boolean setMiddleName(String name2) {

		middleName = InputParser.parsingNames(name2);
		return validate.validateName(name2);
	}


	private boolean setLastName(String name) {
		lastName = InputParser.parsingNames(name);
		return validate.validateName(name);
	}


	private boolean setStreetName(String street) {

		this.street=street;
		return true;
	}


	private boolean setCity(String text) {

		this.city = text;
		return validate.validateName(text);
	}


	private boolean setBuilding(String text) {
		try {
			this.building = Integer.valueOf(text);
			System.out.println("Building number is correct");
			return true;
			}catch(NumberFormatException e) {
				System.out.println("the building number is not valid");
				return false;
			}
	}


	private boolean setPostcode(String postcode) {

		this.zipcode= postcode;
		return validate.validatePostCode(postcode);
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

	//TODO names of methods returning booleans shouldn't start with get
	public boolean getClientByEmail(String searchEmail) {

		optionEmail = new SearchByEmail(searchEmail);
		clients= logistic.search(optionEmail);
		if (clients.size()>0) {
			
			return true;
		}
		return false;
		
	}


	public boolean getClientByCompanyName(String searchName) {

		optionName = new SearchByName(searchName);
		clients = logistic.search(optionName);
		if(clients.size()>0) {
			return true;
		}
		return false;
	}


	public boolean getClientByPhone(String phone) {

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


	public boolean getClientByReferencePerson(String text, String string, String text2) {
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


	public String getclientsview() {

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
		//TODO waaay to many if statements. This is impossible to read
		boolean	checkMessage = setCompanyName(companyname);
		if(checkMessage) {
			checkMessage = setEmail(email);
		}else {
			System.out.println("Company name has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage = setCountryCode(countrycode);
		}else {
			System.out.println("email has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage = setPhoneNumber(phone);
		}else {
			System.out.println("Countrycode has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (checkMessage) {
			checkMessage =setFirstName(firstname);
		}else {
			System.out.println("phone has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (checkMessage) {
			checkMessage =setMiddleName(middlename);
		}else {
			System.out.println("firstname has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if (checkMessage) {
			checkMessage = setLastName(lastname);
		}else {
			System.out.println("middlename has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage = setStreetName(street);
		}else {
			System.out.println("lastname has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage = setCity(city);
		}else {
			System.out.println("street has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage =setBuilding(building);
		}else {
			System.out.println("city has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage =setPostcode(postcode);
		}else {
			System.out.println("building has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
			checkMessage =addClient();
		}else {
			System.out.println("postcode has error");
			logisticMenu.errorMessageForAddClient();
			return;
		}
		if(checkMessage) {
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
			checkMessage = getClientByEmail(email);
			
		} 
		if(!checkMessage&&!company.isEmpty()) {
			checkMessage = getClientByCompanyName(company);
			
		}
		if(!checkMessage&&!phone.isEmpty()) {
			checkMessage =getClientByPhone(phone);
		}
		if(!checkMessage&&!(firstname.isEmpty()&&last.isEmpty())) {
			if(middle.isEmpty()) {
				checkMessage = getClientByReferencePerson(firstname,"",last);
			}else {
				checkMessage = getClientByReferencePerson(firstname,middle,last);
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
