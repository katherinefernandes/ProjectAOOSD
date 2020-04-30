package logicTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import businessObjects.Client;
import logic.LogisticController;
import supportingClasses.InputParser;

class LogisticsControllerTest {

	private LogisticController controller;

	@Before
	void testLogisticController() {
	  controller = new LogisticController();
	}

	@Test
	void testGetContainerData() {
	
		
	}

	@Test
	void testGetclientsview() {
		Client client = new Client(3113456l,"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
	    client.save(); 
		controller.searchClient("email@eh.com", "company", "7675432245", "Daniela", " ", "Bahneanu" );
		Assert.assertTrue(controller.getclientsview().contains("email@eh.com"));
	} 

//	@Test
//	void testAddNewClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateContainerPosition() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateContainerStatus() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCheckMessage() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchClient() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllJourneys() {
//		fail("Not yet implemented");
//	}
//
}
