package objectsDataTest;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.jupiter.api.*;

import objectsData.PortData;

public class PortDataTest {
	
	
	private PortData objectTest;
	
	@BeforeEach
	public void testPortData() {
		objectTest = new PortData(36l,"Pakistan","gawadar",36.0f,87.0f);
		
	}

	@Test
	public void testGetPortID() {
		assertNotSame(122900L,objectTest.getPortID());
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
		assertTrue(objectTest.getStationedContainers().isEmpty());
		objectTest.addStationedContainer(89l);
		assertFalse(objectTest.getStationedContainers().isEmpty());
	}

	@Test
	public void testGetArrivingContainers() {
		assertTrue(objectTest.getArrivingContainers().isEmpty());
		objectTest.addArrivingContainer(30l);
		assertFalse(objectTest.getArrivingContainers().isEmpty());
	}


}
