package users;

import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;

public class CurrentClientV2 extends User{
	private boolean clientIsSet;
	

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

}
