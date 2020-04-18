package users;

import java.util.ArrayList;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.ValidInput;

public class LogisticCompanyV2 extends User{
	private boolean addNewClient;
	private boolean updatedLocation;
	private boolean updatedStatus;
	public LogisticCompanyV2() {
	//	databaseContainer = new ContainerAccess();
	//	databaseClient = new ClientAccess();
		super();
		display = true;
		
	}
	
	public boolean getAddNewClient() {
		return addNewClient;
	}
	
	public boolean getUpdatedLocation() {
		return updatedLocation;
	}
	
	public boolean getUpdatedStatus() {
		return updatedStatus;
	}
	
	public boolean getContainerIsSet(long s) {
		try { 
			container = databaseContainer.getEntry(s); 
			return true;
		} catch (NumberFormatException | ElementNotFoundException e) { 
			System.out.println("Container not found");
			return false;
		}
	}
	


	public void setAddNewClient() {
		
		this.addNewClient = false;
	}
	
	public void setUpdatedLocation() {
		
		this.updatedLocation = false;
	}
	
	public void setUpdatedStatus() {
		
		this.updatedStatus = false;
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

	public void updateLocation(float longitude, float latitude) {
		container.setCurrentPosition(latitude, longitude);
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		this.updatedLocation = true;
	}

	public void updateStatus(float temp, float hum, float press) {
		container.setStatus(press, temp, hum);
		databaseContainer.editEntry(container);//-Mamuna added this
		databaseContainer.flushActiveData();//-Mamuna added this
		this.updatedStatus = true;
		
	}


	


}
