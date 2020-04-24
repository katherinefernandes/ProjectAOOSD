package searchClients;

import java.util.List;

import objectsData.ClientData;
import xmlParser.ClientXMLManipulation;

public class SearchByName implements SearchClients{
	private ClientXMLManipulation databaseClient;
	private String name;
	
	
	public SearchByName(String name) {
		databaseClient = new ClientXMLManipulation();
		this.name = name;
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(name);
	}
	
}
