package searchClients;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import businessObjects.Client;
import dataBase.DataBase;
import dataWrappers.ReferenceName;

public class SearchByReferencePerson implements SearchClients{
	private ReferenceName referencePerson;
	
	
	public SearchByReferencePerson(ReferenceName referencePerson) {
		this.referencePerson = referencePerson;
	}
	
	@Override
	public List<Client> getClients() {
		String firstName="";
		String middleName="";
		String lastName ="";
		List<Client> firstClients;
		for(int i=0;i<referencePerson.getFirstName().size();i++) {
			firstName=firstName+referencePerson.getFirstName().get(i);
		};
		firstClients = DataBase.searchClients(firstName);
		for(int i=0;i<referencePerson.getMiddleName().size();i++) {
			middleName=middleName+referencePerson.getMiddleName().get(i);
		};
		for(int i=0;i<referencePerson.getLastName().size();i++) {
			lastName=lastName+referencePerson.getLastName().get(i);
		};
		Set<Client> hSet = new HashSet<Client>(); 
        for (Client x : firstClients ) {
        	if(x.getPerson().getMiddleName().contains(middleName)&&x.getPerson().getLastName().contains(lastName)) {
        		hSet.add(x);
        	}
        }
       
        List<Client> finalresult = new ArrayList<Client>();
        for(Client x :hSet) {
        	finalresult.add(x);}
        
        return finalresult;
	}
	
}

