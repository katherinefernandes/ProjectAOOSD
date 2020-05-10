package simulation;

import java.time.LocalDateTime;
import java.util.*;

import applications.CompanyApplication;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import objects.Client;
import objects.Container;
import objects.Port;
import updateContainer.UpdatePort;

/**
 * This class simulates the performing of user actions and creation of objects matching real worlds entities.
 * @author simon
 *
 */
public class Simulator {
	private Random random;
	private LocalDateTime currentTime;
	private UserActionGenerator actionGenerator;
	private List<Container> allContainers;
	
	public Simulator() {
		random = new Random();
		currentTime = LocalDateTime.now();
		actionGenerator = new UserActionGenerator();
		generateInitialPorts();
		generateInitialClients();
		generateInitialJourneys();
	}
	
	/**
	 * Perform the actions users are simulated to perform during one hour.
	 */
	public void simulateOneHour() {
		simulateClientCreation(random.nextDouble());
		simulateJourneyCreation(random.nextDouble());
		simulateJourneyDevelopment();
		checkForFinshedJourneys();
		currentTime = currentTime.plusHours(1);
	}

	/**
	 * Simulates the logistics company registering the arrival of containers.
	 */
	public void checkForFinshedJourneys() {
		if(allContainers == null || random.nextDouble() < 0.05) {
			allContainers = DataBase.searchContainers("");
		}
		List<UpdatePort> updates = new ArrayList<>();
		for(Container container : allContainers) {
			addUpdateIfArrived(container, updates);
		}
		CompanyApplication application = new CompanyApplication();
		for(UpdatePort update : updates) {
			application.setContainer(update.getContainer());
			application.updateContainerInformation(update);
		}
	}

	/**
	 * simulates the logistics company updating the status and location of containers
	 */
	public void simulateJourneyDevelopment() {
		if(allContainers == null || random.nextDouble() < 0.05) {
			allContainers = DataBase.searchContainers("");
		}
		for(Container container : allContainers) {
			updateContainerIfActive(container);
		}
	}

	/**
	 * simulates the logistics company registering a new client
	 * @param creationWeigth - a double choosing whether a client is created or not
	 * @return the client that was created. null if no client was created.
	 */
	public Client simulateClientCreation(double creationWeigth) {
		Client client = null;
		if(creationWeigth < 1D/36D) {
			client = actionGenerator.generateNewClient();
		}
		return client;
	}
	
	/**
	 * Simulates a client user registering a new journey
	 * @param creationWeigth -  a double choosing whether a journey is created or not
	 * @return the ID of the journey that was created. 0 if no journey was created
	 */
	public long simulateJourneyCreation(double creationWeigth) {
		long journeyID = 0;
		if(creationWeigth < 1D/8D) {
			journeyID = actionGenerator.generateNewJourney(currentTime);
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
		List<Port> ports = DataBase.searchPorts("");
		if(ports.size() < 20) {
			PortInitializer portInit = PortInitializer.getInstance();
			portInit.generatePorts();
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
			actionGenerator.changeContainerPosition(container,currentTime);
			actionGenerator.changeContainerStatus(container);
		}
	}
	
	private boolean containerIsCloseToPort(Container container, Port destinationPort) {
		return container.getCurrentPosition().distanceTo(destinationPort.getPosition()) <= 70F;
	}
}
