package users;

import java.util.Scanner;

import dataAccess.ClientAccess;
import objectsData.ClientData;

public class CurrentClient {
	private ClientData client;
	private Scanner s;
	private Long clientID;
	private ClientAccess database;
	private boolean display=true;
	private int choice;
	public void getInfoClient() {
			
		s = new Scanner (System.in);
		System.out.println("Please enter your valid clientID");
		clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatdly try to get the correct value
		client = database.getEntry(clientID);
		if (display) {
			displayClientInfo();
		}
	}

	private void displayClientInfo() {
		System.out.println("Client Name is: \n"+client.getCompanyName());
		System.out.println("Client Phone number is: \n"+client.getPhoneNumber());
		System.out.println("Client email is: \n"+client.getEmail());
		System.out.println("Client reference person is: \n"+client.getPerson().getFirstName()+" "+client.getPerson().getMiddleName()+" "+client.getPerson().getLastName());
	}
	
	private void updateReferencePerson() {
		
	}
	
	private void updateEmail() {
		
	}
	
	public void updateInfoClient() {
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
	}
	
	
}
