package searchClients;

import java.util.List;

import businessObjects.Client;
import dataBase.DataBase;

public class SearchByString implements SearchClients{
	private String string;
	
	
	public SearchByString(long phone) {
		this.string = Long.toString(phone);
	}
	
	@Override
	public List<Client> getClients() {
		return DataBase.searchClients(string);
	}
	
}
