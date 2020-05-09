package supportingClassesTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import dataBase.DataBase;
import objects.Port;
import supportingClasses.ExtractingPortID;

class ExtractingPortIDTest {

	@Test
	void testGetPortID() {
		Port p1 = new Port(789l,"country","empty",36.0f,87.0f);
		p1.save();
		assertEquals((int)new ExtractingPortID().getPortID("empty"),(int)789l);
		assertEquals((int)new ExtractingPortID().getPortID("someportname"),(int)1l);

		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
		
	}

}
