package dataBase;

import java.util.*;

import exceptions.ElementNotFoundException;
import objectsData.*;
import xmlParser.*;

public class DataBase {
	private static IdentifiablePersistency<ClientData> clientAccess = new ClientXMLManipulation();
	private static IdentifiablePersistency<ContainerData> containerAccess = new ContainerXMLManipulation();
	private static IdentifiablePersistency<PortData> portAccess = new PortXMLManipulation();
	private static GeneralPersistency<HistoryData> historyAccess = new HistoryXMLManipulation();
	
	private DataBase() {} //Should be private. DO NOT CHANGE VISIBILITY
	
	public static List<ClientData> searchClients(String searchWord) {
		return clientAccess.searchEntries(searchWord);
	}
	
	public static List<ContainerData> searchContainers(String searchWord) {
		return containerAccess.searchEntries(searchWord);
	}
	
	public static List<PortData> searchPorts(String searchWord) {
		return portAccess.searchEntries(searchWord);
	}
	
	public static List<HistoryData> searchHistory(String searchWord) {
		return historyAccess.searchEntries(searchWord);
	}
	
	public static ClientData getClient(long ID) throws ElementNotFoundException {
		return clientAccess.getEntry(ID);
	}
	
	public static ContainerData getContainer(long ID) throws ElementNotFoundException {
		return containerAccess.getEntry(ID);
	}
	
	public static PortData getPort(long ID) throws ElementNotFoundException {
		return portAccess.getEntry(ID);
	}
	
	public static void save(ClientData client) {
		clientAccess.newEntry(client);
	}
	
	public static void save(ContainerData container) {
		containerAccess.newEntry(container);
	}
	
	public static void save(PortData port) {
		portAccess.newEntry(port);
	}
	
	public static void save(HistoryData historyPoint) {
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
