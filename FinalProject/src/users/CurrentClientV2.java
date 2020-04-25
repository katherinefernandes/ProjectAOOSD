package users;

import java.util.*;
import containerFilters.FilteringContainersForAClient;
import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import objectsData.*;
import supportingClasses.*;
import updateClientInformation.UpdateClient;

public class CurrentClientV2 extends User{
	private PortData startPort;
	private PortData destinationPort;
	private boolean foundContainer;
	private long containerID;
	private boolean containerRegistered;
	private UpdateHistory history;

	public CurrentClientV2(long ID) {
		super();
		try {
			this.getClient(ID);
		} catch (ElementNotFoundException e) {
			throw new Error(e);
		}
		history = new UpdateHistory();
	}

	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.updated();
	}



	public long getPortID(String portname) {
		List<PortData> listOfPorts = DataBase.searchPorts(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}

	public void getAContainer(long startPortID) {
		foundContainer = false;
		try {
			startPort = DataBase.getPort(startPortID);
			if (startPort.getStationedContainers().size()>0) {
				containerID = startPort.getStationedContainers().get(0);
				container = DataBase.getContainer(containerID);
				foundContainer  = true;
				startPort.updateStationedContainers(containerID);
				startPort.save();
			}else {
				createANewContainer(startPortID);
			}
		} catch (ElementNotFoundException e) {
			throw new Error(e);
		}
		
	}

	public boolean getFoundContainer() {
		return foundContainer;
	}

	

	public boolean updateDestinationPort(long destinationPortID) {
		try {
			destinationPort = DataBase.getPort(destinationPortID);
			destinationPort.addArrivingContainer(containerID);
			destinationPort.save();
			return true;
		} catch (ElementNotFoundException e) {
			return false;
		}
		
	}

	public void registerContainer(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy) {
		containerRegistered=false;
		container.setClientID(client.getID());
		container.setStartPortID(startPortID);
		container.setDestinationPortID(destinationPortID);
		container.setCargo(cargo);
		container.setStatus(pressure, temperature, humidity);
		container.setArriveBy(parseInput.getDate(arriveBy));
		container.setJourneyID(ssecurity.generateID());
		container.save();
		history.updateHistoryDataBase(container);
		client.addActiveShipment(container.getJourneyID());
		client.save();
		containerRegistered=true;
	}

	public boolean getContainerRegistered() {
		return this.containerRegistered;
	}

	

	private void createANewContainer(long startPortID)  {
		container = new ContainerData(this.ssecurity.generateID(),startPortID,startPort.getPosition().getLatitude(),startPort.getPosition().getlongitude());
		containerID = container.getID();
		startPort.addStationedContainer(containerID);
		startPort.save();
		container.save();
		getAContainer(startPortID);
	}

	public ArrayList<ContainerData> getFilteredContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}
	


	

	

}
