package users;

import java.util.ArrayList;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.ElementNotFoundException;
import inputFromUsers.CurrentClientInput;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.ValidInput;

public class LogisticCompanyV2 extends User{
	private ValidInput validate;
	private CurrentClientInput input;// using this to set a new container 
	private boolean addNewClient;
	private boolean updatedLocation;
	public LogisticCompanyV2() {
	//	databaseContainer = new ContainerAccess();
	//	databaseClient = new ClientAccess();
		super();
		validate = new ValidInput();
		display = true;
		
	}
	
	public boolean getAddNewClient() {
		return addNewClient;
	}
	
	public boolean getUpdatedLocation() {
		return updatedLocation;
	}
	
	@Override
	public void displayContainerData(ContainerData container) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getContainerIsSet(long s) {
		try { //Edited by simon to fix compile errors. New exception to handle conflicting ids in insertion. Added code
			container = databaseContainer.getEntry(s); //Old code
			return true;
		} catch (NumberFormatException | ElementNotFoundException e) { //Added code
			System.out.println("Container not found");
			return false;
		}
	}
	


	public void setAddNewClient() {
		// TODO Auto-generated method stub
		this.addNewClient = false;
	}
	
	public void setUpdatedLocation() {
		// TODO Auto-generated method stub
		this.updatedLocation = false;
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

	public void updateLocation(float longitude, float latitude) {
		container.setCurrentPosition(latitude, longitude);
		this.updatedLocation = true;
	}

	


}
