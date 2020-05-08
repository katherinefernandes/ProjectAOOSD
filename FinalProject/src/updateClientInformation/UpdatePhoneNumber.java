package updateClientInformation;

import businessObjects.Client;

/**
 * This class is used to update the phone number for a client
 * @author Abdullah da boss
 *
 */
public class UpdatePhoneNumber implements UpdateClient {
	private int countryCode;
	private long phone;
	private boolean updated;
	
	public UpdatePhoneNumber(int countryCode,long phone) {
		this.countryCode=countryCode;
		this.phone=phone;
		this.updated=false;
	}
	
	
	@Override
	public boolean getUpdated() {
		return updated;
	}

	@Override
	public Client updateInformation(Client client) {
		client.setPhoneNumber(countryCode, phone);
		client.save();
		this.updated=true;
		return client;

	}

}
