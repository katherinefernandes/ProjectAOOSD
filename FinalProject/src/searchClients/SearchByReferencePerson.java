package searchClients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import objectsData.ClientData;
import objectsData.ReferenceName;
import xmlParser.ClientXMLManipulation;

public class SearchByReferencePerson implements SearchClients{
	private ClientXMLManipulation databaseClient;
	private ReferenceName referencePerson;
	
	
	public SearchByReferencePerson(ReferenceName referencePerson) {
		databaseClient = new ClientXMLManipulation();
		this.referencePerson = referencePerson;
	}
	
	@Override
	public List<ClientData> getClients() {
		String firstName="";
		String middleName="";
		String lastName ="";
		List<ClientData> firstClients;
		for(int i=0;i<referencePerson.getFirstName().size();i++) {
			firstName=firstName+referencePerson.getFirstName().get(i);
		};
		firstClients = databaseClient.searchEntries(firstName);
		for(int i=0;i<referencePerson.getMiddleName().size();i++) {
			middleName=middleName+referencePerson.getMiddleName().get(i);
		};
		for(int i=0;i<referencePerson.getLastName().size();i++) {
			lastName=lastName+referencePerson.getLastName().get(i);
		};
		Set<ClientData> hSet = new HashSet<ClientData>(); 
        for (ClientData x : firstClients ) {
        	
        	if(x.getPerson().getMiddleName().size()==middleName.length()&&x.getPerson().getLastName().contains(lastName)) {
        		hSet.add(x);
        	}
        }
       
        List<ClientData> finalresult = new ArrayList<ClientData>();
        for(ClientData x :hSet) {
        	finalresult.add(x);}
        
        return finalresult;
	}
	
}

