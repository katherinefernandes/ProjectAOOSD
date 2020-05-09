package searchClients;

import java.util.List;

import dataBase.DataBase;
import objects.Client;

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
