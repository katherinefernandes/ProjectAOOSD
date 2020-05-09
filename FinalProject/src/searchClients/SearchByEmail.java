package searchClients;

import java.util.List;

import dataBase.DataBase;
import objects.Client;

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
