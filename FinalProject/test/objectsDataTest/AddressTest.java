package objectsDataTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import objectsData.Address;

public class AddressTest {
	private Address testclass;
	
	@Before
	public void testAddress() {
		testclass= new Address("G11/2",59,"Islamabad",2620);
	}

	@Test
	public void testGetStreetName() {
		assertSame("G11/2", testclass.getStreetName());
	}

	@Test
	public void testGetCity() {
		assertSame("Islamabad", testclass.getCity());
	}

	@Test
	public void testGetHouseNumber() {

		assertSame(59, testclass.getHouseNumber());
	}

	@Test
	public void testGetZipCode() {
		assertEquals(2620, testclass.getZipCode());
	}

}
