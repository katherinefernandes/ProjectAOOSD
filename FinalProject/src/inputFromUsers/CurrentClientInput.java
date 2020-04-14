package inputFromUsers;

import java.util.ArrayList;
import java.util.Scanner;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.InternalState;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;

public class CurrentClientInput {
	private ClientAccess databaseClient;
	private ContainerAccess databaseContainer;
	private Long clientID;
	private ClientData client;
	private int choice;
	private ValidInput validate;
	
	public CurrentClientInput() {
		databaseClient = new ClientAccess();
		databaseContainer = new ContainerAccess();
		validate = new ValidInput();
	}
	
	public ClientData getIDByUserInput(Scanner s) {
		while(true) {
			System.out.println("Please enter your valid clientID");
			clientID = s.nextLong(); //need to check that the ID is valid, if not then repeatedly try to get the correct values
			
			try {
				client = databaseClient.getEntry(clientID);
				break;
			} catch (NumberFormatException | ElementNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Element not found");
			}
		}
		return client;
	}
	
	public void displayClientInfo(String info) {
		System.out.println(info);
		
	}
	
	public ArrayList<String> getLastName(Scanner s) {
		System.out.println("Enter the last name of the person: ");
		String lastName = s.nextLine();	
		while(lastName.length() == 0) {
			lastName = s.nextLine();
		}
		while (validate.validateName(lastName) != true) {
			System.out.println("Invalid name, enter again: ");
			lastName = s.nextLine();
			}
		ArrayList<String> lastnames = parseInput.parsingNames(lastName);
		return lastnames;
		
	}
	public ArrayList<String> getMiddleName(Scanner s) {
		System.out.println("Enter the middle names of the person: ");
		String middleName = s.nextLine();
		
		while (new ValidInput().validateName(middleName) != true) {
			if (middleName.length() == 0) {
				break;
			}
			else {
				System.out.println("Invalid name, enter again: ");
				middleName = s.nextLine();
			}
		}
		
		ArrayList<String> middleNames = parseInput.parsingNames(middleName);
		return middleNames;
	}
	public ArrayList<String> getFirstName(Scanner s) {
		System.out.println("Enter the first name of the person: ");
		String firstName = s.nextLine();
		while(firstName.length() == 0) {
			firstName = s.nextLine();
		}
		while (validate.validateName(firstName) != true) {
			System.out.println("Invalid name, enter again: ");
			firstName = s.nextLine();
		}
		
		ArrayList<String> firstNames = parseInput.parsingNames(firstName);
		return firstNames;
	}
	
	public String inputForUpdateEmail(Scanner s) {
		System.out.println("Enter the new email: ");
		String email= s.next();
		while(email.length() == 0) {
			email = s.nextLine();
		}
		while (validate.validateEmail(email) != true) {
			System.out.println("Invalid E-mail, enter again: ");
			email = s.nextLine();
		}
		
		return email;
	}
	
	public int getChoiceForUpdateClient(Scanner s) {
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
	
	public String getCargoByUser(Scanner s) {
		String cargo;
		while (true) {
			System.out.println("Please enter what the cargo will be: ");
			cargo = s.next();
			break;
		}
		return cargo;
	}
	
	public InternalState getTheOptimalInternalState(Scanner s) {
		
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
	
	
	public ContainerData getContainerData(Scanner s) {
		ContainerData container = null; //Added "= null" to fix compile error. Simon
		while (true) {
			System.out.println("Please enter valid containerID");
			
			long containerID = s.nextLong(); // in actual it should be a string which is parsed to return a long but waiting for the validinput class
			 
			try { //Edited by simon to fix compile errors. New exception to handle conflicting ids in insertion. Added code
				container = databaseContainer.getEntry(containerID); //Old code
				break;
			} catch (NumberFormatException | ElementNotFoundException e) { //Added code
				System.out.println("Container not found");
			}
			
			//remember to add the catch phrase once the containerAccess is updated.
		}
		return container;
	}
	
	public void displayInternalStatus(ContainerData container) {
		System.out.println("The internal atmosphere is:  "+container.getInternalStatus().getAtmosphere());
		System.out.println("The internal Temperature is:  "+ container.getInternalStatus().getTemperature());
		System.out.println("The internal Humidity is:  "+container.getInternalStatus().getHumidity());
	}
	
	
	
	
	
	
	
	
	
	
	
}
