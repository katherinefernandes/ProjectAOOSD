package searchClients;

import java.util.List;

import dataBase.DataBase;
import objects.Client;
/**
 * Searchs the database for clients depending on the email entered
 * @author Katherine
 *
 */
public class SearchByEmail implements SearchClients{
	private String email;
	
	
	public SearchByEmail(String email) {
		this.email = email;
	}
	
	@Override
	public List<Client> getClients() {
		return DataBase.searchClients(email);
	}
	
}
