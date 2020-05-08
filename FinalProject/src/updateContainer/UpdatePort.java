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
	public boolean getUpdated() {
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

	/**
	 * This method is called when the portID entered is same as the container's destination
	 * port ID. It will then execute some steps to inform the client that the journey has
	 * ended, the container information is reset to allow the container to be used again.
	 * @param container
	 * @author Mamuna Azam
	 */
	private void containerHasReachedDestination(Container container) {
		    System.out.println("Trying to update client");
			try {
				client = DataBase.getClient(container.getClientID());
			} catch (ElementSelectionException e) {
				throw new Error("Client was not found, which means the container was not registered properly",e);
			}
			updateClientInformationAtTheEndOfJourney(container);
			new UpdateDestinationPort().updateAtTheEndOfAJourney(container.getDestinationPortID(), container.getID());
			container.useContainerAgain(0000000l, 0, container.getDestinationPortID(), container.getDestinationPortID(), "none", 0, 0, 0, "1-1-2020");
	}

	private void updateClientInformationAtTheEndOfJourney(Container container) {
		client.removeActiveShipment(container.getJourneyID());
		client.addFinishedShipment(container.getJourneyID());
		client.save();
	}

	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
}
