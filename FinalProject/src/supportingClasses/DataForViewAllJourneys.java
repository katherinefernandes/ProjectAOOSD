package supportingClasses;

import java.util.List;

import dataBase.DataBase;
import objectsData.ClientData;
import objectsData.ContainerData;

public class DataForViewAllJourneys {
	
	private List<ClientData> clients;
	private String result;
	
	public DataForViewAllJourneys() {
		clients = DataBase.searchClients("");
		result = "\n----------------------------------------------------------------------------------------------";
		for (ClientData client: clients) {
			if(client.getActiveShipments().size()>0) {
				result = result +"\nClient ID: "+Long.toString(client.getID());
				result = result +"\nName: "+client.getCompanyName();
				result = result +"\nEmail: "+client.getEmail();
				result = result +"\nActive Journeys: "+activeJourneys(client);
				result = result +"\n----------------------------------------------------------------------------------------------";
			}
		}
	}

	private String activeJourneys(ClientData client) {
		String result = "";
		for(long journey : client.getActiveShipments()) {
			result = result +"\nJourney ID: "+Long.toString(journey);
			result = result +"  Container ID: "+getContainerID(journey);
		}
		return result;
	}

	private String getContainerID(long journey) {
		List<ContainerData> containers = DataBase.searchContainers(Long.toString(journey));
		for (ContainerData container : containers) {
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
