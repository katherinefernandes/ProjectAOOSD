package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import supportingClasses.activeContainers;

class activeContainersTest {
	private activeContainers containerManager;
	
	@Before
	public void activeContainersTests() {
		containerManager = new activeContainers();
	}
	
	@Test
	public void testAssignContainer() {
		assertFalse(containerManager.getSetID(),"It should be false");
		long containerID =containerManager.assignContainer();
		assertTrue(containerManager.getSetID(),"It should be true");
	}

}
