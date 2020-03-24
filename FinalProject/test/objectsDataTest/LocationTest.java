package objectsDataTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import objectsData.Location;

public class LocationTest {
	private Location location;
	private float delta=3.6f;
	
	@Before
	public void testLocation() {
		location = new Location(12.35F,36.99F);
	}
	
	@Test
	public void testGetLatitude() {
		assertEquals((int) 12.35f,(int) location.getLatitude());
		location.setLatitude(25.90f);
		assertNotSame((int)12.35f,(int)location.getLatitude());
	}

	@Test
	public void testgetLongitude() {
		assertEquals(36.99f,location.getlongitude(),delta);
		location.setlongitude(367.0f);
		assertNotSame((int)36.99f,(int)location.getlongitude());
	}
}
