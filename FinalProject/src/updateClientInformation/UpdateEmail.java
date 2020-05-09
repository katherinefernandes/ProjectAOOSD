package updateClientInformation;

import objects.Client;
/**
 * This class is used to update the email for a client
 * @author Mamuna
 *
 */
public class UpdateEmail implements UpdateClient {
	private String email;
	private boolean updated;
	
	public UpdateEmail(String email) {
		this.email=email;
		this.updated=false;
	}
	
	
	@Override
	public boolean getUpdated() {
		return updated;
	}

	
	
	@Override
	public Client updateInformation(Client client) {
		client.setEmail(email);
		client.save();
		updated = true;
		return client;
	}

}
