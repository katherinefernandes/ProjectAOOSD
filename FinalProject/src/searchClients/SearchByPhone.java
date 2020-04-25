package searchClients;

import java.util.List;

import dataBase.DataBase;
import objectsData.ClientData;

public class SearchByPhone implements SearchClients{
	private String phone;
	
	
	public SearchByPhone(long phone) {
		this.phone = Long.toString(phone);
	}
	
	@Override
	public List<ClientData> getClients() {
		return DataBase.searchClients(phone);
	}
	
}
