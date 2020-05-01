package updateContainer;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.UpdateDestinationPort;
import supportingClasses.UpdateHistory;

public class UpdatePort implements UpdateContainer {
	private boolean update;
	private long portID;
	private Client client;
	
	public UpdatePort(long portID) {
		this.portID = portID;
	}
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return update;
	}

	@Override
	public Container updateInformation(Container container) {
		container.setLastVisitedPort(portID);
		if(container.getDestinationPortID()==portID) {
			System.out.println("container has reached destination");
			containerHasReachedDestination(container);
		}
		container.save();
		UpdateHistory.updateHistoryDataBase(container);
		update = true;
		return container;
	}
	private void containerHasReachedDestination(Container container) {
		    System.out.println("Trying to update client");
			try {
				client = DataBase.getClient(container.getClientID());
			} catch (ElementSelectionException e) {
				throw new Error(e);
			}
			client.removeActiveShipment(container.getJourneyID());
			client.addFinishedShipment(container.getJourneyID());
			client.save();
			new UpdateDestinationPort().updatedestinationPortAtEndOfJourney(container.getDestinationPortID(), container.getID());
			container.useContainerAgain(0000000l, 0, container.getDestinationPortID(), container.getDestinationPortID(), "none", 0, 0, 0, "1-1-2020");
			container.save();
		
		
	}

}
