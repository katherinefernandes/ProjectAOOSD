package searchClients;

import java.util.List;

import dataBase.DataBase;
import objectsData.ClientData;

public class SearchByEmail implements SearchClients{
	private String email;
	
	
	public SearchByEmail(String email) {
		this.email = email;
	}
	
	@Override
	public List<ClientData> getClients() {
		return DataBase.searchClients(email);
	}
	
}
