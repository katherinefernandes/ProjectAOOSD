package users;

import java.util.ArrayList;

import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import updateContainer.UpdateContainer;

public class LogisticCompanyV2 extends User{
	private boolean addNewClient;
	public LogisticCompanyV2() {
		super();
		
	}
	
	public boolean getAddNewClient() {
		return addNewClient;
	}
	

	public void setAddNewClient() {
		
		this.addNewClient = false;
	}
	

	
	public long addClient(String email, String name, int countryCode, long phone, ArrayList<String> firstName,
			ArrayList<String> middleName, ArrayList<String> lastName, String street, String city, String postCode,
			int houseNumber) {
		
		long id = ssecurity.generateID();
		
		ssecurity.saveClientID(id);
		
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstName, middleName, lastName, street, city, houseNumber, postCode);
		
		databaseClient.newEntry(newClient);
		
		databaseClient.flushActiveData();
		
		this.addNewClient = true;
		
		return id;
	}

	
	public boolean updateContainerInformation(UpdateContainer Update) {
		// TODO Auto-generated method stub
		Update.updateInformation(container);
		return Update.updated();
	}


}
