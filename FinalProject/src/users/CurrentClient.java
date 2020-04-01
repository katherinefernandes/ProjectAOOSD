package users;

import java.time.LocalDateTime;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import inputFromUsers.CurrentClientInput;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.InternalState;
import supportingClasses.Security;
import supportingClasses.activeContainers;


public class CurrentClient {

	private ClientData client;
	private ClientAccess databaseClient;
	private ContainerAccess databaseContainer;
	private boolean display;
	private activeContainers containers;
	private CurrentClientInput input;

	public CurrentClient() {
		databaseClient = new ClientAccess();
		databaseContainer = new ContainerAccess();
		containers = new activeContainers();
		display=true;
		input = new CurrentClientInput();
	}
	
	public void getInfoClient(Scanner s){
		client = input.getIDByUserInput(s); //gets the ID by the user and updated the client with a clientData object
		if (display) {
			input.displayClientInfo(infoClient());
		}
	}
	private String infoClient() {
		return "\nClient Name is: \t"+client.getCompanyName()+"\nClient Phone number is: \t"+client.getPhoneNumber().getCountryCode()+" "+client.getPhoneNumber().getPhone()+"\nClient email is: \t"+client.getEmail()+"\nClient reference person is: \t"+client.getPerson().getFirstName().toString()+" "+client.getPerson().getMiddleName().toString()+" "+client.getPerson().getLastName().toString();
	}

	private void updateReferencePerson(Scanner s) {
		client.setPerson(input.getFirstName(s), input.getMiddleName(s), input.getLastName(s));
	}
	
	
	private void updateEmail(String email) {
		client.setEmail(email);
	}
	
	public void updateInfoClient(Scanner s){
		display=false;
		getInfoClient(s);
		switch (input.getChoiceForUpdateClient(s)) {
		case 1: updateReferencePerson(s);break;
		case 2: updateEmail(input.inputForUpdateEmail(s)); break;
		}
		display=true;
		try {
			databaseClient.editEntry(client);
		} catch (ElementNotFoundException e) {
			System.out.println("Client can't be edited for some weird reason, check if client exists in database");
		}
	}
	
	public void addJourney(Scanner s) {
		 client = input.getIDByUserInput(s);//gets the clientID
		 long clientID = client.getClientID();
		 long containerID = this.containers.assignContainer();
		 long journeyID = new Security().generateID();
		 //for the version one, generating a new portID as don't have the ability to get a portID by entering the port name
		 long startPortID = new Security().generateID();
		 long destinationPortID = new Security().generateID();
		 //need to find a better solution for location..
		 float latitude =37.75f;
		 float longitude =-97.82f;
		 String cargo = input.getCargoByUser(s);
		 InternalState state = input.getTheOptimalInternalState(s);
		 LocalDateTime arriveBy = getArrivalDate();
		 ContainerData container = new ContainerData(containerID,clientID,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,state.getTemperature(),state.getAtmosphere(),state.getHumidity(),arriveBy);
		 
		 try {//Edited by simon to fix compile errors. New exception to handle conflicting ids in insertion. Added code
			databaseContainer.newEntry(container); //Old code
			System.out.println("The container is on its way to the destination.\n You can track the changes by this ID:  "+container.getContainerID());
		} catch (AmbiguousElementSelectionException e1) { //Added code
			System.out.println("Couldn't add the new journey, check manually whats wrong");
		} //Added code
		 
		 client.addActiveShipment(journeyID);
		 try {
			databaseClient.editEntry(client);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some error in editing the client with ID: "+client.getClientID());
		}
		 //for the moment as I am adding a random portID to both startPortID and destinationPortID, 
		 //I will not update the PORTDATA which needs to be done when the search by name is implemented.
	
		 
	}
	
	
	private LocalDateTime getArrivalDate() {
		//at the moment just setting it to arandom date but will find a better solution for this
		return  LocalDateTime.of(2021, 2, 14, 18, 32);
	}
	
	
	public void viewInternalStatusOfAJourney(Scanner s) {
		input.displayInternalStatus(input.getContainerData(s));
	
	}
	
}
