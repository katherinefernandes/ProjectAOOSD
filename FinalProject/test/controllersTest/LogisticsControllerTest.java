package controllersTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import controllers.LogisticController;
import dataBase.DataBase;
import objects.Client;
import objects.Container;
import supportingClasses.InputParser;

class LogisticsControllerTest {
    private LogisticController controller = new LogisticController();


	@Test
	void testAddNewClient() {
		
		assertTrue(controller.addNewClient("23", "234", "Copenhagen", "Sesame", "Bahneanu", " ", "Daniela", "949494949", "45", "dani@gmail.com", "freesocks"),"add new client should be successful");
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
		
	}

	@Test
	void testUpdateContainerPosition() {
		Container container = new Container(20711569474800L, 102621L, 675465457L, 357983327889100L, 357983327946100L, 357983327979100L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 2, 11, 14, 24).toString(),LocalDateTime.now().toString());
	    container.save();
	    assertFalse(controller.checkMessage());
	    controller.updateContainerPosition("20711569474800", "10", "29");
	    List<Container> containers = DataBase.searchContainers("20711569474800");
	    assertEquals(containers.get(0).getCargo(),"Fish n' chips");
	    DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	    
	}

	@Test
	void testUpdateContainerStatus() {
		Container container = new Container(20711569474800L, 102621L, 675465457L, 357983327889100L, 357983327946100L, 357983327979100L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 2, 11, 14, 24).toString(),LocalDateTime.now().toString());
	    container.save();
	    assertFalse(controller.checkMessage());
	    controller.updateContainerStatus("20711569474800", "10", "29","50");
	    List<Container> containers = DataBase.searchContainers("20711569474800");
	    assertEquals(containers.get(0).getCargo(),"Fish n' chips");
	    DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	}  

	@Test
	void testSearchClient() {
		Client client = new Client(555555555557L,"Washington cleaning",45,
				123456789,"clean.your.pipes@wash.com",
				InputParser.parsingNames("Daniela"),InputParser.parsingNames(" "),InputParser.parsingNames("Bahneanu"),
				"Bakerstreet","Derry",42,"1213");
		client.save();
		controller.searchClient("clean.your.pipes@wash.com", "dvdf vssd", "6564433232", "Daniela", "fssdsdsd", "Sascasas");
		assertTrue(controller.checkMessage());
		System.out.println("Client found: "+controller.checkMessage());
		String result = controller.getclientsview();
		System.out.println("result"+result);
		assertTrue(result.contains("clean.your.pipes@wash.com"));
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	}

	@Test
	void testGetAllJourneys() {
	    String result = controller.getAllJourneys();
	    DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	    
	    
	    
	}
	
	@Test
	void testUpdateContainerPort() {
		Container container = new Container(20711569474800L, 102621L, 675465457L, 357983327889100L, 357983327946100L, 357983327979100L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 2, 11, 14, 24).toString(),LocalDateTime.now().toString());
	    container.save();
	    assertFalse(controller.checkMessage());
	    controller.updateContainerPort("20711569474800","Copenhagen");
	    List<Container> containers = DataBase.searchContainers("20711569474800");
	    assertEquals(containers.get(0).getCargo(),"Fish n' chips");
	    DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();

	}  

}
