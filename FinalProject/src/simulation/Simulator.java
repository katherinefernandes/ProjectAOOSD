package simulation;

import java.time.LocalDateTime;
import java.util.*;

import applications.CompanyApplication;
import businessObjects.Client;
import businessObjects.Container;
import businessObjects.Port;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import updateContainer.UpdatePort;

public class Simulator {
	private Random random;
	private LocalDateTime currentTime;
	
	public Simulator() {
		random = new Random();
		currentTime = LocalDateTime.now();
		generateInitialPorts();
		generateInitialClients();
		generateInitialJourneys();
	}

	public void simulateOneHour() {
		simulateClientCreation(random.nextDouble());
		simulateJourneyCreation(random.nextDouble());
		simulateJourneyDevelopment();
		checkForFinshedJourneys();
		currentTime = currentTime.plusHours(1);
	}

	public void checkForFinshedJourneys() {
		List<Container> allContainers = DataBase.searchContainers("");
		List<UpdatePort> updates = new ArrayList<>();
		for(Container container : allContainers) {
			addUpdateIfArrived(container, updates);
		}
		CompanyApplication application = new CompanyApplication();
		for(UpdatePort update : updates) {
			application.getContainer(update.getContainer());
			application.updateContainerInformation(update);
		}
	}

	private void addUpdateIfArrived(Container container, List<UpdatePort> updates) {
		Port destinationPort;
		try {
			destinationPort = DataBase.getPort(container.getDestinationPortID());
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
		if(container.getJourneyID() != 0 && containerIsCloseToPort(container, destinationPort)) {
			UpdatePort update = new UpdatePort(destinationPort.getID());
			update.setContainer(container);
			updates.add(update);
		}
	}

	private void updateContainerIfActive(Container container) {
		if(container.getJourneyID() != 0) {
			try {
				UserActionGenerator.changeContainerPosition(container,currentTime);
				UserActionGenerator.changeContainerStatus(container);
			} catch (ElementSelectionException e) {
				throw new Error(e);
			}
		}
	}
	
	private boolean containerIsCloseToPort(Container container, Port destinationPort) {
		return container.getCurrentPosition().distanceTo(destinationPort.getPosition()) <= 10F;
	}

	public void simulateJourneyDevelopment() {
		List<Container> allContainers = DataBase.searchContainers("");
		for(Container container : allContainers) {
			updateContainerIfActive(container);
		}
	}

	public Client simulateClientCreation(double creationWeigth) {
		Client client = null;
		if(creationWeigth < 1D/24D) {
			client = UserActionGenerator.generateNewClient();
		}
		return client;
	}
	
	public long simulateJourneyCreation(double creationWeigth) {
		long journeyID = 0;
		if(creationWeigth < 1D/6D) {
			journeyID = UserActionGenerator.generateNewJourney(currentTime);
		}
		return journeyID;
	}
	
	private void generateInitialJourneys() {
		for(int i = 0; i < 10; i++) {
			simulateJourneyCreation(0.0);
		}
	}

	private void generateInitialClients() {
		for(int i = 0; i < 5; i++) {
			simulateClientCreation(0.0);
		}
	}

	private void generateInitialPorts() {
		PortInitializer portInit = new PortInitializer();
		portInit.generatePorts();
	}
}
