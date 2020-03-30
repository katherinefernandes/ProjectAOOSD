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
import supportingClasses.validInput; 

public class LogisticCompany {
	private ContainerData container;
	private ContainerAccess databaseContainer;
	private ClientData client;
	private ClientAccess databaseClient;
	
	private Scanner s = new Scanner(System.in);
	public void addClient () {
		
		
		System.out.println("Company name: ");
		String name = s.nextLine();
		
		System.out.println("E-mail: ");
		String email = s.nextLine();
		
		while (validInput.validateEmail(email) != true) {
			System.out.println("Invalid E-mail, enter again: ");
			email = s.nextLine();
		}
		
		System.out.println("Country code: ");
		int countryCode = s.nextInt();
		
		while (validInput.validateCountryCode(countryCode) != true) {
			System.out.println("Invalid country code, enter again: ");
			countryCode = s.nextInt();
		}
		
		
		System.out.println("Phone number: ");
		long phone = s.nextLong();
		
		
		while (validInput.validatePhone(phone) != true) {
			System.out.println("Invalid phone, enter again: ");
			phone = s.nextLong();
		}
		
		
		System.out.println("Reference person ");
		System.out.println("First name: ");
		String firstName = s.nextLine();
		
		while (validInput.validateName(firstName) != true) {
			System.out.println("Invalid name, enter again: ");
			firstName = s.nextLine();
		}
		
		ArrayList<String> firstNames = parseInput.parsingNames(firstName);

		
		System.out.println("Middle name: ");
		String middleName = s.nextLine();
		
		while (validInput.validateName(middleName) != true) {
			System.out.println("Invalid name, enter again: ");
			middleName = s.nextLine();
		}
		
		ArrayList<String> middleNames = parseInput.parsingNames(middleName);
		
		System.out.println("Last name: ");
		String lastName = s.nextLine();
		
		while (validInput.validateName(lastName) != true) {
			System.out.println("Invalid name, enter again: ");
			lastName = s.nextLine();
		}
		
		ArrayList<String> lastNames = parseInput.parsingNames(lastName);
		System.out.println("Street: ");
		String street = s.nextLine();
		
		while (validInput.validateStreet(street) != true) {
			System.out.println("Invalid street, enter again: ");
			street = s.nextLine();
		}
		
		System.out.println("City: ");
		String city = s.nextLine();
		
		while (validInput.validateName(city) != true) {
			System.out.println("Invalid city, enter again: ");
			city = s.nextLine();
		}
		
		System.out.println("Building number: ");
		int bNumber = s.nextInt();
		
		System.out.println("Post code: ");
		String zip = s.nextLine();
		
		while (validInput.validatePostCode(zip) != true) {
			System.out.println("Invalid post code, enter again: ");
			zip = s.nextLine();
		}
		
		
		long id = new Security().generateID();
		
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstNames, middleNames, lastNames, street, city, bNumber, zip);
		
		ClientAccess clientAccess = new ClientAccess();
		try { //Try-catch added by Simon to avoid compile errors. Changed because I added an error when you try to add client with same ID two times. Added code
			
			clientAccess.newEntry(newClient);//Old code
			
		} catch (AmbiguousElementSelectionException e) { //Added code
			e.printStackTrace(); } //Added code
		
	}
	
	public void getInfoClient() {
		while (true)  {
			try {
				System.out.println("Please enter your valid clientID");
				long clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatedly try to get the correct value
				try {
					client = databaseClient.getEntry(clientID);
				} catch (NumberFormatException | AmbiguousElementSelectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} catch (ElementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Invalid ID, please try again.");	
			}
		}
	}
	
	public void updateContainer() {
		
		getInfoContainer();
		
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
		

	}
	
	public void getInfoContainer() {
		//throw an exception when it is not found 
		System.out.println("ID of the container: ");
		long idc = s.nextLong();
		
		
		try {//Edited by simon to fix compile errors. New exception to handle conflicting ids in insertion. Added code
			container = databaseContainer.getEntry(idc); //Old code
		} catch (NumberFormatException | ElementNotFoundException | AmbiguousElementSelectionException e) {//Added code
			e.printStackTrace(); //Added code
		}
		
	}
}
