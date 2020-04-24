package updateClientInformation;

import java.util.ArrayList;

import objectsData.ClientData;
import xmlParser.ClientXMLManipulation;

public class UpdateReferencePerson implements UpdateClient {
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private boolean setUpdate;
	private ClientXMLManipulation databaseClient;
	
	public UpdateReferencePerson(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.middleName=middleName;
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
		client.setPerson(firstName, middleName, lastName);
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
		setUpdate= true;
		return client;
		
	}

}
