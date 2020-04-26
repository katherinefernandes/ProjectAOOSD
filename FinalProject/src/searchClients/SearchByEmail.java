package searchClients;

import java.util.List;

import businessObjects.Client;
import dataBase.DataBase;

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
