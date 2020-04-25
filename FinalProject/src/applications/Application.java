package applications;

import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.Security;

public class Application implements View{
	//TODO what's the point of this class? Why are these fields together in a class with only getters and setters
	protected ClientData client;
	protected ContainerData container;
	protected Security ssecurity;
	protected boolean setClient;
	protected boolean setContainer;
	
	public Application() {
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
			client = DataBase.getClient(clientID);
			setClient = true;
	}
	public void getContainer(long containerID) throws ElementNotFoundException {
		
			container = DataBase.getContainer(containerID); 
			setContainer= true;
	}
	
	public boolean getSetClient() {
		return this.setClient;
	}
	public boolean getSetContainer() {
		return this.setContainer;
	}
	
	
}
