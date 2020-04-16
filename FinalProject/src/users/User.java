package users;


import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.Security;

public  class User {
	
	protected ClientData client;
	protected ContainerData container;
	protected ClientAccess databaseClient;
	protected ContainerAccess databaseContainer;
	protected PortAccess databasePort;
	protected boolean display;
	protected Security ssecurity = new Security();
	protected boolean setClient;
	
	public User() {
		  databaseClient = new ClientAccess();
		 databaseContainer = new ContainerAccess();
		 databasePort = new PortAccess();
		 this.setClient=false;
	}
	
	public ClientData viewClient(){
		return this.client;
	}
	
	
	public void getClient (long clientID) {
		try {
			client = databaseClient.getEntry(clientID);
			setClient = true;
			display=true;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("client not found  "+clientID);
			this.display=false;
		}
	}
	
	public boolean getSetClient() {
		return this.setClient;
	}
	public boolean getDisplay() {
		return this.display;
	}
	
	
}
