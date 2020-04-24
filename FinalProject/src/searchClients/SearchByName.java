package searchClients;

import java.util.List;

import XMLParser.ClientAccess;
import objectsData.ClientData;

public class SearchByName implements SearchClients{
	private ClientAccess databaseClient;
	private String name;
	
	
	public SearchByName(String name) {
		databaseClient = new ClientAccess();
		this.name = name;
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(name);
	}
	
}
