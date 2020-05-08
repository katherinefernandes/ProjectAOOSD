package supportingClasses;

import java.util.List;
import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
/**
 * Gets all the data for the logistic company to view all the active journeys
 * @author Mamuna
 *
 */
public class DataForViewAllJourneys {
	
	private List<Client> clients;
	private String output;

	/**
	 * DataForViewAllJourneys will extract all the clients from the database 
	 * and set the output string
	 */
	public DataForViewAllJourneys() {
		clients = DataBase.searchClients("");
		setOutPut();
	}

	/**
	 * setOutPut will extract the information from the list of clients and display it in 
	 * a string format
	 */
	private void setOutPut() {
		output = "\n----------------------------------------------------------------------------------------------";
		for (Client client: clients) {
			if(client.getActiveShipments().size()>0) {
				output = output +"\nClient ID: "+Long.toString(client.getID());
				output = output +"\nName: "+client.getCompanyName();
				output = output +"\nEmail: "+client.getEmail();
				output = output +"\nActive Journeys: "+activeJourneys(client);
				output = output +"\n----------------------------------------------------------------------------------------------";
			}
		}
	}

	/**
	 * This method will iterate through all the active journeys for the client
	 * and create a string which will contain the journey ID and the
	 * corresponding container ID
	 * @param client
	 * @return data for all the activeJourneys
	 */
	private String activeJourneys(Client client) {
		String result = "";
		for(long journey : client.getActiveShipments()) {
			result = result +"\nJourney ID: "+Long.toString(journey);
			result = result +"  Container ID: "+getContainerID(journey);
		}
		return result;
	}

	/**
	 * This method will extract a list of containers from the database which contain the
	 * journey ID provided and then return the container ID in a string format
	 * @param journeyID 
	 * @return either the containerID if it is found or else "Unknown"
	 */
	
	private String getContainerID(long journeyID) {
		List<Container> containers = DataBase.searchContainers(Long.toString(journeyID));
		for (Container container : containers) {
			if (container.getJourneyID()==journeyID) {
				return Long.toString(container.getID());
			}
		}
		return "Unknown";
	}
	
	
	public String getOutPut() {
		return output;
	}
	
}
