package searchClients;

import java.util.List;

import dataAccess.ClientAccess;
import objectsData.ClientData;
import objectsData.ReferenceName;

public class SearchByReferencePerson implements SearchClients{
	private ClientAccess databaseClient;
	private ReferenceName referencePerson;
	
	
	public SearchByReferencePerson(ReferenceName referencePerson) {
		databaseClient = new ClientAccess();
		this.referencePerson = referencePerson;
	}
	
	@Override
	public List<ClientData> getClients() {
		String fullName = referencePerson.getFirstName().toString() +
				 referencePerson.getMiddleName().toString() +
				 referencePerson.getLastName().toString();
		return databaseClient.searchEntries(fullName);
	}
	
}

