package updateClientInformation;

import businessObjects.Client;

public class UpdatePhoneNumber implements UpdateClient {
	private int countryCode;
	private long phone;
	private boolean setUpdate;
	
	public UpdatePhoneNumber(int countryCode,long phone) {
		this.countryCode=countryCode;
		this.phone=phone;
		this.setUpdate=false;
	}
	
	
	@Override
	public boolean updated() {
		return setUpdate;
	}

	@Override
	public Client updateInformation(Client client) {
		client.setPhoneNumber(countryCode, phone);
		client.save();
		this.setUpdate=true;
		return client;

	}

}
