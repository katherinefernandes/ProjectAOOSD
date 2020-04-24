package logic;


import java.util.ArrayList;
import java.util.List;

import applications.CompanyApplication;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import objectsData.ReferenceName;
import searchClients.SearchByEmail;
import searchClients.SearchByName;
import searchClients.SearchByPhone;
import searchClients.SearchByReferencePerson;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateContainer.UpdateLocation;
import updateContainer.UpdateStatus;
import xmlParser.PortXMLManipulation;

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
	private PortXMLManipulation databasePort;
	private SearchByEmail optionEmail;
	private List<ClientData> clients;
	private SearchByName optionName;
	private SearchByPhone optionPhone;
	private ArrayList<String> firstN;
	private ArrayList<String> middleN;
	private ArrayList<String> lastN;
	private ReferenceName searchRefPerson;
	private SearchByReferencePerson optionRefPerson;
	
	public LogisticController(){
		logistic = new CompanyApplication();
		validate = new ValidInput();
		databasePort=new PortXMLManipulation();
	}


	public boolean setCompanyName(String text) {
		// TODO Auto-generated method stub
		this.companyName=text;
		return true;
	}


	public boolean setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		return validate.validateEmail(email);
	}


	public boolean setCountryCode(String countryCode) {
		// TODO Auto-generated method stub
		try {
			cc = Integer.valueOf(countryCode);
			System.out.println("string is correct");
			return validate.validateCountryCode(cc);
		}catch(NumberFormatException e) {
			System.out.println("the countrycode is not valid");
			return false;
		}
	}


	public boolean setPhoneNumber(String phone) {
			try {
				phonenumber = Long.valueOf(phone);
				System.out.println("string is correct");
				return validate.validatePhone(phonenumber);
				}catch(NumberFormatException e) {
					System.out.println("the countrycode is not valid");
					return false;
				}
	}


	public boolean setFirstName(String name1) {
		// TODO Auto-generated method stub
		
		firstName = parseInput.parsingNames(name1);
		return validate.validateName(name1);
	}


	public boolean setMiddleName(String name2) {
		// TODO Auto-generated method stub
		middleName = parseInput.parsingNames(name2);
		return validate.validateName(name2);
	}


	public boolean setLastName(String name) {
		// TODO Auto-generated method stub
		lastName = parseInput.parsingNames(name);
		return validate.validateName(name);
	}


	public boolean setStreetName(String street) {
		// TODO Auto-generated method stub
		this.street=street;
		return true;
	}


	public boolean setCity(String text) {
		// TODO Auto-generated method stub
		this.city = text;
		return validate.validateName(text);
	}


	public boolean setBuilding(String text) {
		// TODO Auto-generated method stub
		try {
			this.building = Integer.valueOf(text);
			System.out.println("Building number is correct");
			return true;
			}catch(NumberFormatException e) {
				System.out.println("the building number is not valid");
				return false;
			}
	}


	public boolean setPostcode(String postcode) {
		// TODO Auto-generated method stub
		this.zipcode= postcode;
		return validate.validatePostCode(postcode);
	}


	public boolean addClient() {
		// TODO Auto-generated method stub
		logistic.setAddNewClient();
		logistic.addClient(email, companyName, cc, phonenumber, firstName, middleName, lastName, street, city, zipcode, building);
		return logistic.getAddNewClient();
	}


	public boolean setContainerForUpdate(String text) {
		// TODO Auto-generated method stub
		try {
			containerID= Long.valueOf(text);
			System.out.println("String is correct");
			logistic.getContainer(containerID);
			return logistic.getSetContainer();
			}catch(NumberFormatException e) {
				System.out.println("the containerID is not valid");
				return false;
			}catch(ElementNotFoundException e) {
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
		UpdateStatus update = new UpdateStatus(pres, temp, humi);
		
		
		return logistic.updateContainerInformation(update);
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

	public String getContainerData() {
		// TODO Auto-generated method stub
		ContainerData container = logistic.viewContainer();
		String result="\n";
		result = result +"\nJourney ID: "+container.getJourneyID();
		result = result +"\nStart Port: "+getPortName(container.getStartPortID());
		result = result +"\nDestination Port: "+getPortName(container.getDestinationPortID());
		result = result +"\nCargo: "+container.getCargo();
		result = result +"\nInternal Status: "+getInternalStatus(container);
		String latitude = Float.toString(container.getCurrentPosition().getLatitude());
		String longitude = Float.toString(container.getCurrentPosition().getlongitude());
		result = result +"\nCurrent Location:"+"Latitude: "+latitude+" Longitude: "+longitude;
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


	public boolean updatePosition(String longitude, String latitude) {
		// TODO Auto-generated method stub
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
			UpdateLocation update = new UpdateLocation(lati, longit);
			return logistic.updateContainerInformation(update);
		}
		return false;
	}


	public boolean getClientByEmail(String searchEmail) {
		// TODO Auto-generated method stub
		optionEmail = new SearchByEmail(searchEmail);
		clients= logistic.search(optionEmail);
		if (clients.size()>0) {
			
			return true;
		}
		return false;
		
	}


	public boolean getClientByCompanyName(String searchName) {
		// TODO Auto-generated method stub
		optionName = new SearchByName(searchName);
		clients = logistic.search(optionName);
		if(clients.size()>0) {
			return true;
		}
		return false;
	}


	public boolean getClientByPhone(String phone) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		firstN = parseInput.parsingNames(text);
		
		middleN = parseInput.parsingNames(string);
		
		lastN = parseInput.parsingNames(text2);
		
		searchRefPerson = new ReferenceName(firstN, middleN, lastN);
		
		optionRefPerson = new SearchByReferencePerson(searchRefPerson);
		
		clients = logistic.search(optionRefPerson);
		if(clients.size()>0) {
			return true;
		}
		return false;
	}


	public String getclientsview() {
		// TODO Auto-generated method stub
		String result ="Displaying Up to most 3 Clients: ";
		int counter =0;
		for(int i=0;i<clients.size();i++) {
			result =result+clientDataToString(clients.get(i));
			counter++;
			if(counter>3) {
				break;
			}
		}
		return result;
	}
	private String clientDataToString(ClientData client) {
		String result ="\n";
		result = result +"\nClient ID: "+client.getID();
		result = result +"\nCompany Name: "+client.getCompanyName();
		result =result +"\nEmail: "+client.getEmail();
		result = result +"\nReference Person: "+arraylisttostring(client.getPerson().getFirstName())+arraylisttostring(client.getPerson().getMiddleName())+arraylisttostring(client.getPerson().getLastName());
		result = result +"\nPhone number: "+Integer.toString(client.getPhoneNumber().getCountryCode())+Long.toString(client.getPhoneNumber().getPhone());
		return result;
	}
	private String arraylisttostring(ArrayList<String> string) {
		String result="";
		for(int i=0;i<string.size();i++) {
			result = result +" "+ string.get(i);
		}
		return result;
	}
	
}
