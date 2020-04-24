package applications;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import containerFilters.FilteringContainersForAClient;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.UpdateHistory;
import supportingClasses.parseInput;
import updateClientInformation.UpdateClient;
import xmlParser.PortXMLManipulation;

public class ClientApplication extends Application{
	private PortData startPort;
	private PortData destinationPort;
	private boolean foundContainer;
	private long containerID;
	private boolean containerRegistered;
	//private ArrayList<Long> ActiveJourneys;
	private PortXMLManipulation databasePort;
	private UpdateHistory history;

	public ClientApplication(long ID) {
		super();
		try {
			this.getClient(ID);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Error(e);
		}
		databasePort = new PortXMLManipulation();
		history = new UpdateHistory();
	}

	public boolean updateClientInformation(UpdateClient update) {
		update.updateInformation(client);
		return update.updated();
	}



	public long getPortID(String portname) {
		List<PortData> listOfPorts = databasePort.searchEntries(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}

	public void getAContainer(long startPortID) {
		// TODO Auto-generated method stub
		foundContainer = false;
		try {
			startPort = databasePort.getEntry(startPortID);
			if (startPort.getStationedContainers().size()>0) {
				containerID = startPort.getStationedContainers().get(0);
				container = databaseContainer.getEntry(containerID);
				foundContainer  = true;
				startPort.updateStationedContainers(containerID);
				databasePort.editEntry(startPort);
				databasePort.flushActiveData();
			}else {
				createANewContainer(startPortID);
			}
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			throw new Error(e);
		}
		
	}

	public boolean getFoundContainer() {
		return foundContainer;
	}

	

	public boolean updateDestinationPort(long destinationPortID) {
		// TODO Auto-generated method stub
		try {
			destinationPort = databasePort.getEntry(destinationPortID);
			destinationPort.addArrivingContainer(containerID);
			databasePort.editEntry(destinationPort);
			databasePort.flushActiveData();
			return true;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

	public void registerContainer(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, String arriveBy) {
		// TODO Auto-generated method stub
		containerRegistered=false;
		container.setClientID(client.getID());
		container.setStartPortID(startPortID);
		container.setDestinationPortID(destinationPortID);
		container.setCargo(cargo);
		container.setStatus(pressure, temperature, humidity);
		container.setArriveBy(parseInput.getDate(arriveBy));
		container.setJourneyID(ssecurity.generateID());
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		history.updateHistoryDataBase(container);
		client.addActiveShipment(container.getJourneyID());
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
		containerRegistered=true;
	}

	public boolean getContainerRegistered() {
		// TODO Auto-generated method stub
		return this.containerRegistered;
	}

	

	private void createANewContainer(long startPortID)  {
		// TODO Auto-generated method stub
		container = new ContainerData(this.ssecurity.generateID(),startPortID,startPort.getPosition().getLatitude(),startPort.getPosition().getlongitude());
		containerID = container.getID();
		startPort.addStationedContainer(containerID);
		databasePort.editEntry(startPort);
		databaseContainer.newEntry(container);
		databaseContainer.flushActiveData();
		databasePort.flushActiveData();
		getAContainer(startPortID);
	}

	public ArrayList<ContainerData> getFilteredContainersOnAJourney(FilteringContainersForAClient filter){
		return filter.filterContainers();
	}
	


	

	

}
