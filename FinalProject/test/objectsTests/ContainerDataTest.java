package objectsTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.jupiter.api.*;

import dataBase.DataBase;
import objects.Container;
import objects.Port;

public class ContainerDataTest {
	private Container objectTest;
	private Container objectTest2;
	private long cid =78l;
	private long clid=87l;
	private long jid=74l;
	private long spid=75l;
	private long dpid=72l; 
	private float lat= 8.7f;
	private float lon= 78.9f;
	private Port startPort = new Port(spid, "Denmark", "Nyhavn", lat, lon);
	private String cargo="banana";
	private float t =36.8f;
	private float a=1.2f;
	private float h=78.0f;
	private String arriveby = "09-08-2020";	
	
	@BeforeEach
	public void testContainerData() {
		
		objectTest = new Container( cid,clid, jid, spid,  dpid,  lat,  lon,  cargo,  t,  a,  h, (arriveby));
		objectTest2 = new Container(cid,startPort);
		
	}
	
	@Test
	public void equalityTest() {
		Container objectTest3 = new Container( cid,clid, jid, spid,  dpid,  lat,  lon,  cargo,  t,  a,  h, (arriveby));
		assertTrue(objectTest.equals(objectTest3));
	}
	
	@Test
	public void testUseContainerAgain() {
		assertSame(cargo,objectTest.getCargo());
		objectTest.useContainerAgain(clid, jid, spid,  dpid,  "apple",  t,  a,  h, (arriveby));
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
		objectTest.setInternalStatus(a, 32.0f, h);
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
		assertEquals(0l,objectTest2.getJourneyID());
		objectTest2.setJourneyID(jid);
		assertEquals(jid,objectTest2.getJourneyID());
	}

	@Test
	public void testGetClientID() {
		assertEquals(clid,objectTest.getClientID());
		assertEquals(0l,objectTest2.getClientID());
		objectTest2.setClientID(clid);
		assertEquals(clid,objectTest2.getClientID());
	}

	@Test
	public void testGetDestinationPortID() {
		assertEquals(dpid,objectTest.getDestinationPortID());
		assertEquals(spid,objectTest2.getDestinationPortID());
		objectTest2.setDestinationPortID(dpid);
		assertEquals(dpid,objectTest2.getDestinationPortID());
	}

	@Test
	public void testGetStartPortID() {
		assertEquals(spid,objectTest.getStartPortID());
		assertEquals(spid,objectTest2.getStartPortID());
		objectTest2.setStartPortID(dpid);
		assertEquals(dpid,objectTest2.getStartPortID());
		
	}
	
	@Test
	public void testSetUpdated() {
		objectTest2.setUpdated("09-10-2020");
		assertTrue(objectTest2.getUpdated().equals("09-10-2020"));
	}
	
	@Test
	public void testgetAllValues() {
		List<String> values = objectTest2.getAllValues();
		assertTrue(values.get(0).equals(Long.toString(objectTest2.getID())));
	}

	@AfterEach
	public void cleanData() {
		DataBase.wipeClients();
		DataBase.wipeContainers();
		DataBase.wipeHistory();
		DataBase.wipePorts();
	}
	
}
