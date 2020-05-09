package businessObjectsTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import objects.Client;
import objects.Port;

public class ClientDataTest {
	private Client objectTest;
	private ArrayList<String> middlename = new ArrayList<String>();
	private ArrayList<String> firstname = new ArrayList<String>();
	private ArrayList<String> lastname = new ArrayList<String>();
	
	@BeforeEach
	public void testClientData() {
		firstname.add("Muna");
		lastname.add("azam");
		objectTest = new Client(31l,"company",92,23789,"email@eh.com",firstname,middlename,lastname,"g11/2","Islamabad",59,"2620");
	}
	
	@Test
	public void equalityTest() {
		Client objectTest2 = new Client(31l,"company",92,23789,"email@eh.com",firstname,middlename,lastname,"g11/2","Islamabad",59,"2620");
		assertTrue(objectTest.equals(objectTest2));
	}
	
	@Test
	public void testGetClientID() {
		assertEquals((int) 31l,(int)objectTest.getID());
	}

	@Test
	public void testGetCompanyName() {
		assertSame("company",objectTest.getCompanyName());
	}

	@Test
	public void testGetPhoneNumber() {
		
		assertEquals(23789,objectTest.getPhoneNumber().getPhone());
		objectTest.setPhoneNumber(92,3690);
		assertEquals(3690,objectTest.getPhoneNumber().getPhone());
		
	}

	@Test
	public void testGetEmail() {
		
		assertSame("email@eh.com",objectTest.getEmail());
		objectTest.setEmail("mail@eh.com");
		assertSame("mail@eh.com",objectTest.getEmail());
		
		
	}

	@Test
	public void testGetPerson() {
		
		assertSame("azam",objectTest.getPerson().getLastName().get(0));
		middlename.add("J");
		objectTest.setPerson(firstname,middlename, lastname);
		assertSame("J",objectTest.getPerson().getMiddleName().remove(0));
		
	}

	@Test
	public void testGetAddress() {
		
		assertSame("Islamabad",objectTest.getAddress().getCity());
		
	}

	@Test
	public void testGetActiveShipment() {
		
		assertTrue(objectTest.getActiveShipments().isEmpty());
		objectTest.addActiveShipment(3090l);
		assertFalse(objectTest.getActiveShipments().isEmpty());
		
	}
	
	@Test
	public void testGetAllValues() {
		objectTest.addActiveShipment(3090l);
		objectTest.setFinishedShipment(89728l);
		List<String> values = objectTest.getAllValues();
		assertTrue(values.get(0).equals(Long.toString(objectTest.getID())));
		
	}

}
