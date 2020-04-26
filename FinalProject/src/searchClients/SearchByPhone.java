package searchClients;

import java.util.List;

import businessObjects.Client;
import dataBase.DataBase;

public class SearchByPhone implements SearchClients{
	private String phone;
	
	
	public SearchByPhone(long phone) {
		this.phone = Long.toString(phone);
	}
	
	@Override
	public List<Client> getClients() {
		return DataBase.searchClients(phone);
	}
	
}
