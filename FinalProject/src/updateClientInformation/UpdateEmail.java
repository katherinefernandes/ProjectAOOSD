package updateClientInformation;

import objectsData.ClientData;
import xmlParser.ClientXMLManipulation;

public class UpdateEmail implements UpdateClient {
	private String email;
	private boolean setUpdate;
	private ClientXMLManipulation databaseClient;
	
	public UpdateEmail(String email) {
		this.email=email;
		this.setUpdate=false;
		databaseClient= new ClientXMLManipulation();
	}
	
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return setUpdate;
	}

	@Override
	public ClientData updateInformation(ClientData client) {
		// TODO Auto-generated method stub
		client.setEmail(email);
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
		setUpdate = true;
		return client;
	}

}
