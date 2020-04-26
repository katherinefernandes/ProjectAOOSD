package supportingClasses;

import businessObjects.Port;
import dataBase.DataBase;
import exceptions.ElementNotFoundException;

public class UpdateDestinationPort {

	private Port destinationPort;

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
	
}
