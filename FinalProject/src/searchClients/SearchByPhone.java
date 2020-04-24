package searchClients;

import java.util.List;

import XMLParser.ClientAccess;
import objectsData.ClientData;

public class SearchByPhone implements SearchClients{
	private ClientAccess databaseClient;
	private String phone;
	
	
	public SearchByPhone(long phone) {
		databaseClient = new ClientAccess();
		this.phone = Long.toString(phone);
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(phone);
	}
	
}
