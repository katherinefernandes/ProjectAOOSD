package supportingClassesTests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import businessObjects.Port;
import supportingClasses.ExtractingPortID;

class ExtractingPortIDTest {

	//The reason why i am using the class and not the static method is for coverage, idk why but it doesnot cover the class otherwise
	//Mamuna
	@Test
	void testGetPortID() {
		Port p1 = new Port(789l,"country","empty",36.0f,87.0f);
		p1.save();
		assertEquals((int)new ExtractingPortID().getPortID("empty"),(int)789l);
		assertEquals((int)new ExtractingPortID().getPortID("someportname"),(int)1l);
	}

}
