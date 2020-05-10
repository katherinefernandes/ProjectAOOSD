package supportingClassesTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dataBase.DataBase;
import objects.Client;
import supportingClasses.DataForViewAllJourneys;
import supportingClasses.InputParser;

public class DataForViewAllJourneysTest {

	@Test
	public void test() {
		Client client = new Client(31l,"company",92,23789,"email@eh.com",InputParser.parsingNames("firstname"),InputParser.parsingNames("middlename"),InputParser.parsingNames("lastname"),"g11/2","Islamabad",59,"2620");
		client.save();
		DataForViewAllJourneys data = new DataForViewAllJourneys();
		assertFalse(data.getOutPut().contains("company"));
		client.addActiveShipment(1223333l);
		client.save();
		data = new DataForViewAllJourneys();
		assertTrue(data.getOutPut().contains("company"));
		DataBase.wipeClients();
		
	}
	
	
}
