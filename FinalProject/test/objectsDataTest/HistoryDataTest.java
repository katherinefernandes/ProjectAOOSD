package objectsDataTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.*;

import objectsData.HistoryData;

public class HistoryDataTest {

	private HistoryData objectTest;
	
	@Before
	public void testHistoryData() {
		objectTest = new HistoryData(45l,36l,78l,89l,90l,"Banana",36.0f,1.0f,75.0f,56.0f,7.8f);
		
	}

	@Test
	public void testGetTimeStamp() {
		assertNotSame(LocalDateTime.now(),objectTest.getTimeStamp());
	}

	@Test
	public void testGetContainerID() {
		assertEquals(45,(int) objectTest.getContainerID());
		
		
	}

	@Test
	public void testGetJourneyID() {
		assertEquals(36,(int) objectTest.getJourneyID());
		
		
	}

	@Test
	public void testGetClientID() {
		assertEquals(78,(int) objectTest.getClientID());
		
	}

	@Test
	public void testGetDestinationPortID() {
		assertEquals(89,(int) objectTest.getDestinationPortID());
		
	}

	@Test
	public void testGetStartPortID() {
		assertEquals(90,(int) objectTest.getStartPortID());
	}

	@Test
	public void testGetCargo() {
		assertSame("Banana",objectTest.getCargo());
		
	}

	@Test
	public void testGetInternalStatus() {
		assertEquals((int)36,(int)objectTest.getInternalStatus().getTemperature());
	}

	@Test
	public void testGetLocation() {
		assertEquals((int)7.8,(int)objectTest.getLocation().getlongitude());
		
	}

}
