package simulation;

import java.time.LocalDateTime;
import java.util.*;

import applications.ClientApplication;
import applications.CompanyApplication;
import dataBase.DataBase;
import dataWrappers.*;
import exceptions.ElementSelectionException;
import objects.*;
import supportingClasses.Security;
import updateContainer.UpdateStatus;

/**
 * This class executes the actions a user can perform, as called from the simulator.
 * @author simon
 *
 */
public class UserActionGenerator {
	private RandomGenerator randomGenerator = RandomGenerator.getInstance();
	private int shipSpeedKPH = 60;
	
	/**
	 * Generates a new client. 
	 * @return the created client
	 */
	public Client generateNewClient() {
		List<List<String>> refrencePersonName = randomGenerator.generateRefrenceName();
		Client client = new Client(Security.generateIDFromSecureRandom(), 
							   	   randomGenerator.generateCompanyName(), randomGenerator.generateCountryCode(), 
								   randomGenerator.generatePhoneNumber(), randomGenerator.generateEmail(),
								   refrencePersonName.get(0), refrencePersonName.get(1), refrencePersonName.get(2),
								   randomGenerator.generateStreetName(), randomGenerator.generateCity(),
								   randomGenerator.generateHouseNumber(), randomGenerator.generateZipCode());
		randomGenerator.addClientToSelection(client);
		client.save();
		return client;
	}
	
	/**
	 * Generates a new journey
	 * @param currentTime - the current time given from the simulation
	 * @return the ID of the created journey
	 */
	public long generateNewJourney(LocalDateTime currentTime) {
		Client client = randomGenerator.getRandomClient();
		Port startPort = randomGenerator.getRandomPort();
		Port destinationPort = randomGenerator.getRandomPort();
		while(destinationPort.getID() == startPort.getID()) {
			destinationPort = randomGenerator.getRandomPort();
		}
		String cargo = randomGenerator.generateCargo();
		float startTemperature = randomGenerator.generateTemperature();
		float startHumidity = randomGenerator.generateHumidity();
		float startAtmosphere = randomGenerator.generateAtmosphere();
		String arriveBy = randomGenerator.generateArriveBy();
		
		ClientApplication user = new ClientApplication(client.getID());
		long journeyID = user.registerContainerForAJourney(startPort.getID(), destinationPort.getID(), cargo, startTemperature, startAtmosphere, startHumidity, arriveBy, currentTime.toString());
		return journeyID;
	}
	
	/**
	 * Changes the position of a container, towards its destination port
	 * @param container - the container to be 
	 * @param currentTime - the current time given from the simulation
	 */
	public void changeContainerPosition(Container container, LocalDateTime currentTime) {
		Port destinationPort;
		try {
			destinationPort = DataBase.getPort(container.getDestinationPortID());
		} catch (ElementSelectionException e) {
			throw new Error("The destination port isn't in the database",e);
		}
		Location destinationPosition = destinationPort.getPosition();
		
		container.moveTowardsPointByDistanceInKM(destinationPosition, shipSpeedKPH);
		
		container.setUpdated(currentTime.toString());
		container.save();
	}
	
	/**
	 * Changes the internal status of a container
	 * @param container - the container to be modified
	 */
	public void changeContainerStatus(Container container){
		InternalStatus oldStatus = container.getInternalStatus();
		float newTemperature = randomGenerator.changeTemperature(oldStatus.getTemperature());
		float newHumidity = randomGenerator.changeHumidity(oldStatus.getHumidity());
		float newAtmosphere = randomGenerator.changeAtmosphere(oldStatus.getAtmosphere());

		UpdateStatus update = new UpdateStatus(newTemperature,newHumidity,newAtmosphere);
		CompanyApplication user = new CompanyApplication();
		
		try {
			user.getContainer(container.getID());
		} catch (ElementSelectionException e) {
			throw new Error("The container isn't saved in the database",e);
		}
		
		user.updateContainerInformation(update);
	}
}
