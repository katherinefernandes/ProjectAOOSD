package updateContainer;

import dataBase.DataBase;
import objects.Container;
/**
 * Updates the last visited port for a container
 * @author Katherine
 *
 */
public class UpdatePort implements UpdateContainer {
	private boolean update;
	private long portID;
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
			container.containerHasReachedDestination();
		}
		container.save();
		update = true;
		return container;
	}



	public Container getContainer() {
		return container;
	}
	public void setContainer(Container container) {
		this.container = container;
	}
}
