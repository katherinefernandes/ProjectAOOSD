package searchClients;

import java.util.List;

import objectsData.ClientData;
import xmlParser.ClientXMLManipulation;

public class SearchByEmail implements SearchClients{
	private ClientXMLManipulation databaseClient;
	private String email;
	
	
	public SearchByEmail(String email) {
		databaseClient = new ClientXMLManipulation();
		this.email = email;
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(email);
	}
	
}
