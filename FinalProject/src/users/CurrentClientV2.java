package users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;
import objectsData.PortData;

public class CurrentClientV2 extends User{
	private boolean clientIsSet;
	private boolean updatedPhone;
	private boolean updatedEmail;
	private boolean updatedReferencePerson;
	private PortData startPort;
	private PortData destinationPort;
	private boolean foundContainer = false;
	private long containerID;
	private boolean containerRegistered;
	private ArrayList<Long> ActiveJourneys;
	

	public CurrentClientV2(long ID) {
		// TODO Auto-generated constructor stub
		//databaseClient = new ClientAccess();
		//databasePort = new PortAccess();
		//databaseContainer = new ContainerAccess();
		super();
		try {
			client = databaseClient.getEntry(ID);
			clientIsSet = true;
		} catch (NumberFormatException | ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("client is not found");
			clientIsSet = false;
			//e.printStackTrace();
		
		}
		this.display=false;
	}
	
	public boolean getClientIsSet() {
		return this.clientIsSet;
	}

	
	public void getClient() {
		setClient = true;
		display=true;
		
	}
	

	public void updatePhone() {
		// TODO Auto-generated method stub
		this.updatedPhone =false;
	}

	public boolean getUpdatedPhone() {
		// TODO Auto-generated method stub
		return this.updatedPhone;
	}

	public void updateClientInformation(int countryCode, long phone) {
		// TODO Auto-generated method stub
		this.client.setPhoneNumber(countryCode, phone);
		databaseClient.editEntry(client);
		this.updatedPhone=true;
	}

	public void updateEmail() {
		// TODO Auto-generated method stub
		this.updatedEmail=false;
	}

	public boolean getUpdatedEmail() {
		// TODO Auto-generated method stub
		return this.updatedEmail;
	}

	public void updateClientInformation(String email) {
		// TODO Auto-generated method stub
		this.client.setEmail(email);
		databaseClient.editEntry(client);
		this.updatedEmail=true;
	}

	public void updateReferencePerson() {
		// TODO Auto-generated method stub
		this.updatedReferencePerson =false;
	}

	public boolean getUpdatedReferencePerson() {
		// TODO Auto-generated method stub
		return this.updatedReferencePerson;
	}

	public void updateClientInformation(ArrayList<String> firstName, ArrayList<String> middleName, ArrayList<String> lastName) {
		// TODO Auto-generated method stub
		this.client.setPerson(firstName, middleName, lastName);
		databaseClient.editEntry(client);
		this.updatedReferencePerson=true;
		
	}

	public long getPortID(String portname) {
		// TODO Auto-generated method 
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
			System.out.println("either port or the container not found");
			e.printStackTrace();
		}
		
	}
	public void setFoundContainer() {
		foundContainer = false;
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
			e.printStackTrace();
			return false;
		}
		
	}

	public void registerContainer(long startPortID, long destinationPortID, String cargo, float temperature,
			float pressure, float humidity, LocalDateTime arriveBy) {
		// TODO Auto-generated method stub
		container.setClientID(client.getID());
		container.setStartPortID(startPortID);
		container.setDestinationPortID(destinationPortID);
		container.setCargo(cargo);
		container.setStatus(pressure, temperature, humidity);
		container.setArriveBy(arriveBy);
		container.setJourneyID(ssecurity.generateID());
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		this.containerRegistered=true;//only in the active data.. not in xml
		client.addActiveShipment(container.getJourneyID());
		databaseClient.editEntry(client);
		databaseClient.flushActiveData();
	}

	public boolean getContainerRegistered() {
		// TODO Auto-generated method stub
		return this.containerRegistered;
	}

	public void setContainerRegistered() {
		// TODO Auto-generated method stub
		this.containerRegistered=false;
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
		this.foundContainer=true;
		getAContainer(startPortID);
	}

	public void getContainer(long containerID) {
		// TODO Auto-generated method stub
		try {
			container = databaseContainer.getEntry(containerID);
			this.foundContainer = true;
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ContainerData viewContainer() {
		// TODO Auto-generated method stub
		return this.container;
	}

	public ArrayList<ContainerData> getContainersByActiveJourneyIDs() {
		// TODO Auto-generated method stub
		ArrayList<ContainerData> containers = new ArrayList<ContainerData>();
		List<ContainerData> containerExtractedByDataBase;
		this.ActiveJourneys=client.getActiveShipment();
		for(int i=0;i<this.ActiveJourneys.size();i++) {
			String journeyIDInString = this.ActiveJourneys.get(i).toString();
			containerExtractedByDataBase = databaseContainer.searchEntries(journeyIDInString);
			containers.add(containerExtractedByDataBase.get(0));
		}
		return containers;
	}
	public ContainerData getContainersByActiveJourneyIDs(long journeyID) {
		// TODO Auto-generated method stub
		String JourneyIDInString = Long.toString(journeyID);
		
		return databaseContainer.searchEntries(JourneyIDInString).get(0);
	}
	

	public ArrayList<ContainerData> filterContainersByStartPortID(long startPortID) {
		// TODO Auto-generated method stub
		ArrayList<ContainerData> containersInJourney = getContainersByActiveJourneyIDs();
		for (int i=0;i<containersInJourney.size();i++) {
			if (containersInJourney.get(i).getStartPortID()!=startPortID) {
				containersInJourney.remove(i);
			}
		}
		return containersInJourney;
	}

	public ArrayList<ContainerData> filterContainersByCargo(String cargo) {
		// TODO Auto-generated method stub
		ArrayList<ContainerData> containersInJourney = getContainersByActiveJourneyIDs();
		for (int i=0;i<containersInJourney.size();i++) {
			if (!containersInJourney.get(i).getCargo().equals(cargo)) {
				containersInJourney.remove(i);
			}
		}
		return containersInJourney;
	}

	

	

	

}
