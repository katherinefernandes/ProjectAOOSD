package applications;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;

public class Application implements View{
	
	protected Client client;
	protected Container container;
	private boolean clientAdded;
	private boolean ContainerAdd;
	
	public Application() {
		this.clientAdded=false;
		this.ContainerAdd=false;
	}
	
	@Override
	public Client viewClient(){
		return this.client;
	}
	
	@Override
	public Container viewContainer() {
		return this.container;
	}
	
	/**
	 * Gets a client with the ID clientID from the database 
	 * 
	 * @param clientID
	 * @throws ElementSelectionException when the client with the given ID is not found
	 */
	
	public void getClient (long clientID) throws ElementSelectionException {
			clientAdded = false;
			client = DataBase.getClient(clientID);
			clientAdded = true;
	}
	
	/**
	 * Gets a container with the ID containerID from the database
	 * @param containerID
	 * @throws ElementSelectionException when the container with the given ID is not found
	 */
	public void getContainer(long containerID) throws ElementSelectionException {
			ContainerAdd = false;
			container = DataBase.getContainer(containerID); 
			ContainerAdd= true;
	}
	public void getContainer(Container container) {
		this.container = container;
		ContainerAdd = true;
	}
	public boolean getSetClient() {
		return this.clientAdded;
	}
	public boolean getSetContainer() {
		return this.ContainerAdd;
	}
	
	
}
