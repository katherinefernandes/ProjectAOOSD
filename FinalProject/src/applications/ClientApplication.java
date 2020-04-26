package applications;

import java.util.ArrayList;

import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilteringContainersForAClient;
import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import supportingClasses.UpdateDestinationPort;
import supportingClasses.UpdateHistory;
import updateClientInformation.UpdateClient;

public class ClientApplication extends Application{
	private Port startPort;
	private boolean foundContainer;
	private long containerID;
	private boolean containerRegistered;

	public ClientApplication(long ID) {
		super();
		try {
			this.getClient(ID);
		} catch (ElementNotFoundException e) {
			throw new Error(e);
		}
	}

	
	
	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.updated();
	}



	

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
		} catch (ElementNotFoundException e) {
			
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

	public ArrayList<Container> filterContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}
	


	

	

}
