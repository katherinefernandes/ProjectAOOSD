package objectsTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.*;

import dataBase.DataBase;
import objects.Port;
import supportingClasses.Security;

public class PortDataTest {
	
	
	private Port objectTest;
	
	@BeforeEach
	public void testPortData() {
		objectTest = new Port(6778l,"Pakistan","gawadar",36.0f,87.0f);
		objectTest.addArrivingContainer(8882l);
		objectTest.addStationedContainer(99110l);
	}
	
	@Test
	public void equalityTest() {
		Port objectTest1 = new Port(67781,"Pakistan","gawadar",36.0f,87.0f);
		objectTest1.addArrivingContainer(8882l);
		objectTest1.addStationedContainer(99110l);
		Port objectTest2 = new Port(67781,"Pakistan","gawadar",36.0f,87.0f);
		objectTest2.addArrivingContainer(8882l);
		objectTest2.addStationedContainer(99110l);
		assertTrue(objectTest1.equals(objectTest2));
	}

	@Test
	public void testGetPortID() {
		assertNotSame(122900L,objectTest.getID());
	}

	@Test
	public void testGetCountry() {
		assertSame("Pakistan",objectTest.getCountry());
	}

	@Test
	public void testGetPortName() {
		assertSame("gawadar",objectTest.getPortName());
	}

	@Test
	public void testGetPosition() {
		
		assertSame((int)36.0f,(int)objectTest.getPosition().getLatitude());
		
	}

	@Test
	public void testGetStationedContainers() {
	objectTest.addStationedContainer(89l);
		assertFalse(objectTest.getStationedContainers().isEmpty());
	}

	@Test
	public void testGetArrivingContainers() {
		objectTest.addArrivingContainer(30l);
		assertFalse(objectTest.getArrivingContainers().isEmpty());
	}

	@Test
	public void testGetAllValues() {
		List<String> allvalues = objectTest.getAllValues();
		assertTrue(allvalues.get(0).equals(Long.toString(objectTest.getID())));
	}

	@Test
	public void testContainerIDForJourneyRegisteration() {
		objectTest.addStationedContainer(Security.generateIDFromSecureRandom());
		assertTrue(objectTest.containerIDForJourneyRegisteration()>0);
		
		
	}
	
	@AfterEach
	public void cleanData() {
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	}
}
