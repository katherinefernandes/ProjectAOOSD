package updateContainer;

import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.UpdateDestinationPort;
import supportingClasses.UpdateHistory;

public class UpdatePort implements UpdateContainer {
	private boolean update;
	private UpdateHistory history;
	private long portID;
	private ClientData client;
	
	public UpdatePort(long portID) {
		this.portID = portID;
		history = new UpdateHistory();
	}
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return update;
	}

	@Override
	public ContainerData updateInformation(ContainerData container) {
		container.setLastVisitedPort(portID);
		if(container.getDestinationPortID()==portID) {
			System.out.println("container has reached destination");
			containerHasReachedDestination(container);
		}
		container.save();
		history.updateHistoryDataBase(container);
		update = true;
		return container;
	}
	private void containerHasReachedDestination(ContainerData container) {
		System.out.println("Trying to update client");
			try {
				client = DataBase.getClient(container.getClientID());
			} catch (ElementNotFoundException e) {
				throw new Error(e);
			}
			client.removeActiveShipment(container.getJourneyID());
			client.addFinishedShipment(container.getJourneyID());
			new UpdateDestinationPort().updatedestinationPortAtEndOfJourney(container.getDestinationPortID(), container.getID());
			container.useContainerAgain(0000000l, 00000l, container.getDestinationPortID(), container.getDestinationPortID(), "none", 0, 0, 0, "1-1-2020");
			container.save();
		
		
	}

}
