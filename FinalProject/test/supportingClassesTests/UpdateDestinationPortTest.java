package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supportingClasses.UpdateDestinationPort;

class UpdateDestinationPortTest {

	@Test
	void test() {
		assertThrows(java.lang.Error.class,()->testmethods());
		assertThrows(java.lang.Error.class,()->testmethod2());
	}
	void testmethods() {
		UpdateDestinationPort update = new UpdateDestinationPort();
		update.updatePort(-9l, 90l);
		
	}
	void testmethod2() {
		UpdateDestinationPort update = new UpdateDestinationPort();
		update.updatedestinationPortAtEndOfJourney(-2l, 78l);
	}
	
}
