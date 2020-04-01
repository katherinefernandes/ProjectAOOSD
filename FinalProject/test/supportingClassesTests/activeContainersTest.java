package supportingClassesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.jupiter.api.*;

import supportingClasses.activeContainers;

class activeContainersTest {
	private activeContainers containerManager;
	
	@Before
	public void activeContainersTests() {
		containerManager = new activeContainers();
	}
	
	@Test
	public void testAssignContainer() {
		assertFalse(containerManager.getSetID());
		long containerID =containerManager.assignContainer();
		assertTrue("It should be true",containerManager.getSetID());
	}

}
