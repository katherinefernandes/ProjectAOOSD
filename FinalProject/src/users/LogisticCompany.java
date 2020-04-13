package users;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import inputFromUsers.CurrentClientInput;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.Security;
import supportingClasses.parseInput;
import supportingClasses.ValidInput; 

public class LogisticCompany extends User{// Mamuna I have created a User class which will contain abstract methods or common methods such has getinformationclient or getinformationjourney
	private ContainerData container;
	private ContainerAccess databaseContainer;
	private ValidInput validate;
	private CurrentClientInput input;// using this to set a new container 
	public LogisticCompany() {
		databaseContainer = new ContainerAccess();
		validate = new ValidInput();
		display = true;
	}
	
	public void addClient (Scanner s) {
		
		
		System.out.println("Company name: ");
		String name = "";
		while(name.length() == 0) {
			name = s.nextLine();
		}
	
		System.out.println("E-mail: ");
		String email = s.nextLine();
		
		while (validate.validateEmail(email) != true) {
			System.out.println("Invalid E-mail, enter again: ");
			email = s.nextLine();
		}
		
		System.out.println("Country code: ");
		int countryCode = s.nextInt();
		
		while (validate.validateCountryCode(countryCode) != true) {
			System.out.println("Invalid country code, enter again: ");
			countryCode = s.nextInt();
		}
		
		
		System.out.println("Phone number: ");
		long phone = s.nextLong();
		
		
		while (validate.validatePhone(phone) != true) {
			System.out.println("Invalid phone, enter again: ");
			phone = s.nextLong();
		}
		
		
		System.out.println("Reference person ");
		System.out.println("First name: ");
	
		String firstName = s.nextLine();
		while(firstName.length() == 0) {
			firstName = s.nextLine(); //toavoid that error of invalid when no name is actually entered. -mamuna
		}
		while (validate.validateName(firstName) != true) {
			System.out.println("Invalid name, enter again: ");
			firstName = s.nextLine();
		}
		
		ArrayList<String> firstNames = parseInput.parsingNames(firstName);

		
		System.out.println("Middle name: ");
		String middleName = s.nextLine();
		
		while (validate.validateName(middleName) != true) {
			if (middleName.length() == 0) {
				break;
			}
			else {
				System.out.println("Invalid name, enter again: ");
				middleName = s.nextLine();
			}
		}
		
		ArrayList<String> middleNames = parseInput.parsingNames(middleName);
		
		System.out.println("Last name: ");
		String lastName = s.nextLine();
		while(lastName.length() == 0) {//newcode-mamuna
			lastName = s.nextLine(); 
		}
		
		while (validate.validateName(lastName) != true) {
			System.out.println("Invalid name, enter again: ");
			lastName = s.nextLine();
		}
		
		ArrayList<String> lastNames = parseInput.parsingNames(lastName);
		System.out.println("Street: ");
		String street = s.nextLine();
		while(street.length() == 0) { //newcodemamuna
			street = s.nextLine();
		}
		
		while (validate.validateStreet(street) != true) {
			System.out.println("Invalid street, enter again: ");
			street = s.nextLine();
		}
		
		System.out.println("City: ");
		String city = s.nextLine();
		while(city.length() == 0) {
			city = s.nextLine(); //newcode-mamuna
		}
		
		while (validate.validateName(city) != true) {
			System.out.println("Invalid city, enter again: ");
			city = s.nextLine();
		}
		
		System.out.println("Building number: ");
		int bNumber = s.nextInt();
		
		System.out.println("Post code: ");
		String zip = s.nextLine();
		while(zip.length() == 0) {
			zip = s.nextLine(); //newcode mamuna
		}
		
		while (validate.validatePostCode(zip) != true) {
			System.out.println("Invalid post code, enter again: ");
			zip = s.nextLine();
		}
		
		//Dani changed this:
		long id = ssecurity.generateID();
		//this id needs to be saved into a file Daniela and Muna (ssecurity because java confuses it to the inbuilt security)
		ssecurity.saveClientID(id);
		
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstNames, middleNames, lastNames, street, city, bNumber, zip);
		
		ClientAccess clientAccess = new ClientAccess();
		try { //Try-catch added by Simon to avoid compile errors. Changed because I added an error when you try to add client with same ID two times. Added code
			
			clientAccess.newEntry(newClient);//Old code
			System.out.println("This is your ID:" + id);;
			
		} catch (AmbiguousElementSelectionException e) { //Added code
			e.printStackTrace(); } //Added code
		
	}
	
//	public void getInfoClient(Scanner s) {
////		while (true)  {
////			System.out.println("Please enter your valid clientID");
////			long clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatedly try to get the correct value
////			try {
////				client = databaseClient.getEntry(clientID);
////				break;
////			} catch (NumberFormatException | ElementNotFoundException | AmbiguousElementSelectionException e) {
////				// TODO Auto-generated catch block
////				System.out.println("Element not found");
////			}
////			
////		}
//	}
	//
	public void updateContainer(Scanner s) {
		int choice;
		boolean initialize = true;
		//getInfoContainer(s); // mamuna: replacing this code by another which will update the container...
		container = input.getContainerData(s);
		displayContainerData(container);
		while (initialize) {
			System.out.println("Please enter the following numbers: \n\t1 ---------- to update the position \n\t2 ---------- to update the status \n\t3 ---------- quit ");
			
			choice = s.nextInt();
			
			switch (choice) {
			case 1: 
				System.out.println("New longitude: ");
				float lon = s.nextFloat();
				
				System.out.println("New latitude: ");
				float lat = s.nextFloat();
				
				
				container.setCurrentPosition(lat, lon);
				break;
			
			case 2:
				System.out.println("Atmosphere: ");
				float atm = s.nextFloat();
				
				System.out.println("Humidity: ");
				float hum = s.nextFloat();
				
				System.out.println("Temperature: ");
				float temp = s.nextFloat();
				
				
				container.setStatus(atm, temp, hum);
				break;
			
			case 3:
				initialize = false;
				
				break;
			default: System.out.println("Please try again, enter the correct number.");
			
			}
		
		}
		
		
		try {
			databaseContainer.editEntry(container);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}

	}
	
	/*public void getInfoContainer(Scanner s) {//commenting out this function by mamuna
		while(true) {
			System.out.println("ID of the container: ");
			long idc = s.nextLong();
			
			
			try {
				container = databaseContainer.getEntry(idc); 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
				System.out.println("This is the container ID: " + idc);
				System.out.println("Cargo: " + container.getCargo());
				System.out.println("It is located at latitude " + container.getCurrentPosition().getLatitude());
				System.out.println("and longitude " + container.getCurrentPosition().getlongitude());
				System.out.println("The internal atmosphere is:  "+container.getInternalStatus().getAtmosphere());
				System.out.println("The internal Temperature is:  "+ container.getInternalStatus().getTemperature());
				System.out.println("The internal Humidity is:  "+container.getInternalStatus().getHumidity());
				System.out.println("Last updated: " + container.getUpdated().format(formatter ));
				System.out.println("Arriving by: " + container.getArriveBy().format(formatter));
				return;
			} catch (NumberFormatException | ElementNotFoundException | AmbiguousElementSelectionException e) {
				System.out.println("Element not found");
			}
			
			
		}
	}*/

	@Override
	public void displayContainerData(ContainerData container) { //mamuna added this to distinguish between input and logic and to reduce code
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println("This is the container ID: " + container.getContainerID());
		System.out.println("Cargo: " + container.getCargo());
		System.out.println("It is located at latitude " + container.getCurrentPosition().getLatitude());
		System.out.println("and longitude " + container.getCurrentPosition().getlongitude());
		System.out.println("The internal atmosphere is:  "+container.getInternalStatus().getAtmosphere());
		System.out.println("The internal Temperature is:  "+ container.getInternalStatus().getTemperature());
		System.out.println("The internal Humidity is:  "+container.getInternalStatus().getHumidity());
		System.out.println("Last updated: " + container.getUpdated().format(formatter ));
		System.out.println("Arriving by: " + container.getArriveBy().format(formatter));
		
	}
}
