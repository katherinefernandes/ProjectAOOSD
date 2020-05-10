package searchClients;


import java.util.List;

import objects.Client;

public interface SearchClients {
	
	/**
	 * Returns a list of clients found by the search options
	 * @return list of clients
	 */
	List<Client> getClients();
	
	
}
