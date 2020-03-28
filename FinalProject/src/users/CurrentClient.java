package users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.InternalState;
import supportingClasses.Security;
import supportingClasses.activeContainers;


public class CurrentClient {
	private ClientData client;
	private Scanner s;
	private Long clientID;
	private ClientAccess databaseClient;
	private ContainerAccess databaseContainer;
	private boolean display=true;
	private activeContainers containers = new activeContainers();
	private int choice;
	
	public CurrentClient(Scanner sc) {
		this.s = sc;
	}
	
	public void getInfoClient(){
		getIDByUserInput(); //gets the ID by the user and updated the client with a clientData object
		if (display) {
			displayClientInfo(infoClient());
		}
	}
	private void getIDByUserInput() {
		while(true) {
			try {
				System.out.println("Please enter your valid clientID");
				
				clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatedly try to get the correct value
			    
				
				try {
					client = databaseClient.getEntry(clientID);
				} catch (NumberFormatException | AmbiguousElementSelectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} catch (ElementNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Invalid ID, please try again.");	
			}
		}
	}
	private String infoClient() {
		return "\nClient Name is: \t"+client.getCompanyName()+"\nClient Phone number is: \t"+client.getPhoneNumber()+"\nClient email is: \t"+client.getEmail()+"\nClient reference person is: \t"+client.getPerson().getFirstName()+" "+client.getPerson().getMiddleName()+" "+client.getPerson().getLastName();
	}

	private void displayClientInfo(String info) {
		System.out.println(info);
		}
	
	private void updateReferencePerson() {
		client.setPerson(getFirstName(), getMiddleName(), getLastName());
	}
	//for all the methods get_name, need to make sure that the input is valid and the person could add more than one name
	private ArrayList<String> getLastName() {
		System.out.println("Enter the last name of the person: ");
		ArrayList<String> lastname = new ArrayList<String>();
		
		lastname.add(s.next());
		
		return lastname;
	}
	private ArrayList<String> getMiddleName() {
		System.out.println("Enter the middle names of the person: ");
		ArrayList<String> middlename = new ArrayList<String>();
		
		middlename.add( s.next());// assuming that only 1 name is entered.
		
		return middlename;
	}
	private ArrayList<String> getFirstName() {
		System.out.println("Enter the first name of the person: ");
		ArrayList<String> firstname = new ArrayList<String>();
		
		firstname.add(s.next());
		
		return firstname;
	}
	
	private void updateEmail(String email) {
		client.setEmail(email);
	}
	private String inputForUpdateEmail() {
		System.out.println("Enter the new email: ");
		
		String email= s.next();
		
		return email;
	}
	
	public void updateInfoClient(){
		display=false;
		getInfoClient();
		switch (getChoiceForUpdateClient()) {
		case 1: updateReferencePerson();break;
		case 2: updateEmail(inputForUpdateEmail()); break;
		}
		display=true;
		try {
			databaseClient.editEntry(client);
		} catch (ElementNotFoundException e) {
			e.printStackTrace(); //find a better way to fix this
			System.out.println("Client can't be edited for some weird reason");
		}
	}
	private int getChoiceForUpdateClient() {
		while (true) {
			System.out.println("Please enter the following numbers: \n\t1 ---------- to update the Reference person \n\t2 ---------- to update the Email");
			
			choice = s.nextInt();
			
			if (choice==1||choice==2) {
				break;
			}
			System.out.println("Please try again, enter the correct number.");
		}
		return choice;
	}
	
	public void addJourney() {
		 getIDByUserInput();//gets the clientID
		 long clientID = client.getClientID();
		 long containerID = this.containers.assignContainer();
		 long journeyID = new Security().generateID();
		 //for the version one, generating a new portID as don't have the ability to get a portID by entering the port name
		 long startPortID = new Security().generateID();
		 long destinationPortID = new Security().generateID();
		 //need to find a better solution for location..
		 float latitude =37.75f;
		 float longitude =-97.82f;
		 String cargo = getCargoByUser();
		 InternalState state = getTheOptimalInternalState();
		 LocalDateTime arriveBy = getArrivalDate();
		 ContainerData container = new ContainerData(containerID,clientID,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,state.getTemperature(),state.getAtmosphere(),state.getHumidity(),arriveBy);
		 databaseContainer.newEntry(container);
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
		 
		 //blahhhhh
		 
	}
	
	
	private LocalDateTime getArrivalDate() {
		//at the moment just setting it to arandom date but will find a better solution for this
		
		
		return  LocalDateTime.of(2021, 2, 14, 18, 32);
	}
	
	private String getCargoByUser() {
		String cargo;
		while (true) {
			System.out.println("Please enter what the cargo will be: ");
			cargo = s.next();
			//need to check if the cargo is valid..
			break;
		}
		return cargo;
	}
	
	private InternalState getTheOptimalInternalState() {
	
		float temperature;
		float atmosphere;
		float humidity;
		while (true) {
			System.out.println("Please enter the optimal Temperature required for the cargo: ");
			temperature = s.nextFloat();
			//check if it is valid...
			System.out.println("Please enter the optimal atmosphere pressure required for the cargo: ");
			atmosphere = s.nextFloat();
			System.out.println("Please enter the optimal humidity level required for the cargo: ");
			humidity = s.nextFloat();
			break;
		}
		
		return new InternalState(atmosphere,temperature,humidity);
	}
	
	
	public void viewInternalStatusOfAJourney() {
		displayInternalStatus(getContainerData());
	
	}
	private ContainerData getContainerData() {
		ContainerData container;
		while (true) {
			System.out.println("Please enter valid containerID");
			
			long containerID = s.nextLong(); // in actual it should be a string which is parsed to return a long but waiting for the validinput class
			 
			container = databaseContainer.getEntry(containerID);
			//remember to add the catch phrase once the containerAccess is updated.
			break;
		}
		return container;
	}
	private void displayInternalStatus(ContainerData container) {
		System.out.println("The internal atmosphere is:  "+container.getInternalStatus().getAtmosphere());
		System.out.println("The internal Temperature is:  "+ container.getInternalStatus().getTemperature());
		System.out.println("The internal Humidity is:  "+container.getInternalStatus().getHumidity());
	}
	
}
