package supportingClassesTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import businessObjects.Port;
import supportingClasses.ExtractingPortID;

class ExtractingPortIDTest {

	@Test
	void testGetPortID() {
		Port p1 = new Port(789l,"country","empty",36.0f,87.0f);
		p1.save();
		ExtractingPortID getPortID = new ExtractingPortID();
		assertEquals((int)getPortID.getPortID("empty"),(int)789l);
		assertEquals((int)getPortID.getPortID("someportname"),(int)1l);
	}

}
