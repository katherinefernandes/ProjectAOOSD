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
		// TODO Auto-generated method stub
		return setUpdate;
	}

	@Override
	public Client updateInformation(Client client) {
		// TODO Auto-generated method stub
		client.setEmail(email);
		client.save();
		setUpdate = true;
		return client;
	}

}
