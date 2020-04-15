package users;


import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import inputFromUsers.CurrentClientInput;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.Security;

public abstract class User {
	
	protected ClientData client;
	protected ContainerData container;
	protected ClientAccess databaseClient;
	protected ContainerAccess databaseContainer;
	protected PortAccess databasePort;
	protected boolean display;
	protected CurrentClientInput input = new CurrentClientInput();
	protected Security ssecurity = new Security();
	
	
	public void viewClient(ClientData client){
		this.client = client; //gets the ID by the user and updated the client with a clientData object
		if (display) {
			input.displayClientInfo(informationClient());
		}
	}
	private String informationClient() {
		return "\nClient Name is: \t"+client.getCompanyName()+"\nClient Phone number is: \t"+client.getPhoneNumber().getCountryCode()+" "+client.getPhoneNumber().getPhone()+"\nClient email is: \t"+client.getEmail()+"\nClient reference person is: \t"+client.getPerson().getFirstName().toString()+" "+client.getPerson().getMiddleName().toString()+" "+client.getPerson().getLastName().toString();
	}
	public boolean getDisplay() {
		return display;
	}
	public abstract void displayContainerData(ContainerData container);
	public ClientData getClient () {
		return this.client;
	}
	
}
