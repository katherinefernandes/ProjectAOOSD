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

public  class User implements View{
	
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

	@Override
	public ContainerData viewContainer() {
		// TODO Auto-generated method stub
		return this.container;
	}
	
	
}
