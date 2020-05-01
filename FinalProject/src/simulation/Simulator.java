package simulation;

import java.util.*;

import applications.CompanyApplication;
import businessObjects.Container;
import businessObjects.Port;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import updateContainer.UpdatePort;

public class Simulator {
	private static Random random = new Random();
	
	public static void simulateOneHour() {
		simulateClientCreation();
		simulateJourneyCreation();
		simulateJourneyDevelopment();
		checkForFinshedJourneys();
	}

	private static void checkForFinshedJourneys() {
		List<Container> allContainers = DataBase.searchContainers("");
		List<UpdatePort> updates = new ArrayList<>();
		for(Container container : allContainers) {
			addUpdateIfArrived(container, updates);
		}
		CompanyApplication application = new CompanyApplication();
		for(UpdatePort update : updates) {
			application.updateContainerInformation(update);
		}
	}

	private static void addUpdateIfArrived(Container container, List<UpdatePort> updates) {
		Port destinationPort;
		try {
			destinationPort = DataBase.getPort(container.getDestinationPortID());
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
		if(container.getJourneyID() != 0 && containerIsCloseToPort(container, destinationPort)) {
			UpdatePort update = new UpdatePort(destinationPort.getID());
			updates.add(update);
		}
	}

	private static void updateContainerIfActive(Container container) {
		if(container.getJourneyID() != 0) {
			try {
				UserActionGenerator.changeContainerPosition(container);
				UserActionGenerator.changeContainerStatus(container);
			} catch (ElementSelectionException e) {
				throw new Error(e);
			}
		}
	}
	
	private static boolean containerIsCloseToPort(Container container, Port destinationPort) {
		return container.getCurrentPosition().distanceTo(destinationPort.getPosition()) <= 5F;
	}

	private static void simulateJourneyDevelopment() {
		List<Container> allContainers = DataBase.searchContainers("");
		for(Container container : allContainers) {
			updateContainerIfActive(container);
		}
	}

	private static void simulateClientCreation() {
		if(random.nextDouble() < 1/24) {
			UserActionGenerator.generateNewClient();
		}
	}
	
	private static void simulateJourneyCreation() {
		if(random.nextDouble() < 1/6) {
			UserActionGenerator.generateNewJourney();
		}
	}
}
