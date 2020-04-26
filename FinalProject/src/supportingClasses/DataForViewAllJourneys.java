package supportingClasses;

import java.util.List;
import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;

public class DataForViewAllJourneys {
	
	private List<Client> clients;
	private String result;
	
	public DataForViewAllJourneys() {
		clients = DataBase.searchClients("");
		result = "\n----------------------------------------------------------------------------------------------";
		for (Client client: clients) {
			if(client.getActiveShipments().size()>0) {
				result = result +"\nClient ID: "+Long.toString(client.getID());
				result = result +"\nName: "+client.getCompanyName();
				result = result +"\nEmail: "+client.getEmail();
				result = result +"\nActive Journeys: "+activeJourneys(client);
				result = result +"\n----------------------------------------------------------------------------------------------";
			}
		}
	}

	private String activeJourneys(Client client) {
		String result = "";
		for(long journey : client.getActiveShipments()) {
			result = result +"\nJourney ID: "+Long.toString(journey);
			result = result +"  Container ID: "+getContainerID(journey);
		}
		return result;
	}

	private String getContainerID(long journey) {
		List<Container> containers = DataBase.searchContainers(Long.toString(journey));
		for (Container container : containers) {
			if (container.getJourneyID()==journey) {
				return Long.toString(container.getID());
			}
		}
		return "Unknown";
	}
	public String getResult() {
		return result;
	}
	
}
