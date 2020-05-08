package supportingClasses;

import dataBase.DataBase;
import exceptions.ElementSelectionException;
import objects.Port;
/**
 * This class is used to update the destination port when required
 * @author Mamuna Azam
 *
 */
public class UpdateDestinationPort {

	private Port destinationPort;

	
	/**
	 * When registering a container, this method is used to add the container ID
	 * to the arriving container list for the destination Port
	 * @param destinationID
	 * @param containerID
	 * @return boolean if the destination port is updated
	 * @throws ElementSelectionException if the destination Port does not exist
	 */
	public boolean updateArrivingContainersList(long destinationID,long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addArrivingContainer(containerID);
			destinationPort.save();
			return true;
		} catch (ElementSelectionException e) {
			throw new Error("The destination port is not valid",e);
		}
	}
	
	/**
	 * When the journey for a container ends, the container ID is removed from the arriving 
	 * Containers list at the destination port and added to the stationed containers
	 * @param destinationID
	 * @param containerID
	 */
	public void updateAtTheEndOfAJourney(long destinationID, long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addStationedContainer(containerID);
			destinationPort.removeArrivingContainer(containerID);
			destinationPort.save();
		} catch (ElementSelectionException e) {
			throw new Error("The destination port entered when registering the journey was not valid",e); 
		}
	}
	
}
