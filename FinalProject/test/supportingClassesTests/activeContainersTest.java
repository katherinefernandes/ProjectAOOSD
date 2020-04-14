package supportingClassesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.*;

import supportingClasses.activeContainers;

class activeContainersTest {
	private activeContainers containerManager;
	

	public activeContainersTest() {
		containerManager = new activeContainers();
	}
	
	@Test
	public void testAssignContainer() {
		boolean value = containerManager.getSetID();
		assertFalse("this should be false",value);
		containerManager.assignContainer();
		assertTrue("this should be true",containerManager.getSetID());
	}

}
