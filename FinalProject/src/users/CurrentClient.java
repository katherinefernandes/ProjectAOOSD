package users;

import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ElementNotFoundException;
import objectsData.ClientData;

public class CurrentClient {
	private ClientData client;
	private Scanner s;
	private Long clientID;
	private ClientAccess database;
	private boolean display=true;
	private int choice;
	
	public void getInfoClient(){
			
		s = new Scanner (System.in);
		System.out.println("Please enter your valid clientID");
		clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatdly try to get the correct value
		try {
			client = database.getEntry(clientID);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (display) {
			displayClientInfo();
		}
	}
	private String infoClient() {
		return "\nClient Name is: \t"+client.getCompanyName()+"\nClient Phone number is: \t"+client.getPhoneNumber()+"\nClient email is: \t"+client.getEmail()+"\nClient reference person is: \t"+client.getPerson().getFirstName()+" "+client.getPerson().getMiddleName()+" "+client.getPerson().getLastName();
	}

	private void displayClientInfo() {
		System.out.println(infoClient());
		}
	
	private void updateReferencePerson() {
		
		s = new Scanner (System.in);
		System.out.println("Enter the first name of the person: ");
		ArrayList<String> firstname = new ArrayList<String>();
		firstname.add(s.next());
		System.out.println("Enter the middle names of the person: ");
		ArrayList<String> middlename = new ArrayList<String>();
		middlename.add( s.next());// assuming that only 1 name is entered.
		System.out.println("Enter the last name of the person: ");
		ArrayList<String> lastname = new ArrayList<String>();
		lastname.add(s.next());
		client.setPerson(firstname, middlename, lastname);
	}
	
	private void updateEmail() {
		s = new Scanner (System.in);
		System.out.println("Enter the new email: ");
		String email= s.next();
		client.setEmail(email);
	}
	
	public void updateInfoClient(){
		display=false;
		getInfoClient();
		while (true) {
			System.out.println("Please enter the following numbers: \n\t1 ---------- to update the Reference person \n\t2 ---------- to update the Email");
			choice = s.nextInt();
			if (choice==1||choice==2) {
				break;
			}
			System.out.println("Please try again, enter the correct number.");
		}
		switch (choice) {
		case 1: updateReferencePerson();break;
		case 2: updateEmail(); break;
		}
		display=true;
		try {
			database.editEntry(client);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
