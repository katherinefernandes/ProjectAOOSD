package searchClients;

import java.util.List;

import businessObjects.Client;
import dataBase.DataBase;

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
