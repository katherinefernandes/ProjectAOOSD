package objectsDataTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.*;

import objectsData.ContainerData;

public class ContainerDataTest {
	private ContainerData objectTest;
	private long cid =78l;
	private long clid=87l;
	private long jid=74l;
	private long spid=75l;
	private long dpid=72l; 
	private float lat= 8.7f;
	private float lon= 78.9f;
	private String cargo="banana";
	private float t =36.8f;
	private float a=1.2f;
	private float h=78.0f;
	private LocalDateTime arriveby = LocalDateTime.now();
	
	
	@BeforeEach
	public void testContainerData() {
		
		objectTest = new ContainerData( cid,clid, jid, spid,  dpid,  lat,  lon,  cargo,  t,  a,  h, arriveby);
	 
		
	}
	
	@Test
	public void testUseContainerAgain() {
		assertSame(cargo,objectTest.getCargo());
		objectTest.useContainerAgain(clid, jid, spid,  dpid,  lat,  lon,  "apple",  t,  a,  h, arriveby);
		assertSame("apple",objectTest.getCargo());
	}

	@Test
	public void testSetCurrentPosition() {
			assertEquals((int)lat,(int)objectTest.getCurrentPosition().getLatitude());
			objectTest.setCurrentPosition(34.0f, 36.9f);
			assertEquals((int)34.0f,(int)objectTest.getCurrentPosition().getLatitude());
	}

	@Test
	public void testSetStatus() {
		assertEquals((int)t,(int)objectTest.getInternalStatus().getTemperature());
		objectTest.setStatus(a, 32.0f, h);
		assertEquals((int)32.0f,(int)objectTest.getInternalStatus().getTemperature());
	
	}

	@Test
	public void testGetUpdated() {
		assertNotSame(arriveby,objectTest.getUpdated());
		
	}

	@Test
	public void testGetArriveBy() {
		assertSame(arriveby,objectTest.getArriveBy());
	}

	@Test
	public void testGetContainerID() {
		assertEquals(cid,objectTest.getID());
	}

	@Test
	public void testGetJourneyID() {
		assertEquals(jid,objectTest.getJourneyID());
	}

	@Test
	public void testGetClientID() {
		assertEquals(clid,objectTest.getClientID());
	}

	@Test
	public void testGetDestinationPortID() {
		assertEquals(dpid,objectTest.getDestinationPortID());
	}

	@Test
	public void testGetStartPortID() {
		assertEquals(spid,objectTest.getStartPortID());
	}

}
