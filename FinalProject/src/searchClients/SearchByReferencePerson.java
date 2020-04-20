package searchClients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		String fullName="";
		List<ClientData> firstClients;
		List<ClientData> middleClients;
		List<ClientData> lastClients;
		for(int i=0;i<referencePerson.getFirstName().size();i++) {
			fullName=fullName+referencePerson.getFirstName().get(i);
		};
		firstClients = databaseClient.searchEntries(fullName);
		fullName="";
		for(int i=0;i<referencePerson.getMiddleName().size();i++) {
			fullName=fullName+referencePerson.getMiddleName().get(i);
		};
		middleClients=databaseClient.searchEntries(fullName);
		fullName="";
		for(int i=0;i<referencePerson.getLastName().size();i++) {
			fullName=fullName+referencePerson.getLastName().get(i);
		};
		lastClients=databaseClient.searchEntries(fullName);
		Set<ClientData> hSet = new HashSet<ClientData>(); 
        for (ClientData x : firstClients ) {
        	hSet.add(x);
        }
        for (ClientData x : middleClients ) {
        	hSet.add(x);
        }
        for (ClientData x : lastClients ) {
        	hSet.add(x);
        }
        List<ClientData> finalresult = new ArrayList<ClientData>();
        for(ClientData x :hSet) {
        	finalresult.add(x);
        }
		return finalresult;
	}
	
}

