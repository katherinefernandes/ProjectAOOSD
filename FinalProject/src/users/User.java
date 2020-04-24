package users;


import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.HistoryData;
import supportingClasses.Security;
import xmlParser.ClientXMLManipulation;
import xmlParser.ContainerXMLManipulation;
import xmlParser.HistoryXMLManipulation;
import xmlParser.IdentifiableXMLManipulation;

public class User implements View{
	//TODO what's the point of this class? Why are these fields together in a class with only getters and setters
	protected ClientData client;
	protected ContainerData container;
	protected ClientXMLManipulation databaseClient;
	protected ContainerXMLManipulation databaseContainer;
	protected Security ssecurity;
	protected boolean setClient;
	protected boolean setContainer;
	
	public User() {
		databaseClient = new ClientXMLManipulation();
		databaseContainer = new ContainerXMLManipulation();
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
