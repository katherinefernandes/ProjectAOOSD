package applications;

import java.util.ArrayList;
import java.util.List;

import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilteringContainersForAClient;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.UpdateDestinationPort;
import supportingClasses.UpdateHistory;
import updateClientInformation.UpdateClient;

public class ClientApplication extends Application {
	//TODO what is the meaning of these fields? When fields are saved permanently inside an object
	//it should be because their status has something to do with the purpose of the object.
	//I can't understand in what way a startport fundamentally relates to a session where the user is a client
	//A meaningful field would be for example Client saving the currently logged in client, which you seem
	//have saved in the supertype for some reason. This is weird as the logistics company cannot log in as
	//a specific client.
	//TODO what methods correspond directly to actions the user can perform? Since this is application layer, that should be
	//very clear, probably through an interface
	private Port startPort;
	private boolean foundContainer;
	private long containerID;
	private boolean containerRegistered;

	public ClientApplication(long ID) {
		super();
		try {
			this.getClient(ID);
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}

	
	//TODO why can't updateInformation be called directly on the update instance, which you necessitate the 
	//caller having anyways
	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.updated();
	}



	/**
	 * 
	 * @param startPortID
	 */

	public void getAContainer(long startPortID) {
		foundContainer = false;
		try {
			startPort = DataBase.getPort(startPortID);
			if (startPort.getStationedContainers().size()>0) {
				containerID = startPort.getStationedContainers().get(0);
				container = DataBase.getContainer(containerID);
				foundContainer  = true;
				startPort.removeStationedContainer(containerID);
				startPort.save();
			}else {
				createANewContainer();
			}
		} catch (ElementSelectionException e) {
			
			throw new Error(e);
		}
		
	}

	public boolean getFoundContainer() {
		return foundContainer;
	}

	
	public boolean updateDestinationPort(long destinationPortID) {
		return new UpdateDestinationPort().updatePort(destinationPortID, containerID);
		
	}

	public void registerContainerForAJourney(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy) {
		containerRegistered=false;		
		container.useContainerAgain(client.getID(),ssecurity.generateID() , startPortID, destinationPortID, cargo, temperature, pressure, humidity, arriveBy);
		container.save();
		UpdateHistory.updateHistoryDataBase(container);
		client.addActiveShipment(container.getJourneyID());
		client.save();
		containerRegistered=true;
	}

	public boolean getContainerRegistered() {

		return this.containerRegistered;
	}

	

	private void createANewContainer()  {

		container = new Container(this.ssecurity.generateID(),startPort);
		containerID = container.getID();
		startPort.addStationedContainer(containerID);
		startPort.save();
		container.save();
		getAContainer(startPort.getID());
	}
	
	//TODO what is this? If someone already have an instance of filter, why can't they just call its method directly?
	public ArrayList<Container> filterContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}

	
	
}
