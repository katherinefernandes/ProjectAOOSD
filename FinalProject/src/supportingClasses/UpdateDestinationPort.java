package supportingClasses;

import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import objectsData.PortData;

public class UpdateDestinationPort {

	private PortData destinationPort;

	public boolean updatePort(long destinationID,long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addArrivingContainer(containerID);
			destinationPort.save();
			return true;
		} catch (ElementNotFoundException e) {

			return false;
		}
	}
	public void updatedestinationPortAtEndOfJourney(long destinationID, long containerID) {
		try {
			destinationPort = DataBase.getPort(destinationID);
			destinationPort.addStationedContainer(containerID);
			destinationPort.updateArrivingContainers(containerID);
			destinationPort.save();
		} catch (ElementNotFoundException e) {
			throw new Error(e);
		}
	}
	
}
