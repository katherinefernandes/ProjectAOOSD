package simulation;

import java.time.LocalDateTime;
import java.util.*;

import applications.ClientApplication;
import applications.CompanyApplication;
import businessObjects.*;
import dataBase.DataBase;
import dataWrappers.*;
import exceptions.ElementSelectionException;
import supportingClasses.Security;
import updateContainer.UpdateLocation;
import updateContainer.UpdateStatus;

public class UserActionGenerator {
	private static RandomGenerator randomGenerator = new RandomGenerator();
	private static int shipSpeedKPH = 60;
	
	private UserActionGenerator(){};
	
	static public Client generateNewClient() {
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
	
	static public long generateNewJourney(LocalDateTime currentTime) {
		Client client = randomGenerator.getRandomClient();
		client = client.getUpdated();
		Port startPort = randomGenerator.getRandomPort();
		Port destinationPort = randomGenerator.getRandomPort();
		String cargo = randomGenerator.generateCargo();
		float startTemperature = randomGenerator.generateTemperature();
		float startHumidity = randomGenerator.generateHumidity();
		float startAtmosphere = randomGenerator.generateAtmosphere();
		String arriveBy = randomGenerator.generateArriveBy();

		//TODO must be changed when application is changed
		ClientApplication user = new ClientApplication(client.getID());
		long journeyID = user.registerContainerForAJourney(startPort.getID(), destinationPort.getID(), cargo, startTemperature, startAtmosphere, startHumidity, arriveBy, currentTime.toString());
		return journeyID;
	}
	
	static public void changeContainerPosition(Container container, LocalDateTime currentTime) throws ElementSelectionException {
		Location oldPosition = container.getCurrentPosition();
		Port destinationPort;
		try {
			destinationPort = DataBase.getPort(container.getDestinationPortID());
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
		Location destinationPosition = destinationPort.getPosition();
		
		Location newPosition = oldPosition.moveTowardsPointByDistanceInKM(destinationPosition, shipSpeedKPH);
		
		container.setCurrentPosition(newPosition.getLatitude(), newPosition.getLongitude());
		container.setUpdated(currentTime.toString());
		container.save();
	}
	
	static public void changeContainerStatus(Container container) throws ElementSelectionException {
		InternalStatus oldStatus = container.getInternalStatus();
		float newTemperature = randomGenerator.changeTemperature(oldStatus.getTemperature());
		float newHumidity = randomGenerator.changeHumidity(oldStatus.getHumidity());
		float newAtmosphere = randomGenerator.changeAtmosphere(oldStatus.getAtmosphere());

		UpdateStatus update = new UpdateStatus(newTemperature,newHumidity,newAtmosphere);
		CompanyApplication user = new CompanyApplication();
		user.getContainer(container.getID());
		user.updateContainerInformation(update);
	}
}
