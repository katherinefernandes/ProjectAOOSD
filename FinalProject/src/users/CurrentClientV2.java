package users;

import java.util.ArrayList;
import java.util.List;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;
import objectsData.PortData;

public class CurrentClientV2 extends User{
	private boolean clientIsSet;
	private boolean updatedPhone;
	private boolean updatedEmail;
	private boolean updatedReferencePerson;
	

	public CurrentClientV2(long ID) {
		// TODO Auto-generated constructor stub
		databaseClient = new ClientAccess();
		databasePort = new PortAccess();
		try {
			client = databaseClient.getEntry(ID);
			clientIsSet = true;
		} catch (NumberFormatException | ElementNotFoundException e) {
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
	public void displayContainerData(ContainerData container) {
		// TODO Auto-generated method stub
		// this will send the container to a display which needs to be implemented.
		
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
		databaseClient.editEntry(client);
		this.updatedPhone=true;
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
		databaseClient.editEntry(client);
		this.updatedEmail=true;
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
		databaseClient.editEntry(client);
		this.updatedReferencePerson=true;
		
	}

	public long getPortID(String portname) {
		// TODO Auto-generated method 
		List<PortData> listOfPorts = databasePort.searchEntries(portname);
		if (listOfPorts.size()>0) {
			System.out.println(listOfPorts.get(0).getPortName());
			System.out.println(listOfPorts.get(0).getID());
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}

	

}
