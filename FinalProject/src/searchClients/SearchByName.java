package searchClients;

import java.util.List;

import dataBase.DataBase;
import objectsData.ClientData;

public class SearchByName implements SearchClients{
	private String name;
	
	
	public SearchByName(String name) {
		this.name = name;
	}
	
	@Override
	public List<ClientData> getClients() {
		return DataBase.searchClients(name);
	}
	
}
