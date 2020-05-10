package controllersTest;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import controllers.LoginController;
import dataBase.DataBase;
import objects.Client;
import supportingClasses.InputParser;

public class LoginControllerTest {
	private LoginController controller;

	@Before
	public void initialize() {
		controller = new LoginController();
		
	}
	
	@Test
	public void validClientInfoTest() {
		Client client = new Client(311l,"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
		client.save();
		assertFalse(controller.validClientInfo("mak82"));
		assertFalse(controller.validClientInfo("20000000000"));
		assertTrue(controller.validClientInfo("311"));
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	} 
	
	@Test
	public void validCompanyInfoTest() {
		 assertTrue(controller.validCompanyInfo("admin","admin".toCharArray()));
		 assertFalse(controller.validCompanyInfo("wrong","wrong".toCharArray()));
		 assertFalse(controller.validCompanyInfo("admin","wrong".toCharArray()));
		 assertFalse(controller.validCompanyInfo("wrong","admin".toCharArray()));
		 DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
		
	}

	
	
	}
