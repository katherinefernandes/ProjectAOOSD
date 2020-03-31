package users;
import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.Security;
import supportingClasses.parseInput;
import supportingClasses.ValidInput; 

public class LogisticCompany {
	private ContainerData container;
	private ContainerAccess databaseContainer;
	
	public LogisticCompany() {
		databaseContainer = new ContainerAccess();
	}
	
	public void addClient (Scanner s) {
		
		
		System.out.println("Company name: ");
		String name = "";
		while(name.length() == 0) {
			name = s.nextLine();
		}
		
		System.out.println("E-mail: ");
		String email = s.nextLine();
		
		while (new ValidInput().validateEmail(email) != true) {
			System.out.println("Invalid E-mail, enter again: ");
			email = s.nextLine();
		}
		
		System.out.println("Country code: ");
		int countryCode = s.nextInt();
		
		while (new ValidInput().validateCountryCode(countryCode) != true) {
			System.out.println("Invalid country code, enter again: ");
			countryCode = s.nextInt();
		}
		
		
		System.out.println("Phone number: ");
		long phone = s.nextLong();
		
		
		while (new ValidInput().validatePhone(phone) != true) {
			System.out.println("Invalid phone, enter again: ");
			phone = s.nextLong();
		}
		
		
		System.out.println("Reference person ");
		System.out.println("First name: ");
		String firstName = s.nextLine();
		
		while (new ValidInput().validateName(firstName) != true) {
			System.out.println("Invalid name, enter again: ");
			firstName = s.nextLine();
		}
		
		ArrayList<String> firstNames = parseInput.parsingNames(firstName);

		
		System.out.println("Middle name: ");
		String middleName = s.nextLine();
		
		while (new ValidInput().validateName(middleName) != true) {
			System.out.println("Invalid name, enter again: ");
			middleName = s.nextLine();
		}
		
		ArrayList<String> middleNames = parseInput.parsingNames(middleName);
		
		System.out.println("Last name: ");
		String lastName = s.nextLine();
		
		while (new ValidInput().validateName(lastName) != true) {
			System.out.println("Invalid name, enter again: ");
			lastName = s.nextLine();
		}
		
		ArrayList<String> lastNames = parseInput.parsingNames(lastName);
		System.out.println("Street: ");
		String street = s.nextLine();
		
		while (new ValidInput().validateStreet(street) != true) {
			System.out.println("Invalid street, enter again: ");
			street = s.nextLine();
		}
		
		System.out.println("City: ");
		String city = s.nextLine();
		
		while (new ValidInput().validateName(city) != true) {
			System.out.println("Invalid city, enter again: ");
			city = s.nextLine();
		}
		
		System.out.println("Building number: ");
		int bNumber = s.nextInt();
		
		System.out.println("Post code: ");
		String zip = s.nextLine();
		
		while (new ValidInput().validatePostCode(zip) != true) {
			System.out.println("Invalid post code, enter again: ");
			zip = s.nextLine();
		}
		
		
		long id = new Security().generateID();
		
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
	
	public void updateContainer(Scanner s) {
		
		getInfoContainer(s);
		
		System.out.println("New longitude: ");
		float lon = s.nextFloat();
		
		System.out.println("New latitude: ");
		float lat = s.nextFloat();
		
		
		container.setCurrentPosition(lat, lon);
		
		
		System.out.println("Atmosphere: ");
		float atm = s.nextFloat();
		
		System.out.println("Humidity: ");
		float hum = s.nextFloat();
		
		System.out.println("Temperature: ");
		float temp = s.nextFloat();
		
		
		container.setStatus(atm, temp, hum);
		
		try {
			databaseContainer.editEntry(container);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
		}

	}
	
	public void getInfoContainer(Scanner s) {
		//throw an exception when it is not found 
		while(true) {
			System.out.println("ID of the container: ");
			long idc = s.nextLong();
			
			
			try {//Edited by simon to fix compile errors. New exception to handle conflicting ids in insertion. Added code
				container = databaseContainer.getEntry(idc); //Old code
				System.out.println("Found but not printed");
				return;
			} catch (NumberFormatException | ElementNotFoundException | AmbiguousElementSelectionException e) {//Added code
				System.out.println("Element not found");
			}
		}
	}
}
