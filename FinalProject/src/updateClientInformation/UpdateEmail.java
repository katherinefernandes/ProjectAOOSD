package updateClientInformation;

import objectsData.ClientData;

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
	public ClientData updateInformation(ClientData client) {
		// TODO Auto-generated method stub
		client.setEmail(email);
		client.save();
		setUpdate = true;
		return client;
	}

}
