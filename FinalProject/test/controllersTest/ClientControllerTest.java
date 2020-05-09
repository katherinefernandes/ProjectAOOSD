package controllersTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controllers.ClientController;
import objects.Client;
import objects.Port;
import supportingClasses.InputParser;
import supportingClasses.Security;

class ClientControllerTest {
	ClientController controller;
	
	public  ClientControllerTest() {
		Client client = new Client(Security.generateIDFromSecureRandom(),"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
		client.save();
		controller = new ClientController(Long.toString(client.getID()));
	}
	
	
	
	@Test
	void testSaveReferencePerson() {
		controller.saveReferencePerson("Muna", " ", "azam");
		assertTrue(controller.getcheckMessage());
		controller.saveReferencePerson("Mu991", " ", "azam");
		assertFalse(controller.getcheckMessage());
		controller.saveReferencePerson("Muna", "1", "azam");
		assertFalse(controller.getcheckMessage());
		controller.saveReferencePerson("Muna", " ", "a22");
		assertFalse(controller.getcheckMessage());
		
	}
	@Test
	void testSavePhoneNumber() {
		controller.savePhoneNumber("45", "5566672");
		assertTrue(controller.getcheckMessage());
		controller.savePhoneNumber("mak", "5566672");
		assertFalse(controller.getcheckMessage());
		controller.savePhoneNumber("89111", "5566672");
		assertFalse(controller.getcheckMessage());
		controller.savePhoneNumber("88", "mma");
		assertFalse(controller.getcheckMessage());
		controller.savePhoneNumber("88", "91");
		assertFalse(controller.getcheckMessage());
		controller.savePhoneNumber("11222", "91");
		assertFalse(controller.getcheckMessage());
		
	}
	

	@Test
	void testSaveEmail() {
		controller.saveEmail("email@eamil.com");
		assertTrue(controller.getcheckMessage());
		controller.saveEmail("emaill.com");
		assertFalse(controller.getcheckMessage());
	}

	@Test
	void testGetClientInfo() {
		assertTrue(controller.getCurrentPhoneNumber().contains("23789"),"Should be true");
		assertEquals(controller.getCurrentEmail(),"email@eh.com");
		assertEquals(controller.getCompanyName(),"company");
		assertTrue(controller.getReferencePerson().contains("Daniela"));
		assertTrue(controller.getAddress().contains("Islamabad"));
		assertTrue(controller.getAllActiveShipments().contains("All Active Journeys: "));
		
		
	}

	@Test
	void testSearchContainer() {
		Port port1 = new Port(357983327889100l,"Pakistan","Gwadar",25.11f,62.33f);
		Port port2 = new Port(357983327946100l,"Denmark","Copenhagen",55.70f,12.59f);
		Port port3 = new Port(357983327979100l,"Singapore","Keppel",1.26f,103.83f);
		port2.save();
		port1.save();
		port3.save();
		controller.saveJourney("Gwadar", "Copenhagen", "fruits", "1.0", "10.0","78.0", "02-09-2021");
		assertTrue(controller.getcheckMessage());
		System.out.println(controller.getAllActiveShipments());
		controller.searchContainer("99", "fruits", "random");
		String result = controller.getMulitpleContainersData();
		assertTrue(result.contains("Displaying Up to most 2 Containers: "));
		controller.searchContainer("mm", "fruits", "random");
		
	}


}
