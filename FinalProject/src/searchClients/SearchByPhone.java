package searchClients;

import java.util.List;

import objectsData.ClientData;
import xmlParser.ClientXMLManipulation;

public class SearchByPhone implements SearchClients{
	private ClientXMLManipulation databaseClient;
	private String phone;
	
	
	public SearchByPhone(long phone) {
		databaseClient = new ClientXMLManipulation();
		this.phone = Long.toString(phone);
	}
	
	@Override
	public List<ClientData> getClients() {
		return databaseClient.searchEntries(phone);
	}
	
}
