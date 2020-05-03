package applications;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;

public class Application implements View{
	
	protected Client client;
	protected Container container;
	protected boolean setClient;
	protected boolean setContainer;
	
	public Application() {
		this.setClient=false;
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
	
	
	public void getClient (long clientID) throws ElementSelectionException {//need to deal with the exceptions
			client = DataBase.getClient(clientID);
			setClient = true;
	}
	public void getContainer(long containerID) throws ElementSelectionException { //need to deal with the exceptions
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
