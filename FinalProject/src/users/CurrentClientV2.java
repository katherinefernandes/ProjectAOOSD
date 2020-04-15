package users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.AmbiguousElementSelectionException;
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

	public CurrentClientV2(long ID) {
		// TODO Auto-generated constructor stub
		databaseClient = new ClientAccess();
		databasePort = new PortAccess();
		databaseContainer = new ContainerAccess();
		try {
			client = databaseClient.getEntry(ID);
			clientIsSet = true;
		} catch (NumberFormatException | ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Element not found");
			clientIsSet = false;
		}
		this.display=false;
	}
	
	public boolean getClientIsSet() {
		return this.clientIsSet;
	}

	@Override
	public void displayContainerData(ContainerData container) {
		// TODO Auto-generated method stub
		// this will send the container to a display which needs to be implemented.
		
	}
	
	public boolean viewClient() {
		if (display) {
			viewClient(client);
			return true;
		}
		return false;
	}

	public boolean getViewClient() {
		// TODO Auto-generated method stub
		return this.display;
	}

	public void setViewClient(boolean changeDisplay) {
		// TODO Auto-generated method stub
		this.display=changeDisplay;
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
			System.out.println(listOfPorts.get(0).getPortName());
			System.out.println(listOfPorts.get(0).getID());
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
			containerID = startPort.getStationedContainers().remove(0);
			container = databaseContainer.getEntry(containerID);
			foundContainer  = true;
			databasePort.editEntry(startPort);
			
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
		container.setStartPortID(startPortID);
		container.setDestinationPortID(destinationPortID);
		container.setCargo(cargo);
		container.setStatus(pressure, temperature, humidity);
		container.setArriveBy(arriveBy);
		databaseContainer.editEntry(container);
		this.containerRegistered=true;
		databaseContainer.flushActiveData();
		
	}

	public boolean getContainerRegistered() {
		// TODO Auto-generated method stub
		return this.containerRegistered;
	}

	public void setContainerRegistered() {
		// TODO Auto-generated method stub
		this.containerRegistered=false;
	}

	

}
