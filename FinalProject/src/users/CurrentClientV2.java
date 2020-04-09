package users;

import java.util.ArrayList;

import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;

public class CurrentClientV2 extends User{
	private boolean clientIsSet;
	private boolean updatedPhone;
	private boolean updatedEmail;
	private boolean updatedReferencePerson;
	

	public CurrentClientV2(long ID) {
		// TODO Auto-generated constructor stub
		databaseClient = new ClientAccess();
		try {
			client = databaseClient.getEntry(ID);
			clientIsSet = true;
		} catch (NumberFormatException | ElementNotFoundException| AmbiguousElementSelectionException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
			clientIsSet = false;
		}
		this.display=false;
	}
	
	public boolean getClientIsSet() {
		return this.clientIsSet;
	}

	@Override
	public void viewInternalStatusOfAJourney(ContainerData container) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean viewClient() {
		if (display) {
			viewClient(client);
			return true;
		}
		return false;
	}

	public boolean getViewClient() {
		// TODO Auto-generated method stub
		return this.display;
	}

	public void setViewClient(boolean changeDisplay) {
		// TODO Auto-generated method stub
		this.display=changeDisplay;
	}

	

	public void updatePhone() {
		// TODO Auto-generated method stub
		this.updatedPhone =false;
	}

	public boolean getUpdatedPhone() {
		// TODO Auto-generated method stub
		return this.updatedPhone;
	}

	public void updateClientInformation(int countryCode, long phone) {
		// TODO Auto-generated method stub
		this.client.setPhoneNumber(countryCode, phone);
		try {
			databaseClient.editEntry(client);
			this.updatedPhone=true;
		} catch (ElementNotFoundException e) {
			throw new Error(e);// as the client entry can never be deleted from xml unless there is a new feature that does that then we need a new/better way to fix this
		}
	}

	public void updateEmail() {
		// TODO Auto-generated method stub
		this.updatedEmail=false;
	}

	public boolean getUpdatedEmail() {
		// TODO Auto-generated method stub
		return this.updatedEmail;
	}

	public void updateClientInformation(String email) {
		// TODO Auto-generated method stub
		this.client.setEmail(email);
		try {
			databaseClient.editEntry(client);
			this.updatedEmail=true;
		} catch (ElementNotFoundException e) {
			System.out.println("Client can't be edited for some weird reason, check if client still exists in database");
		}
	}

	public void updateReferencePerson() {
		// TODO Auto-generated method stub
		this.updatedReferencePerson =false;
	}

	public boolean getUpdatedReferencePerson() {
		// TODO Auto-generated method stub
		return this.updatedReferencePerson;
	}

	public void updateClientInformation(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		// TODO Auto-generated method stub
		this.client.setPerson(firstName, middleName, lastName);
		try {
			databaseClient.editEntry(client);
			this.updatedReferencePerson=true;
		} catch (ElementNotFoundException e) {
			System.out.println("Client can't be edited for some weird reason, check if client still exists in database");
		}
		
	}
	

}
