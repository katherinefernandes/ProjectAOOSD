package applications;

import java.time.LocalDateTime;
import java.util.*;
import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilteringContainersForAClient;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.Security;
import supportingClasses.UpdateDestinationPort;
import updateClientInformation.UpdateClient;

/**
 * This class contains the methods only relavent for the user client and will be used by the 
 * ClientController
 * @author Mamuna
 *
 */
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
	 * return a true if its stored correctly in the database
	 * @param update
	 * @return boolean 
	 */
	
	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.getUpdated();
	}


	/**
	 * getContainer will get a container ID of a container stationed at the
	 * start port which will be used to register a journey.
	 * @param startPortID
	 * @return ContainerID
	 */

	
	private long getContainerForJourneyRegisteration(long startPortID) {
		try {
			Port startPort = DataBase.getPort(startPortID);
			long containerID = startPort.containerIDForJourneyRegisteration();
			System.out.println("containerID"+containerID);
			container = DataBase.getContainer(containerID);
			return containerID;
		} catch (ElementSelectionException e) {
			throw new Error("The start port ID found was not valid",e); 
		}
		
	}
	
	public long registerContainerForAJourney(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy) {
		return registerContainerForAJourney(startPortID, destinationPortID, cargo, temperature,
				pressure, humidity, arriveBy, LocalDateTime.now().toString());
	}

	
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
	 * @param updated
	 * @return journey ID
	 */
	public long registerContainerForAJourney(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy, String updated) {
		
		long containerID = getContainerForJourneyRegisteration(startPortID);
		new UpdateDestinationPort().updateArrivingContainersList(destinationPortID, containerID);
		container.useContainerAgain(client.getID(),Security.generateIDFromSecureRandom(), startPortID, destinationPortID, cargo, temperature, pressure, humidity, arriveBy, updated);
		container.save();
		DataBase.saveToHistory(container);
		client.addActiveShipment(container.getJourneyID());
		client.save();

		return container.getJourneyID();
	}


	
	/**
	 * filterContainersOnAJourney will filter out the active containers for the client 
	 * depending on the filter used.
	 * @param filter
	 * @return ArrayList<Container> containers
	 */
	public ArrayList<Container> filterContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}

	
	
}
