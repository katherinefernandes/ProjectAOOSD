package updateClientInformation;

import objects.Client;

public interface UpdateClient {
	boolean getUpdated();
	
	/**
	 * updateInformation will replace the current information of the client 
	 * with new information
	 * @param client
	 * @return Updated Client
	 */
	Client updateInformation(Client client);
}
