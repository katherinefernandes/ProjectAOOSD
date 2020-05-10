package searchClients;

import java.util.List;

import dataBase.DataBase;
import objects.Client;
/**
 * Searches the database depending on the name entered of a client
 * @author Katherine
 *
 */
public class SearchByName implements SearchClients{
	private String name;
	
	
	public SearchByName(String name) {
		this.name = name;
	}
	
	@Override
	public List<Client> getClients() {
		return DataBase.searchClients(name);
	}
	
}
