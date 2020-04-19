package searchClients;

import java.util.List;

import dataAccess.ClientAccess;
import objectsData.ClientData;

public class SearchByEmail implements SearchClients{
	private ClientAccess databaseClient;
	private String email;
	
	
	public SearchByEmail(String email) {
		databaseClient = new ClientAccess();
		this.email = email;
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(email);
	}
	
}
