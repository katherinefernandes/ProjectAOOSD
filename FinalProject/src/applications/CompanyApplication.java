package applications;

import java.util.ArrayList;
import java.util.List;

import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import searchClients.SearchClients;
import updateContainer.UpdateContainer;

public class CompanyApplication extends Application{
	private boolean addNewClient;
	public CompanyApplication() {
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
		
		
		ClientData newClient = new ClientData(id, name, countryCode, phone, email, firstName, middleName, lastName, street, city, houseNumber, postCode);
		
		databaseClient.newEntry(newClient);
		
		databaseClient.flushActiveData();
		
		this.addNewClient = true;
		
		return id;
	}

	
	public boolean updateContainerInformation(UpdateContainer Update) {
		Update.updateInformation(container);
		return Update.updated();
	}

	public List<ClientData> search(SearchClients option){
		return option.getClients();
	}

}
