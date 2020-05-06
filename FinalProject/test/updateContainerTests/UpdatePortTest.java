package updateContainerTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import businessObjects.Container;
import businessObjects.Port;
import updateContainer.UpdatePort;

class UpdatePortTest {
	public UpdatePort update;


	@Test 
	void testUpdateInformation(){
		Port port = new Port(90189l,"SomeCountry","SomePort",36.0f,87.0f);
		port.save();
		update = new UpdatePort(90189l);
		Container container = new Container( 91232234l,12342l,892773l, 123442,90189l , 89.0f,  10.0f,  "cargo",  1.0f, 1.0f,  10.0f, "09-10-2020");
		container.save();
		assertFalse(update.getUpdated());
		assertThrows(java.lang.Error.class,()->methodtoruntest());
		
	}
	
	private void methodtoruntest(){
		Port port = new Port(90189l,"SomeCountry","SomePort",36.0f,87.0f);
		port.save();
		update = new UpdatePort(90189l);
		Container container = new Container( 91232234l,12342l,892773l, 123442,90189l , 89.0f,  10.0f,  "cargo",  1.0f, 1.0f,  10.0f, "09-10-2020");
		container.save();
		update.updateInformation(container);
		
	}
	

}
