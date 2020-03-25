package objectsDataTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import objectsData.ClientData;

public class ClientDataTest {
	private ClientData objectTest;
	private ArrayList<String> middlename = new ArrayList<String>();
	
	
	@Before
	public void testClientData() {
		objectTest = new ClientData(31l,"company",23789,"email@eh.com","Muna",middlename,"azam","g11/2","Islamabad",59,2620);
	}

	
	@Test
	public void testGetClientID() {
		assertEquals((int) 31l,(int)objectTest.getClientID());
	}

	@Test
	public void testGetCompanyName() {
		assertSame("company",objectTest.getCompanyName());
	}

	@Test
	public void testGetPhoneNumber() {
		
		assertEquals(23789,objectTest.getPhoneNumber());
		objectTest.setPhoneNumber(3690);
		assertEquals(3690,objectTest.getPhoneNumber());
		
	}

	@Test
	public void testGetEmail() {
		
		assertSame("email@eh.com",objectTest.getEmail());
		objectTest.setEmail("mail@eh.com");
		assertSame("mail@eh.com",objectTest.getEmail());
		
		
	}

	@Test
	public void testGetPerson() {
		
		assertSame("azam",objectTest.getPerson().getLastName());
		middlename.add("J");
		objectTest.setPerson("muna1",middlename, "azzam");
		assertSame("J",objectTest.getPerson().getMiddleName().remove(0));
		
	}

	@Test
	public void testGetAddress() {
		
		assertSame("Islamabad",objectTest.getAddress().getCity());
		
	}

	@Test
	public void testGetActiveShipment() {
		
		assertTrue(objectTest.getActiveShipment().isEmpty());
		objectTest.addActiveShipment(3090l);
		assertFalse(objectTest.getActiveShipment().isEmpty());
		
	}

}
