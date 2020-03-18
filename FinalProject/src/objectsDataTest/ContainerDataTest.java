package objectsDataTest;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import objectsData.ContainerData;
import objectsData.InternalStatusData;

public class ContainerDataTest {
	private ContainerData container;
	private InternalStatusData object;
	private Date date;
	@Before
	public void testDataContainer() {
		container = new ContainerData(1,2,"banana", 4, "denmark", "Pakistan", new Date());
		date = new Date();
	}
	@Before
	public void createInternalStatus() {
		object = new InternalStatusData(1,25,79);
	}
	
	@Test
	public void testgetStartLocation() {
		assertEquals("denmark",container.getStartLocation());
	}
	
	@Test
	public void testgetDestination() {
		assertEquals("Pakistan",container.getDestination());
	}
	@Test
	public void testgetDeadline() {
		assertNotEquals(32,container.getDeadline());
	}
	@Test
	public void testgetContainerId() {
		assertEquals(1,container.getContainerId());
	}
	@Test
	public void testgetClientId() {
		assertNotEquals(1,container.getClientId());
	}
	
	@Test
	public void testgetJourneyId() {
		assertEquals(4,container.getJourneyId());
	}
	@Test
	public void testgetContains() {
		assertEquals("banana",container.getContains());
	}
	
	@Test
	public void testSetCurrentLocation() {
		container.setCurrentLocation("Austria");
		assertEquals("should be equal","Austria",container.getCurrentLocation());
	}
	
	@Test
	public void testgetIntenalStatus() {
		assertEquals("should be equal",object.getTemperature(),container.getInternalStatus().getTemperature());
	}
	
	@Test
	public void testsetIntenalStatus() {
		container.setInternalStatus(object);
		assertEquals("should be equal",object.getTemperature(),container.getInternalStatus().getTemperature());
	}
	
	@Test
	public void testGetPressure() {
		assertEquals(1,object.getPressure());
		object.setPressure(30);
		assertEquals(30,object.getPressure());
	}

	@Test
	public void testGetTemperature() {
		assertEquals(25,object.getTemperature());
		object.setTemperature(30);
		container.getInternalStatus().setTemperature(30);
		assertEquals(container.getInternalStatus().getTemperature(),object.getTemperature());
	}

	@Test
	public void testGetHumidity() {
		assertEquals(79,object.getHumidity());
		object.setHumidity(30);
		assertEquals(30,object.getHumidity());
	}
}
