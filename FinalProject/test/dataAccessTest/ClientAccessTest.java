package dataAccessTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import dataAccess.NodeMethods;

public class ClientAccessTest {
	ClientData client1;
	ClientData client2;
	ClientData client1_v2;
	ArrayList<ClientData> sortTestClients;
	ArrayList<Long> toBeDeleted;
	ClientAccess clientAccess;
	Random random;
	NodeMethods nodeMethods;
	
	public ClientAccessTest() {
		clientAccess = new ClientAccess();
		nodeMethods = new NodeMethods();
		random = new Random();
		sortTestClients = new ArrayList<ClientData>();

		ArrayList<String> firstNames1 = new ArrayList<String>();
		firstNames1.add("Rincewind");
		ArrayList<String> middleNames1 = new ArrayList<String>();
		middleNames1.add("S.");
		middleNames1.add("Thompson");
		middleNames1.add("Providence");
		ArrayList<String> lastNames1 = new ArrayList<String>();
		lastNames1.add("Marx");

		client1 = new ClientData(102621L,"Washington cleaning",45,
								123456789,"clean.your.pipes@wash.com",
								firstNames1,middleNames1,lastNames1,
								"Bakerstreet","Derry",42,"1213");
		
		ArrayList<String> firstNames2 = new ArrayList<String>();
		firstNames2.add("Lord");
		firstNames2.add("Thomas");
		ArrayList<String> middleNames2 = new ArrayList<String>();
		middleNames2.add("of");
		middleNames2.add("Rivendell");
		ArrayList<String> lastNames2 = new ArrayList<String>();
		lastNames2.add("the");
		lastNames2.add("Third");

		client2 = new ClientData(2530321L,"Trucking brothers AS",47,
								666663436,"trucker.m.f@gmail.com",
								firstNames2,middleNames2,lastNames2,
								"Elm street","Arkham",33,"2000");
		
		client1_v2 = new ClientData(102621L,"new Washington cleansing",46,
									123456789,"clean.your.pipes@wash.com",
									firstNames1,middleNames1,lastNames1,
									"Bakerstreet","Darry",42,"1216");
		client1.addActiveShipment(1766465L);
		client1.addActiveShipment(8923892L);
		client1.addActiveShipment(10390101L);
		
		for (int i = 0; i < 200; i++) {
			long ID = Math.abs(random.nextLong());
			ArrayList<String> firstName = new ArrayList<>();
			ArrayList<String> middleName = new ArrayList<>();
			ArrayList<String> lastName = new ArrayList<>();
			firstName.add("a");
			middleName.add("a");
			lastName.add("a");
			
			sortTestClients.add(new ClientData(ID,"a",1,1,"a",firstName,middleName,lastName,"a","a",1,"1"));
		}
		
		toBeDeleted = new ArrayList<Long>();
	}
	
	@AfterEach
	public void CleanUp() {
		for(long ID : toBeDeleted) {
			try {
				clientAccess.deleteEntry(ID);
			} catch (DOMException e) {
				fail("DOMException in clean up");
				e.printStackTrace();
			} catch (ElementNotFoundException e) {
			}
		}
		toBeDeleted = new ArrayList<Long>();
	}
	
	@Test
	public void persistencyTest() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException {
		insertClient(client1);
	
		ClientData pulledClient = clientAccess.getEntry(client1.getClientID());
		
		assertEqualClients(pulledClient,client1);
	}
	
	@Test
	public void editTest() throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		insertClient(client1);
		clientAccess.editEntry(client1_v2);
		ClientData pulledClient = clientAccess.getEntry(client1.getClientID());
		
		assertEqualClients(pulledClient,client1_v2);
	}
	
	@Test
	public void sortTest() {
		for(ClientData clientData : sortTestClients) {
			insertClient(clientData);
		}
		
		NodeList clients = clientAccess.getRoot().getChildNodes();
		int clientsLen = clients.getLength();
		long previousID = nodeMethods.getElementID((Element) clients.item(0));
		for(int i = 1; i < clientsLen; i++) {
			long currentID = nodeMethods.getElementID((Element) clients.item(i));
			assertTrue(previousID < currentID);
			previousID = currentID;
		}
	}
	
	@Test
	public void exceptionTest() {
		insertClient(client1);
		insertClient(client2);
	}
	
	
	
	public void assertEqualClients(ClientData clientX, ClientData clientY) {
		assertEquals(clientY.getClientID(),clientX.getClientID());
		assertEquals(clientY.getCompanyName(),clientX.getCompanyName());
		assertEquals(clientY.getPhoneNumber().getCountryCode(),clientX.getPhoneNumber().getCountryCode());
		assertEquals(clientY.getPhoneNumber().getPhone(),clientX.getPhoneNumber().getPhone());
		assertEquals(clientY.getEmail(),clientX.getEmail());
		assertEquals(clientY.getPerson().getFirstName(),clientX.getPerson().getFirstName());
		assertEquals(clientY.getPerson().getMiddleName(),clientX.getPerson().getMiddleName());
		assertEquals(clientY.getPerson().getLastName(),clientX.getPerson().getLastName());
		assertEquals(clientY.getAddress().getStreetName(),clientX.getAddress().getStreetName());
		assertEquals(clientY.getAddress().getCity(),clientX.getAddress().getCity());
		assertEquals(clientY.getAddress().getHouseNumber(),clientX.getAddress().getHouseNumber());
		assertEquals(clientY.getAddress().getZipCode(),clientX.getAddress().getZipCode());
		List<Long> journeyIDsX = clientX.getActiveShipment();
		List<Long> journeyIDsY = clientY.getActiveShipment();
		
		for(int i = 0; i < Math.max(journeyIDsX.size(),journeyIDsY.size()); i++) {
			assertEquals(journeyIDsX.get(i),journeyIDsY.get(i));
		}
	}
	
	public void insertClient(ClientData clientData) {
		clientAccess.newEntry(clientData);
		toBeDeleted.add(clientData.getClientID());
	}
}
