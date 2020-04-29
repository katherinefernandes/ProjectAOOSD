package logicTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import logic.LogisticController;


class LogisticControllerTest {
	private LogisticController controller;
	
	@Test
	void testUpdateStatus() { 
		
		controller = new LogisticController();
		Assert.assertFalse(controller.updateStatus("pressure", "23423234", "2342323"));
		Assert.assertFalse(controller.updateStatus("2222", "d234234234", "2342323"));
		Assert.assertFalse(controller.updateStatus("89", "2342334", "2s4234233"));
		
		Assert.assertFalse(controller.updateStatus("", "2342344", "23423423"));
		
		Assert.assertTrue(controller.updateStatus("234234", "2342334", "234234"));
		
		//fail("Not yet implemented");
	}

	@Test
	void testGetContainerData() {
	//idk how to write this one 
	
	}
	
		
		
		

	@Test
	void testFindClientByEmail() {
		Assert.assertFalse(controller.findClientByEmail("invalid"));
		Assert.assertTrue(controller.findClientByEmail("email@eh.com"));
		
	}

	@Test
	void testFindClientByCompanyName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindClientByPhone() {
		fail("Not yet implemented");
	}

	@Test
	void testFindClientByReferencePerson() {
		fail("Not yet implemented");
	}

	@Test
	void testViewClient() {
		fail("Not yet implemented");
	}

	@Test
	void testAddNewClient() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateContainerPosition() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateContainerStatus() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckMessage() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchClient() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllJourneys() {
		fail("Not yet implemented");
	}

}
