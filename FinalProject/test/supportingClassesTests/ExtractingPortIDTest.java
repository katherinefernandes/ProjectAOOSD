package supportingClassesTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import businessObjects.Port;
import supportingClasses.ExtractingPortID;

class ExtractingPortIDTest {

	@Test
	void testGetPortID() {
		Port p1 = new Port(789l,"country","empty",36.0f,87.0f);
		p1.save();
		assertEquals((int)ExtractingPortID.getPortID("empty"),(int)789l);
		assertEquals((int)ExtractingPortID.getPortID("someportname"),(int)1l);
	}

}
