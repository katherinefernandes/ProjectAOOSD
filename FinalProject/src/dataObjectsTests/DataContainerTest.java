package dataObjectsTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dataObjects.DataContainer;
import dataObjects.InternalStatus;

public class DataContainerTest {
	private DataContainer container;
	private InternalStatus object;
	@Before
	public void testDataContainer() {
		container = new DataContainer(1,2,"banana", 4, "denmark", "Pakistan", new Date());
		
	}
	@Before
	public void createInternalStatus() {
		object = new InternalStatus(1,25,79);
	}
	
	@Test
	public void testSetCurrentLocation() {
		container.setCurrentLocation("Austria");
		assertEquals("should be equal","Austria",container.getCurrentLocation());
	}
	
	@Test
	public void testgetIntenalStatus() {
		assertEquals("should be equal",object.getTemperature(),container.getIntenalStatus().getTemperature());
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
		container.getIntenalStatus().setTemperature(30);
		assertEquals(container.getIntenalStatus().getTemperature(),object.getTemperature());
	}

	@Test
	public void testGetHumidity() {
		assertEquals(79,object.getHumidity());
		object.setHumidity(30);
		assertEquals(30,object.getHumidity());
	}
}
