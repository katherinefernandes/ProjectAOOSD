package objectsDataTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import objectsData.PortData;
import supportingClasses.Security;

public class PortDataTest {
	
	
	private PortData objectTest;
	private Security ids;
	
	@Before
	public void testPortData() {
		objectTest = new PortData(ids.get_ID(),"Pakistan","gawadar",36.0f,87.0f);
		
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
		
		assertEquals((int)36.0f,(int)objectTest.getPosition().getLatitude());
		
	}

	@Test
	public void testGetStationedContainers() {
		objectTest.addStationedContainer(ids.get_ID());
	}

	@Test
	public void testGetArrivingContainers() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStationedContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddArrivingContainer() {
		fail("Not yet implemented");
	}

}
