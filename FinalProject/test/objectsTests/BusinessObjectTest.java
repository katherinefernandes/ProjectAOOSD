package objectsTests;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import dataBase.DataBase;
import objects.BusinessObject;
import objects.Client;
import supportingClasses.InputParser;

public class BusinessObjectTest {

	
	@Test
	public void test() {
		BusinessObject object = new Client(31l,"company",92,23789,"email@eh.com",InputParser.parsingNames("firstname"),InputParser.parsingNames("firstname"),InputParser.parsingNames("firstname"),"g11/2","Islamabad",59,"2620");
		assertFalse(object.equals(null));
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	}
	
	
}
