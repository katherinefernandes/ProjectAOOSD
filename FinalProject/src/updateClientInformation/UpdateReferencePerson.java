package updateClientInformation;

import java.util.ArrayList;
import objectsData.ClientData;

public class UpdateReferencePerson implements UpdateClient {
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private boolean setUpdate;
	
	public UpdateReferencePerson(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.middleName=middleName;
		this.setUpdate=false;
	}
	
	@Override
	public boolean updated() {
		return setUpdate;
	}

	@Override
	public ClientData updateInformation(ClientData client) {
		client.setPerson(firstName, middleName, lastName);
		client.save();
		setUpdate= true;
		return client;
		
	}

}
