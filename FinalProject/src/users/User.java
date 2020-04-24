package users;


import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.HistoryAccess;
import dataAccess.IdentifiedDataAccess;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.HistoryData;
import supportingClasses.Security;

public class User implements View{
	//TODO what's the point of this class? Why are these fields together in a class with only getters and setters
	protected ClientData client;
	protected ContainerData container;
	protected ClientAccess databaseClient;
	protected ContainerAccess databaseContainer;
	protected Security ssecurity;
	protected boolean setClient;
	protected boolean setContainer;
	
	public User() {
		databaseClient = new ClientAccess();
		databaseContainer = new ContainerAccess();
		this.setClient=false;
		ssecurity = new Security();
		this.setContainer=false;
	}
	
	@Override
	public ClientData viewClient(){
		return this.client;
	}
	
	@Override
	public ContainerData viewContainer() {
		return this.container;
	}
	
	
	public void getClient (long clientID) throws ElementNotFoundException {
			client = databaseClient.getEntry(clientID);
			setClient = true;
	}
	public void getContainer(long containerID) throws ElementNotFoundException {
		
			container = databaseContainer.getEntry(containerID); 
			setContainer= true;
	}
	
	public boolean getSetClient() {
		return this.setClient;
	}
	public boolean getSetContainer() {
		return this.setContainer;
	}
	
	
}
