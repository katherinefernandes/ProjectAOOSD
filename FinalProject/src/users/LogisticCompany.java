package users;
import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import objectsData.ClientData;
import supportingClasses.Security;
import supportingClasses.parseInput;
import supportingClasses.validInput; 

public class LogisticCompany {
	public void addClient () {
		Scanner s = new Scanner(System.in);
		
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
		
		//Check for valid input
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstNames, middleNames, lastNames, street, city, bNumber, zip);
		
		ClientAccess clientAccess = new ClientAccess();
		clientAccess.newEntry(newClient);
		s.close();
	}
	
	public void getInfoClient() {
		
	}
	
	public void updateContainer() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("ID of the container: ");
		String idc = s.nextLine();
		
		System.out.println("New longitude: ");
		float lon = s.nextLine();
		
		System.out.println("New latitude: ");
		float lat = s.nextLine();
		
		System.out.println("Atmosphere: ");
		String atm = s.nextLine();
		
		System.out.println("Humidity: ");
		String hum = s.nextLine();
		
		System.out.println("Temperature: ");
		String temp = s.nextLine();
		
		
		
		s.close();
	}
	
	public void getInfoContainer() {
		
	}
}
