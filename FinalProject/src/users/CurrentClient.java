package users;

import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;

public class CurrentClient {
	private ClientData client;
	private Scanner s = new Scanner (System.in);
	private Long clientID;
	private ClientAccess database;
	private boolean display=true;
	private int choice;
	
	public void getInfoClient(){
		getIDByUserInput(); //gets the ID by the user and updated the client with a clientData object
		if (display) {
			displayClientInfo(infoClient());
		}
	}
	private void getIDByUserInput() {
		while(true) {
			try {
				System.out.println("Please enter your valid clientID");
				clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatedly try to get the correct value
				client = database.getEntry(clientID);
				break;
			} catch (ElementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Invalid ID, please try again.");	
			}
		}
	}
	private String infoClient() {
		return "\nClient Name is: \t"+client.getCompanyName()+"\nClient Phone number is: \t"+client.getPhoneNumber()+"\nClient email is: \t"+client.getEmail()+"\nClient reference person is: \t"+client.getPerson().getFirstName()+" "+client.getPerson().getMiddleName()+" "+client.getPerson().getLastName();
	}

	private void displayClientInfo(String info) {
		System.out.println(info);
		}
	
	private void updateReferencePerson() {
		client.setPerson(getFirstName(), getMiddleName(), getLastName());
	}
	//for all the methods get_name, need to make sure that the input is valid and the person could add more than one name
	private ArrayList<String> getLastName() {
		System.out.println("Enter the last name of the person: ");
		ArrayList<String> lastname = new ArrayList<String>();
		lastname.add(s.next());
		return lastname;
	}
	private ArrayList<String> getMiddleName() {
		System.out.println("Enter the middle names of the person: ");
		ArrayList<String> middlename = new ArrayList<String>();
		middlename.add( s.next());// assuming that only 1 name is entered.
		return middlename;
	}
	private ArrayList<String> getFirstName() {
		System.out.println("Enter the first name of the person: ");
		ArrayList<String> firstname = new ArrayList<String>();
		firstname.add(s.next());
		return firstname;
	}
	
	private void updateEmail(String email) {
		client.setEmail(email);
	}
	private String inputForUpdateEmail() {
		s = new Scanner (System.in);
		System.out.println("Enter the new email: ");
		String email= s.next();
		return email;
	}
	
	public void updateInfoClient(){
		display=false;
		getInfoClient();
		switch (getChoiceForUpdateClient()) {
		case 1: updateReferencePerson();break;
		case 2: updateEmail(inputForUpdateEmail()); break;
		}
		display=true;
		try {
			database.editEntry(client);
		} catch (ElementNotFoundException e) {
			e.printStackTrace(); //find a better way to fix this
			System.out.println("Client can't be edited for some weird reason");
		}
	}
	private int getChoiceForUpdateClient() {
		while (true) {
			System.out.println("Please enter the following numbers: \n\t1 ---------- to update the Reference person \n\t2 ---------- to update the Email");
			choice = s.nextInt();
			if (choice==1||choice==2) {
				break;
			}
			System.out.println("Please try again, enter the correct number.");
		}
		return choice;
	}
	
	
}
