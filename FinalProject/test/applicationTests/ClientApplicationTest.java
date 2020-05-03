package applicationTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import applications.ClientApplication;
import businessObjects.Client;
import supportingClasses.InputParser;
import supportingClasses.Security;

class ClientApplicationTest {

	@Test
	void testClientApplication() {
		assertThrows(java.lang.Error.class,()->new ClientApplication(0l));
	}

	
	
	@Test
	void testRegisterContainerForAJourney() {
		assertThrows(java.lang.Error.class,()->testclass());
	}
	
	void testclass() {
		Client client =  new Client(1000000000l,"company",92,23789,"email@eh.com",InputParser.parsingNames("firstname"),InputParser.parsingNames("middlename"),InputParser.parsingNames("lastname"),"g11/2","Islamabad",59,"2620");
		client.save();
		ClientApplication app = new ClientApplication(1000000000l);
		app.registerContainerForAJourney(Security.generateIDFromSecureRandom(), 23l, "cargo", 0.2f, 1.0f, 78.0f, "09-12-2021");
		
	}
	

}
