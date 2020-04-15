package users;

import java.util.ArrayList;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import inputFromUsers.CurrentClientInput;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.ValidInput;

public class LogisticCompanyV2 extends User{
	private ContainerData container;
	private ContainerAccess databaseContainer;
	private ValidInput validate;
	private CurrentClientInput input;// using this to set a new container 
	private boolean addNewClient;
	public LogisticCompanyV2() {
		databaseContainer = new ContainerAccess();
		databaseClient = new ClientAccess();
		validate = new ValidInput();
		display = true;
	}
	
	public boolean getAddNewClient() {
		return addNewClient;
	}
	
	@Override
	public void displayContainerData(ContainerData container) {
		// TODO Auto-generated method stub
		
	}


	public void setAddNewClient() {
		// TODO Auto-generated method stub
		this.addNewClient = false;
	}

	public long addClient(String email, String name, int countryCode, long phone, ArrayList<String> firstName,
			ArrayList<String> middleName, ArrayList<String> lastName, String street, String city, String postCode,
			int houseNumber) {
		// TODO Auto-generated method stub
		long id = ssecurity.generateID();
		
		ssecurity.saveClientID(id);
		
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstName, middleName, lastName, street, city, houseNumber, postCode);
		
		databaseClient.newEntry(newClient);
		
		databaseClient.flushActiveData();
		
		this.addNewClient = true;
		
		return id;
	}
}
