package updateClientInformation;

import java.util.ArrayList;

import XMLParser.ClientAccess;
import objectsData.ClientData;

public class UpdateReferencePerson implements UpdateClient {
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private boolean setUpdate;
	private ClientAccess databaseClient;
	
	public UpdateReferencePerson(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.middleName=middleName;
		this.setUpdate=false;
		databaseClient= new ClientAccess();
	}
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return setUpdate;
	}

	@Override
	public ClientData updateInformation(ClientData client) {
		client.setPerson(firstName, middleName, lastName);
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
		setUpdate= true;
		return client;
		
	}

}
