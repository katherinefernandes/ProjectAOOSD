package persistencyTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementSelectionException;

public class ContainerAccessTest extends IdentifiableDataAccessTest<Container>{

	public ContainerAccessTest() {
		super();
		
		data1 = new Container(20711569474800L, 102621L, 675465457L, 53354L, 755356L, 1724637126L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 2, 11, 14, 24).toString(),LocalDateTime.now().toString());
		data2 = new Container(6755L, 2530321L, 4533566L, 3434568L, 35668556L, 32764273472L, 55.6F, 22.87F, "Lard", 7F, 102F, 44F,LocalDateTime.of(2020, 5, 21, 12, 34).toString(),LocalDateTime.now().toString());
		data1_v2 = new Container(20711569474800L, 182321L, 675465457L, 755356L, 7783874L, 23172351252L, 55.6F, 36.787F, "Fish n' lard", 3.8F, 100.2F, 86F, LocalDateTime.of(2020, 5, 21, 12, 34).toString(),LocalDateTime.now().toString());
		data1.setLastVisitedPort(1241524123L);
		
		for(int i = 0; i < 20; i++) {
			long ID = random.nextLong();
			sortTestData.add(new Container(ID, 1L, 1L, 1L, 1L, 1L, 1F, 1F, "a", 1F, 1F, 1F, LocalDateTime.of(2020, 6, 12, 21, 1).toString(),LocalDateTime.now().toString()));
		}
	}
	
	@Test
	public void persistencyTestT() throws NumberFormatException, ElementSelectionException {
		persistencyTest(); }
	@Test
	public void editTestT() throws NumberFormatException, ElementSelectionException {
		editTest(); }
	
	@Override
	protected void delete(long ID) {
		DataBase.deleteContainer(ID);
	}
	@Override
	protected Container getObject(long ID) throws ElementSelectionException {
		return DataBase.getContainer(ID);
	}
	@Override
	public void assertEqualData(Container container1, Container container2) {
		assertEquals(container1.getID(),container2.getID());
		assertEquals(container1.getClientID(),container2.getClientID());
		assertEquals(container1.getJourneyID(),container2.getJourneyID());
		assertEquals(container1.getStartPortID(),container2.getStartPortID());
		assertEquals(container1.getLastVisitedPortID(),container2.getLastVisitedPortID());
		assertEquals(container1.getDestinationPortID(),container2.getDestinationPortID());
		assertEquals(container1.getCurrentPosition().getLatitude(),container2.getCurrentPosition().getLatitude());
		assertEquals(container1.getCurrentPosition().getLongitude(),container2.getCurrentPosition().getLongitude());
		assertEquals(container1.getCargo(),container2.getCargo());
		assertEquals(container1.getInternalStatus().getTemperature(),container2.getInternalStatus().getTemperature());
		assertEquals(container1.getInternalStatus().getAtmosphere(),container2.getInternalStatus().getAtmosphere());
		assertEquals(container1.getInternalStatus().getHumidity(),container2.getInternalStatus().getHumidity());
		assertTrue(container1.getUpdated().equals(container2.getUpdated()));
		assertTrue(container1.getArriveBy().equals(container2.getArriveBy()));
	}
	
	protected long getDataID(Container data) {
		return data.getID();
	}
}
