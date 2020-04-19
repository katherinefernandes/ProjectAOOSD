package updateClientInformation;

import dataAccess.ClientAccess;
import objectsData.ClientData;

public class UpdatePhoneNumber implements UpdateClient {
	private int countryCode;
	private long phone;
	private boolean setUpdate;
	private ClientAccess databaseClient;
	
	public UpdatePhoneNumber(int countryCode,long phone) {
		this.countryCode=countryCode;
		this.phone=phone;
		this.setUpdate=false;
		 databaseClient= new ClientAccess();
	}
	
	
	@Override
	public boolean updated() {
		return setUpdate;
	}

	@Override
	public ClientData updateInformation(ClientData client) {
		client.setPhoneNumber(countryCode, phone);
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
		this.setUpdate=true;
		return client;

	}

}
