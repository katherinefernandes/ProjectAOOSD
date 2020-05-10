package objectsTests;

import static org.junit.Assert.*;
import org.junit.jupiter.api.*;

import dataWrappers.InternalStatus;

public class InternalStateTest {
	
	private InternalStatus testobject;
	
	@BeforeEach
	public void testInternalState() {
		testobject = new InternalStatus(1.0f,36.9f,75.0f);
	}

	@Test
	public void testGetAtmosphere() {
		assertEquals((int) 1.0f,(int)testobject.getAtmosphere());
		testobject.setAtmosphere(3.0f);
		assertEquals((int) 3.0f,(int)testobject.getAtmosphere());
	}

	@Test
	public void testGetTemperature() {
		assertEquals((int) 36.9f,(int)testobject.getTemperature());
		testobject.setTemperature(33.0f);
		assertEquals((int) 33.0f,(int)testobject.getTemperature());
	}

	@Test
	public void testGetHumidity() {
		assertEquals((int) 75.0f,(int)testobject.getHumidity());
		testobject.setHumidity(80.0f);
		assertEquals((int) 80.0f,(int)testobject.getHumidity());
	}


}
