package persistencyTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;

import businessObjects.Container;
import dataBase.DataBase;
import exceptions.ElementNotFoundException;

public class HistoryAccessTest extends DataAccessTest<Container> {
	
	public HistoryAccessTest() {
		super();
		
		data1 = new Container(20711569474800L, 102621L, 675465457L, 53354L, 755356L, 4L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 4, 10, 3, 21).toString(),LocalDateTime.now().toString());
		data2 = new Container(6755L, 2530321L, 4533566L, 3434568L, 35668556L, 3527582L, 55.6F, 22.87F, "Lard", 7F, 102F, 44F,LocalDateTime.of(2020, 7, 1, 9, 11).toString(),LocalDateTime.now().toString());
		data1_v2 = new Container(23984529359L, 182321L, 675465457L, 755356L, 7783874L, 23775293L, 55.6F, 36.787F, "Fish n' lard", 3.8F, 100.2F, 86F,LocalDateTime.of(2020, 5, 16, 1, 32).toString(),LocalDateTime.now().toString());
		data1.setLastVisitedPort(1241524123L);
		
		for(int i = 0; i < 20; i++) {
			long ID = random.nextLong();
			sortTestData.add(new Container(ID, 1L, 1L, 1L, 1L, 1L, 1F, 1F, "a", 1F, 1F, 1F, LocalDateTime.of(2020, 2, 28, 7, 2).toString(),LocalDateTime.now().toString()));
		}
	}
	
	//@Test
	public void persistencyTestT() throws NumberFormatException, ElementNotFoundException {
		persistencyTest(); }
	
	@Override
	protected Container getObject(long ID) throws ElementNotFoundException {
		return DataBase.searchHistory(String.valueOf(ID)).get(0);
	}
	
	@Override
	protected void insertData(Container container) {
		DataBase.saveToHistory(container);
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



	@Override
	@AfterEach
	public void cleanUp() {
		toBeDeleted = new ArrayList<>();
		DataBase.wipeHistory();
	}
	
}
