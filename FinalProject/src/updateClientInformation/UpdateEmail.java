package updateClientInformation;

import businessObjects.Client;

public class UpdateEmail implements UpdateClient {
	private String email;
	private boolean setUpdate;
	
	public UpdateEmail(String email) {
		this.email=email;
		this.setUpdate=false;
	}
	
	
	@Override
	public boolean updated() {
		return setUpdate;
	}

	
	
	@Override
	public Client updateInformation(Client client) {
		client.setEmail(email);
		client.save();
		setUpdate = true;
		return client;
	}

}
