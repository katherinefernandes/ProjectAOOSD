package dataBase;

import java.util.*;

import exceptions.ElementSelectionException;
import objects.*;
import xmlParser.*;

/**
 * This class is the bridge between the business logic and persistency layer. 
 * Calls to the databases should be made through the static methods in this class.
 * @author simon
 *
 */
public class DataBase {
	private static IdentifiablePersistency<Client> clientAccess = ClientXMLManipulation.getInstance();
	private static IdentifiablePersistency<Container> containerAccess = ContainerXMLManipulation.getInstance();
	private static IdentifiablePersistency<Port> portAccess = PortXMLManipulation.getInstance();
	private static GeneralPersistency<Container> historyAccess = HistoryXMLManipulation.getInstance();
	
	private DataBase() {}
	
	/**
	 * Returns all clients containing data with the given search word
	 * @param searchWord
	 * @return the list of matching clients
	 */
	public static List<Client> searchClients(String searchWord) {
		return clientAccess.searchEntries(searchWord);
	}
	
	/**
	 * Returns all containers containing data with the given search word
	 * @param searchWord
	 * @return the list of matching containers
	 */
	public static List<Container> searchContainers(String searchWord) {
		return containerAccess.searchEntries(searchWord);
	}
	
	/**
	 * Returns all ports containing data with the given search word
	 * @param searchWord
	 * @return the list of matching ports
	 */
	public static List<Port> searchPorts(String searchWord) {
		return portAccess.searchEntries(searchWord);
	}
	
	/**
	 * Returns all historical containers containing data with the given search word
	 * @param searchWord
	 * @return the list of matching containers
	 */
	public static List<Container> searchHistory(String searchWord) {
		return historyAccess.searchEntries(searchWord);
	}
	
	/**
	 * Returns the single client with the given unique ID
	 * @param ID - the ID of the client to be retrieved
	 * @return
	 * @throws ElementSelectionException if none or multiple entries with the ID was found
	 */
	public static Client getClient(long ID) throws ElementSelectionException {
		return clientAccess.getEntry(ID);
	}
	
	/**
	 * Returns the single container with the given unique ID
	 * @param ID - the ID of the container to be retrieved
	 * @return
	 * @throws ElementSelectionException if none or multiple entries with the ID was found
	 */
	public static Container getContainer(long ID) throws ElementSelectionException {
		return containerAccess.getEntry(ID);
	}
	
	/**
	 * Returns the single port with the given unique ID
	 * @param ID - the ID of the port to be retrieved
	 * @return
	 * @throws ElementSelectionException if none or multiple entries with the ID was found
	 */
	public static Port getPort(long ID) throws ElementSelectionException {
		return portAccess.getEntry(ID);
	}
	
	
	/**
	 * Saves the client to the database, overwriting a potential other client with the same ID
	 * @param client - the client to be saved
	 */
	public static void save(Client client) {
		clientAccess.newEntry(client);
	}
	
	/**
	 * Saves the container to the database, overwriting a potential other container with the same ID
	 * @param container - the container to be saved
	 */
	public static void save(Container container) {
		containerAccess.newEntry(container);
	}
	
	/**
	 * Saves the port to the database, overwriting a potential other port with the same ID
	 * @param port - the port to be saved
	 */
	public static void save(Port port) {
		portAccess.newEntry(port);
	}
	
	/**
	 * Saves a record of the container as it is at this point in time. 
	 * The Container.updated field is treated as a timestamp.
	 * Multiple containers with the same ID may exist
	 * @param historyPoint - the container to be saved
	 */
	public static void saveToHistory(Container historyPoint) {
		historyAccess.newEntry(historyPoint);
	}
	
	/**
	 * Checks whether a given ID exists in the databases. Assumes IDs are unique
	 * across multiple databases
	 * @param ID - the ID to be searched for
	 * @return true if the ID was found, false otherwise
	 */
	public static boolean isSavedID(long ID) { 
		return clientAccess.isSavedID(ID) || containerAccess.isSavedID(ID) || portAccess.isSavedID(ID);
	}
	
	/**
	 * Deletes the client with the given ID from the database
	 * @param ID - the ID of the client to be deleted
	 */
	public static void deleteClient(long ID) {
		clientAccess.deleteEntry(ID);
	}
	
	/**
	 * Deletes the container with the given ID from the database
	 * @param ID - the ID of the container to be deleted
	 */
	public static void deleteContainer(long ID) {
		containerAccess.deleteEntry(ID);
	}
	
	/**
	 * Deletes the port with the given ID from the database
	 * @param ID - the ID of the port to be deleted
	 */
	public static void deletePort(long ID) {
		portAccess.deleteEntry(ID);
	}
	
	/**
	 * Removes all clients from database
	 */
	public static void wipeClients() {
		clientAccess.wipe();
	}
	
	/**
	 * Removes all containers from database
	 */
	public static void wipeContainers() {
		containerAccess.wipe();
	}
	
	/**
	 * Removes all ports from database
	 */
	public static void wipePorts() {
		portAccess.wipe();
	}
	
	/**
	 * Removes all containers from the history database
	 */
	public static void wipeHistory() {
		historyAccess.wipe();
	}
}
