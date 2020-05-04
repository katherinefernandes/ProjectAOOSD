package applications;

import java.util.*;
import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilteringContainersForAClient;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.Security;
import supportingClasses.UpdateDestinationPort;
import updateClientInformation.UpdateClient;

public class ClientApplication extends Application {
	
	public ClientApplication(long ID) {
		super();
		try {
			this.getClient(ID);
		} catch (ElementSelectionException e) {
			throw new Error("The client ID was not validated properly by the login controller",e); // need to test this
		}
	}

	/**
	 * updateClientInformation will update the client's information and 
	 * return a true if its updated
	 * @param update
	 * @return boolean 
	 */
	
	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.updated();
	}


	/**
	 * getContainerID will get a container ID of a container stationed at the
	 * start port which will be registered for a journey.
	 * @param startPortID
	 * @return ContainerID
	 */

	private long getContainerID(long startPortID) {
		try {
			Port startPort = DataBase.getPort(startPortID);
			Long containerID = 0l;
			if (startPort.getStationedContainers().size()>0) {
				containerID = startPort.getStationedContainers().get(0);
				container = DataBase.getContainer(containerID);
				startPort.removeStationedContainer(containerID);
				startPort.save();
			}else {
				createANewContainer(startPort);
			}
			return containerID;
		} catch (ElementSelectionException e) {
			throw new Error("The start port ID found was not valid",e); //needs to be tested
		}
		
	}

	//I needed a way to access the journey right after creation, so I made this method return journeyID
	//Simon
	/**
	 * registerContainerForAJourney will be called in the interface 
	 * to register a container for a journey
	 * It assumes that all the information passed to it is valid
	 * And thus will always register a container. 
	 * @param startPortID
	 * @param destinationPortID
	 * @param cargo
	 * @param temperature
	 * @param pressure
	 * @param humidity
	 * @param arriveBy
	 */
	public long registerContainerForAJourney(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy) {
		long containerID = getContainerID(startPortID);
		new UpdateDestinationPort().updatePort(destinationPortID, containerID);
		container.useContainerAgain(client.getID(),Security.generateIDFromSecureRandom(), startPortID, destinationPortID, cargo, temperature, pressure, humidity, arriveBy);
		container.save();
		DataBase.saveToHistory(container);
		client.addActiveShipment(container.getJourneyID());
		client.save();
		try {
			this.getClient(client.getID());
		} catch (ElementSelectionException e) {
			throw new Error("For some reason the client just saved can't be found",e);
		}
		return container.getJourneyID();
	}

	
	/**
	 * createANewContainer will generate a new container object and add the container ID 
	 * to the array of stationedContainers at the start Port
	 * @param startPort
	 */
	private void createANewContainer(Port startPort)  {

		container = new Container(Security.generateIDFromSecureRandom(),startPort);
		startPort.addStationedContainer(container.getID());
		startPort.save();
		container.save();
		getContainerID(startPort.getID());
	}
	
	
	/**
	 * filterContainersOnAJourney will filter out the active containers for the client 
	 * depending on the filter used.
	 * @param filter
	 * @return
	 */
	public ArrayList<Container> filterContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}

	
	
}
