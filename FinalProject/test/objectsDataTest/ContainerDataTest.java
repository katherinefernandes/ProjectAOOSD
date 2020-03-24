package objectsDataTest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

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
	
	
	@Before
	public void testContainerData() {
		
		objectTest = new ContainerData( cid,clid, jid, spid,  dpid,  lat,  lon,  cargo,  t,  a,  h, arriveby);
		
		
	}

	@Test
	public void testUseContainerAgain() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCurrentPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrentPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUpdated() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArriveBy() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContainerID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetJourneyID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClientID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDestinationPortID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStartPortID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCargo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInternalStatus() {
		fail("Not yet implemented");
	}

}
