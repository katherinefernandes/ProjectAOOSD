package users;
import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import objectsData.ClientData;
import supportingClasses.Security; 

public class LogisticCompany {
	public void addClient () {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Company name: ");
		String name = s.nextLine();
		
		System.out.println("E-mail: ");
		String email = s.nextLine();
		
		System.out.println("Country code: ");
		int countryCode = s.nextInt();
		
		System.out.println("Phone number: ");
		int phone = s.nextInt();
		
		ArrayList<String> firstNames = new ArrayList<String>();
		ArrayList<String> middleNames = new ArrayList<String>();
		ArrayList<String> lastNames = new ArrayList<String>();
		
		System.out.println("Reference person ");
		System.out.println("First name: ");
		String firstName = s.nextLine();
		firstNames.add(firstName);
		
		System.out.println("Middle name: ");
		String middleName = s.nextLine();
		firstNames.add(middleName);
		
		System.out.println("Last name: ");
		String lastName = s.nextLine();
		lastNames.add(lastName);
		
		System.out.println("Street: ");
		String street = s.nextLine();
		
		System.out.println("City: ");
		String city = s.nextLine();
		
		System.out.println("Building number: ");
		int bNumber = s.nextInt();
		
		System.out.println("Post code: ");
		String zip = s.nextLine();
		
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
		String lon = s.nextLine();
		
		System.out.println("New latitude: ");
		String lat = s.nextLine();
		
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
