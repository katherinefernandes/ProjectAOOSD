package updateClientInformation;

import businessObjects.Client;

public interface UpdateClient {
	boolean updated();
	
	/**
	 * updateInformation will replace the current information of the client 
	 * with new information
	 * @param client
	 * @return
	 */
	Client updateInformation(Client client);
}
