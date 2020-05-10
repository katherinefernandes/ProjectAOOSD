package updateClientInformation;

import java.util.ArrayList;

import objects.Client;
/**
 * Used to update the referencePerson details for the client
 * @author Mamuna
 *
 */
public class UpdateReferencePerson implements UpdateClient {
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private boolean updated;
	
	public UpdateReferencePerson(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.middleName=middleName;
		this.updated=false;
	}
	
	@Override
	public boolean getUpdated() {
		return updated;
	}

	@Override
	public Client updateInformation(Client client) {
		client.setPerson(firstName, middleName, lastName);
		client.save();
		updated= true;
		return client;
		
	}

}
