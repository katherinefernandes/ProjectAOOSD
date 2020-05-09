package dataBase;

import java.util.*;

import exceptions.ElementSelectionException;
import objects.*;
import xmlParser.*;

public class DataBase {
	private static IdentifiablePersistency<Client> clientAccess = new ClientXMLManipulation();
	private static IdentifiablePersistency<Container> containerAccess = new ContainerXMLManipulation();
	private static IdentifiablePersistency<Port> portAccess = new PortXMLManipulation();
	private static GeneralPersistency<Container> historyAccess = new HistoryXMLManipulation();
	
	private DataBase() {} //Should be private. DO NOT CHANGE VISIBILITY
	
	public static List<Client> searchClients(String searchWord) {
		return clientAccess.searchEntries(searchWord);
	}
	
	public static List<Container> searchContainers(String searchWord) {
		return containerAccess.searchEntries(searchWord);
	}
	
	public static List<Port> searchPorts(String searchWord) {
		return portAccess.searchEntries(searchWord);
	}
	
	public static List<Container> searchHistory(String searchWord) {
		return historyAccess.searchEntries(searchWord);
	}
	
	public static Client getClient(long ID) throws ElementSelectionException {
		return clientAccess.getEntry(ID);
	}
	
	public static Container getContainer(long ID) throws ElementSelectionException {
		return containerAccess.getEntry(ID);
	}
	
	public static Port getPort(long ID) throws ElementSelectionException {
		return portAccess.getEntry(ID);
	}
	
	public static void save(Client client) {
		clientAccess.newEntry(client);
	}
	
	public static void save(Container container) {
		containerAccess.newEntry(container);
	}
	
	public static void save(Port port) {
		portAccess.newEntry(port);
	}
	
	public static void saveToHistory(Container historyPoint) {
		historyAccess.newEntry(historyPoint);
	}
	
	//assuming ID's are unique across types
	public static boolean isSavedID(long ID) { 
		return clientAccess.isSavedID(ID) || containerAccess.isSavedID(ID) || portAccess.isSavedID(ID);
	}
	
	public static void deleteClient(long ID) {
		clientAccess.deleteEntry(ID);
	}
	
	public static void deleteContainer(long ID) {
		containerAccess.deleteEntry(ID);
	}
	
	public static void deletePort(long ID) {
		portAccess.deleteEntry(ID);
	}
	
	public static void wipeClients() {
		clientAccess.wipe();
	}
	
	public static void wipeContainers() {
		containerAccess.wipe();
	}
	
	public static void wipePorts() {
		portAccess.wipe();
	}
	
	public static void wipeHistory() {
		historyAccess.wipe();
	}
}
