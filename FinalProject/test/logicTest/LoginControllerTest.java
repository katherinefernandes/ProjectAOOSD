package logicTest;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import businessObjects.Client;
import graphicalInterface.LoginWindow;
import logic.LoginController;
import supportingClasses.InputParser;

public class LoginControllerTest {
	private LoginController controller;
	private LoginWindow window ;

	@Before
	public void initialize() {
		controller = new LoginController();
		window = new LoginWindow(controller);
		
	}
	
	@Test
	public void validClientInfoTest() {
		Client client = new Client(311l,"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
		client.save();
		assertFalse(controller.validClientInfo("mak82"));
		assertFalse(controller.validClientInfo("20000000000"));
		assertTrue(controller.validClientInfo("311"));
	} 
	
	@Test
	public void validCompanyInfoTest() {
		 assertTrue(controller.validCompanyInfo("admin","admin".toCharArray()));
		 assertFalse(controller.validCompanyInfo("wrong","wrong".toCharArray()));
		 assertFalse(controller.validCompanyInfo("admin","wrong".toCharArray()));
		 assertFalse(controller.validCompanyInfo("wrong","admin".toCharArray()));
		
		
	}
	
	@Test
	public void loginButtonPressedTest() {
		Client client = new Client(311l,"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
		client.save();
		controller.setClientText("311");
		controller.loginButtonPressed(true);
		controller.setCompnyName("admin");
		controller.setCompanyPassword("admin".toCharArray());
		controller.loginButtonPressed(false);
		controller.setClientText("1000000000000");
		controller.loginButtonPressed(true);
		
	}
	
	
	@Test
	public void invokeNextFrameTest() {
		Client client = new Client(311l,"company",92,23789,"email@eh.com",InputParser.parsingNames("Daniela"),InputParser.parsingNames(""),InputParser.parsingNames("Bahneanu"),"g11/2","Islamabad",59,"2620");
		client.save();
		controller.setClientText("311");
		controller.loginButtonPressed(true);
		assertTrue(window.isClientButtonChecked());
		
		
	}
	

	
	
	}
