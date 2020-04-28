package supportingClasses;

import businessObjects.Port;
import dataBase.DataBase;
import exceptions.ElementSelectionException;

public class UpdateDestinationPort {

	private Port destinationPort;

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
	public void updatedestinationPortAtEndOfJourney(long destinationID, long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addStationedContainer(containerID);
			destinationPort.removeArrivingContainer(containerID);
			destinationPort.save();
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	
}
