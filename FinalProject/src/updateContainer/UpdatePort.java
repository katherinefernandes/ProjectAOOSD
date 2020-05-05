package updateContainer;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import supportingClasses.UpdateDestinationPort;

public class UpdatePort implements UpdateContainer {
	private boolean update;
	private long portID;
	private Client client;
	private Container container;
	
	public UpdatePort(long portID) {
		this.portID = portID;
		this.update=false;
	}
	
	@Override
	public boolean updated() {
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
		DataBase.saveToHistory(container);
		update = true;
		return container;
	}
	
	
	private void containerHasReachedDestination(Container container) {
		    System.out.println("Trying to update client");
			try {
				client = DataBase.getClient(container.getClientID());
			} catch (ElementSelectionException e) {
				throw new Error("Client was not found, which means the container was not registered properly",e);
			}
			client.removeActiveShipment(container.getJourneyID());
			client.addFinishedShipment(container.getJourneyID());
			client.save();
			new UpdateDestinationPort().updatedestinationPortAtEndOfJourney(container.getDestinationPortID(), container.getID());
			container.useContainerAgain(0000000l, 0, container.getDestinationPortID(), container.getDestinationPortID(), "none", 0, 0, 0, "1-1-2020");
	}

	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
}
