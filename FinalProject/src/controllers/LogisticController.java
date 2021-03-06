package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import dataBase.DataBase;
import dataWrappers.ReferenceName;
import applications.CompanyApplication;
import exceptions.ElementSelectionException;
import graphicalInterface.LogisticMenu;
import objects.Client;
import objects.Container;
import objects.Port;
import searchClients.SearchByEmail;
import searchClients.SearchByName;
import searchClients.SearchByPhone;
import searchClients.SearchByReferencePerson;
import supportingClasses.DataForViewAllJourneys;
import supportingClasses.ExtractingPortID;
import supportingClasses.ValidInput;
import supportingClasses.ValidInputType;
import supportingClasses.InputParser;
import updateContainer.UpdateLocation;
import updateContainer.UpdatePort;
import updateContainer.UpdateStatus;
import worldMap.MapPane;

/**
 * Connects the CompanyApplication to the logisticMenu
 * @author Daniela
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
	private List<Client> clients = new ArrayList<Client>();
	private SearchByName optionName;
	private SearchByPhone optionPhone;
	private ArrayList<String> firstN;
	private ArrayList<String> middleN;
	private ArrayList<String> lastN;
	private ReferenceName searchRefPerson;
	private SearchByReferencePerson optionRefPerson;
	private LogisticMenu logisticMenu;
	private boolean	checkMessage ;
	private UpdateStatus updateStatus;
	private UpdateLocation updatePosition;
	private updateContainer.UpdatePort updatePort;
	
	public LogisticController(){
		logistic = new CompanyApplication();
		validate = new ValidInput();
		logisticMenu = new LogisticMenu(this);
	}

	private void setCompanyName(String text) {
		this.companyName=text;
	}


	private void setEmail(String email) {
		this.email = email;
	}


	private void setCountryCode(String countryCode) {
			this.cc= Integer.valueOf(countryCode);
	}


	private void setPhoneNumber(String phone) {
		phonenumber = Long.valueOf(phone);
	}


	private void setFirstName(String name1) {
		firstName = InputParser.parsingNames(name1);
	}


	private void setMiddleName(String name2) {
		middleName = InputParser.parsingNames(name2);
	}


	private void setLastName(String name) {
		lastName = InputParser.parsingNames(name);
	}


	private void setStreetName(String street) {
		this.street=street;
	}


	private void setCity(String text) {

		this.city = text;
	}


	private void setBuilding(String text) {	
			this.building = Integer.valueOf(text);	
	}


	private void setPostcode(String postcode) {
		this.zipcode= postcode;
	}


	private void addClient() {

		logistic.addClient(email, companyName, cc, phonenumber, firstName, middleName, lastName, street, city, zipcode, building);
		
	}


	private void setContainerForUpdate(String text) {
		try {
			containerID= Long.valueOf(text);
			logistic.getContainer(containerID);
			}catch(ElementSelectionException e) {
				System.out.println("The counterID is not correct");
			}
	}


	
	


	private void setStatus(String pressure, String humidity, String temperature) {
		float temp;
		float humi;
		float pres;
		
		temp= Float.valueOf(temperature);
		humi= Float.valueOf(humidity);
		pres= Float.valueOf(pressure);
		updateStatus = new UpdateStatus( temp, humi,pres);
	}
	private String getPortName(long portID) {
		Port port;
		try {
			port = DataBase.getPort(portID);
		} catch (ElementSelectionException e) {
			System.out.println("Cant find the port");
			throw new Error(e); // as the port should exist...
		}
		return port.getPortName();
	}

	
	/**
	 * Gets the container data for a single container stored in the companyApplication
	 * @return string of data
	 */
	public String getContainerData() {
		Container container = logistic.viewContainer();
		String result="\n";
		result = result +"\nJourney ID: "+container.getJourneyID();
		result = result +"\nStart Port: "+getPortName(container.getStartPortID());
		result = result +"\nDestination Port: "+getPortName(container.getDestinationPortID());
		result = result +"\nLast Visited Port: "+getPortName(container.getLastVisitedPortID());
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


	private void setPosition(String longitude, String latitude) {
		float Longitude;
		float Latitude;
		Longitude= Float.valueOf(longitude);
		
		Latitude= Float.valueOf(latitude);
		updatePosition = new UpdateLocation( Longitude,Latitude);
	}

	private void setClientsByEmail(String searchEmail) {
		optionEmail = new SearchByEmail(searchEmail);
		List<Client> clientsFound = logistic.search(optionEmail);
		addClients(clientsFound);
		
	}

	private void addClients(List<Client> clientsFound) {
		for(Client client : clientsFound) {
			clients.add(client);
		}
	}

	private boolean checkSizeOfClients() {
		if (clients.size()>0) {
			return true;
		}
		return false;
	}


	private void setClientsByCompanyName(String searchName) {
		optionName = new SearchByName(searchName);
		List<Client> clientsFound = logistic.search(optionName);
		addClients(clientsFound);
	}


	private void setClientsByPhone(String phone) {

			phonenumber= Long.valueOf(phone);
			optionPhone = new SearchByPhone(phonenumber);
			List<Client> clientsFound = logistic.search(optionPhone);
			addClients(clientsFound);
	}


	private void getClientByReferencePerson(String text, String string, String text2) {
		firstN = InputParser.parsingNames(text);
		
		middleN = InputParser.parsingNames(string);
		
		lastN = InputParser.parsingNames(text2);
		
		searchRefPerson = new ReferenceName(firstN, middleN, lastN);
		
		optionRefPerson = new SearchByReferencePerson(searchRefPerson);
		
		List<Client> clientsFound = logistic.search(optionRefPerson);
		addClients(clientsFound);
	}

 /**
  * Used to display information for up to most 3 clients
  * @return a string of data
  */
	public String getclientsview() {
        System.out.println("Inside get client view");
		String result ="Displaying Up to most 3 Clients: ";
		int counter =0;
		for(int i=0;i<clients.size()&&counter<3;i++) {
			result =result+clientDataToString(clients.get(i));
			counter++;
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


	/**
	 * It creates a new client in the system
	 * @param postcode
	 * @param building
	 * @param city
	 * @param street
	 * @param lastname
	 * @param middlename
	 * @param firstname
	 * @param phone
	 * @param countrycode
	 * @param email
	 * @param companyname
	 * @return true if the registeration was successful
	 */
	public boolean addNewClient(String postcode, String building, String city, String street, String lastname, String middlename,String firstname, String phone, String countrycode, String email,String companyname) {
		checkMessage = false;
		setCompanyName(companyname);
		if(validate.validateEmail(email)) {
			setEmail(email);
		}else {
			System.out.println("email had error");
			return false;
		}
		if(ValidInputType.validateInteger(countrycode)&&validate.validateCountryCode(Integer.valueOf(countrycode))) {
			 setCountryCode(countrycode);
		}else {
			System.out.println("countrycode has error");
			return false;
		}
		if(ValidInputType.validateLong(phone)&&validate.validatePhone(Long.valueOf(phone))) {
			setPhoneNumber(phone);
		}else {
			System.out.println("Phone has error");
			return false;
		}
		if (validate.validateName(firstname)) {
			setFirstName(firstname);
		}else {
			System.out.println("firstname has error");
			return false;
		}
		if (validate.validateName(middlename)) {
			setMiddleName(middlename);
		}else {
			System.out.println("Middlename has error");
			return false;
		}
		if (validate.validateName(lastname)) {
			 setLastName(lastname);
		}else {
			System.out.println("lastname has error");
			return false;
		}
		 setStreetName(street);
		
		if(validate.validateName(city)) {
			setCity(city);
		}else {
			System.out.println("city has error");
			return false;
		}
		if(ValidInputType.validateInteger(building)) {
			setBuilding(building);
		}else {
			System.out.println("building number has error");
			return false;
		}
		if(validate.validatePostCode(postcode)) {
			setPostcode(postcode);
		}else {
			System.out.println("postcode has error");
			return false;
		}
		addClient();
		System.out.println("Client was added successfully");
		checkMessage = true;
		return true;
		
		
	}

/**
 * Updates the container position 
 * @param containerID
 * @param logitude
 * @param latitude
 */
	public void updateContainerPosition(String containerID, String logitude, String latitude) {
		checkMessage = false;
		if(ValidInputType.validateLong(containerID)) {
			setContainerForUpdate(containerID);
		}else {
			System.out.println("Container ID type is not valid");
			logisticMenu.errorPositionUpdate();
			return;
		}
		boolean checks = logistic.getSetContainer()&&ValidInputType.validateFloat(latitude)&&ValidInputType.validateFloat(latitude)&&validate.validateLocation(Float.valueOf(latitude))&&validate.validateLocation(Float.valueOf(logitude));
		if (checks){
			setPosition(logitude,latitude);
		}else {
			System.out.println("Container ID is invalid, try again");
			logisticMenu.errorPositionUpdate();
			return;
		}
		if(logistic.updateContainerInformation(updatePosition)) {
			System.out.println("Valid info");
			System.out.println(logistic.viewContainer().getID());
			checkMessage = true;
			
		}else {
			System.out.println("Something went wrong in update..");
			logisticMenu.errorPositionUpdate();
			
		}
	}
	/**
	 * Updates the container status
	 * @param containerID
	 * @param press
	 * @param humid
	 * @param temp
	 */

	public void updateContainerStatus(String containerID, String press, String humid, String temp) {
		checkMessage = false;
		if(ValidInputType.validateLong(containerID)) {
			setContainerForUpdate(containerID);
		}else {
			System.out.println("Container ID type is not valid");
			logisticMenu.errorPositionUpdate();
			return;
		}
		if (logistic.getSetContainer()&&ValidInputType.validateFloat(temp)&&ValidInputType.validateFloat(press)&&ValidInputType.validateFloat(humid)){
			setStatus(press,humid,temp);
		}else {
			System.out.println("Invalid container ID");
			logisticMenu.errorStatusUpdate();
			return;
		}
		if(logistic.updateContainerInformation(updateStatus)) {
			System.out.println("Valid info");
			checkMessage = true;
			return;
		}else {
			System.out.println("Something went wrong in status update");
			logisticMenu.errorStatusUpdate();
			return;
		}
		
	}
	/**
	 * Used to check if the updates and the search was successful
	 * @return checkMessage
	 */
	public boolean checkMessage() {
		return checkMessage;
	}

	/**
	 * Allows the company to search for a client
	 * @param email
	 * @param company
	 * @param phone
	 * @param firstname
	 * @param middle
	 * @param last
	 */
	public void searchClient(String email, String company, String phone, String firstname, String middle, String last) {
		checkMessage=false;
		if (!email.isEmpty()) {
			setClientsByEmail(email);
			checkMessage = checkSizeOfClients();
			System.out.println("client found by email: "+checkMessage);
		} 
		if(!checkMessage&&!company.isEmpty()) {
			setClientsByCompanyName(company);
			checkMessage = checkSizeOfClients();
		}
		if(!checkMessage&&!phone.isEmpty()&&ValidInputType.validateLong(phone)) {
			setClientsByPhone(phone);
			checkMessage = checkSizeOfClients();
		}
		if(!checkMessage&&!(firstname.isEmpty()&&last.isEmpty())) {
			if(middle.isEmpty()) {
			 getClientByReferencePerson(firstname,"",last);
			 checkMessage = checkSizeOfClients();
			}else {
				getClientByReferencePerson(firstname,middle,last);
				checkMessage = checkSizeOfClients();
			}
		}
		
		if(checkMessage) {
			System.out.println("Success search");
		}else {
			System.out.println("Not success");
			logisticMenu.errorSearch();
		}
	}

	/**
	 * Used to extract the information for all the registered, active journeys
	 * @return string of data
	 */
	public String getAllJourneys() {
		
		return new DataForViewAllJourneys().getOutPut();
	}
	/**
	 * Used to update the last Port container has visited
	 * @param containerID
	 * @param portName
	 */
	public void updateContainerPort(String containerID, String portName) {
		checkMessage = false;
		if(ValidInputType.validateLong(containerID)) {
			setContainerForUpdate(containerID);
		}else {
			System.out.println("Container ID type is not valid");
			logisticMenu.displayPortError();
			return;
		} 
		long portID = ExtractingPortID.getPortID(portName);
		boolean checks = logistic.getSetContainer()&& portID!=1l;
		if (checks){
			setPort(portID);
		}else {
			System.out.println("Container ID is invalid, try again");
			logisticMenu.displayPortError();
			return;
		}
		if(logistic.updateContainerInformation(updatePort)) {
			System.out.println("Valid info");
			System.out.println(logistic.viewContainer().getID());
			checkMessage = true;
			
		}else {
			System.out.println("Something went wrong in update..");
			logisticMenu.displayPortError();
			
		}	
	
	
	}

	private void setPort(long portID) {	
		updatePort = new UpdatePort(portID);
		
		
		
	}
	
	/**
	 * Used to display the world map
	 */
	public void startMap() {
		SwingUtilities.invokeLater(() -> {  
			MapPane m=new MapPane("");
			logisticMenu.openMap(m);
	        
	        Timer mapUpdate = new Timer(500, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.repaint();
		         }
			});
			mapUpdate.start();
		});
	}
}