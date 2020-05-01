package applications;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.Security;

public class Application implements View{
	//TODO what's the point of this class? Why are these fields together in a class with only getters and setters
	protected Client client;
	protected Container container;
	protected Security ssecurity;
	protected boolean setClient;
	protected boolean setContainer;
	
	public Application() {
		this.setClient=false;
		ssecurity = new Security();
		this.setContainer=false;
	}
	
	@Override
	public Client viewClient(){
		return this.client;
	}
	
	@Override
	public Container viewContainer() {
		return this.container;
	}
	
	
	public void getClient (long clientID) throws ElementSelectionException {
			client = DataBase.getClient(clientID);
			setClient = true;
	}
	public void getContainer(long containerID) throws ElementSelectionException { //need to change the throws
			setContainer = false;
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
