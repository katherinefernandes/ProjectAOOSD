package supportingClasses;

import businessObjects.Port;
import dataBase.DataBase;
import exceptions.ElementSelectionException;

public class UpdateDestinationPort {

	private Port destinationPort;

	
	/**
	 * When registering a container, this method is used to add the container ID
	 * to the arriving container list for the destination Port
	 * It is assumed by this method, that the destination ID is valid and there exists a 
	 * port in the database which has this destination ID
	 * @param destinationID
	 * @param containerID
	 * @return
	 */
	public boolean updatePort(long destinationID,long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addArrivingContainer(containerID);
			destinationPort.save();
			return true;
		} catch (ElementSelectionException e) {
			return false;
		}
	}
	
	/**
	 * When the journey for a container ends, the container ID is removed from the arriving 
	 * Containers list at the destination port and added to the stationed containers
	 * Again, it is assumed that the destination port ID is valid as otherwise the journey was 
	 * not registered correctly
	 * @param destinationID
	 * @param containerID
	 */
	public void updatedestinationPortAtEndOfJourney(long destinationID, long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addStationedContainer(containerID);
			destinationPort.removeArrivingContainer(containerID);
			destinationPort.save();
		} catch (ElementSelectionException e) {
			throw new Error(e); // need to test this
		}
	}
	
}
