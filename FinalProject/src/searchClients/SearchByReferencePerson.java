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
		String firstName="";
		String middleName="";
		String lastName ="";
		List<ClientData> firstClients;
		List<ClientData> middleClients;
		List<ClientData> lastClients;
		for(int i=0;i<referencePerson.getFirstName().size();i++) {
			firstName=firstName+referencePerson.getFirstName().get(i);
		};
		firstClients = databaseClient.searchEntries(firstName);
		for(int i=0;i<referencePerson.getMiddleName().size();i++) {
			middleName=middleName+referencePerson.getMiddleName().get(i);
		};
		middleClients=databaseClient.searchEntries(middleName);
		for(int i=0;i<referencePerson.getLastName().size();i++) {
			lastName=lastName+referencePerson.getLastName().get(i);
		};
		
		lastClients=databaseClient.searchEntries(lastName);
		Set<ClientData> hSet = new HashSet<ClientData>(); 
        for (ClientData x : firstClients ) {
        	if(x.getPerson().getMiddleName().contains(middleName)&&x.getPerson().getLastName().contains(lastName)) {
        		hSet.add(x);
        	}
        }
        for (ClientData x : middleClients ) {
        	if(x.getPerson().getFirstName().contains(firstName)&&x.getPerson().getLastName().contains(lastName)) {
        		hSet.add(x);
        	}
        }
        for (ClientData x : lastClients ) {
        	if(x.getPerson().getFirstName().contains(firstName)&&x.getPerson().getMiddleName().contains(middleName)) {
        		hSet.add(x);
        	}
        }
        List<ClientData> finalresult = new ArrayList<ClientData>();
        for(ClientData x :hSet) {
        	finalresult.add(x);}
        
        return finalresult;
	}
	
}

