package dataAccessTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import dataAccess.ContainerAccess;
import exceptions.ElementNotFoundException;
import objectsData.ContainerData;
import supportingClasses.parseInput;

public class ContainerAccessTest extends IdentifiableDataAccessTest<ContainerData,ContainerAccess>{

	public ContainerAccessTest() {
		super();
		dataAccess = new ContainerAccess();
		
		data1 = new ContainerData(20711569474800L, 102621L, 675465457L, 53354L, 755356L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,parseInput.getDate(LocalDate.of(2020,4,10)));
		data2 = new ContainerData(6755L, 2530321L, 4533566L, 3434568L, 35668556L, 55.6F, 22.87F, "Lard", 7F, 102F, 44F, parseInput.getDate(LocalDate.of(2020,4,12)));
		data1_v2 = new ContainerData(829897L, 182321L, 675465457L, 755356L, 7783874L, 55.6F, 36.787F, "Fish n' lard", 3.8F, 100.2F, 86F, parseInput.getDate(LocalDate.of(2020,4,14)));
		
		for(int i = 0; i < 20; i++) {
			long ID = random.nextLong();
			sortTestData.add(new ContainerData(ID, 1L, 1L, 1L, 1L, 1F, 1F, "a", 1F, 1F, 1F, parseInput.getDate(LocalDate.of(2020,4,1))));
		}
	}
	
	@Test
	public void persistencyTestT() throws NumberFormatException, ElementNotFoundException {
		persistencyTest(); }
	//@Test
	public void editTestT() throws NumberFormatException, ElementNotFoundException {
		editTest(); }

	
	public void assertEqualData(ContainerData container1, ContainerData container2) {
		assertEquals(container1.getID(),container2.getID());
		assertEquals(container1.getClientID(),container2.getClientID());
		assertEquals(container1.getJourneyID(),container2.getJourneyID());
		assertEquals(container1.getStartPortID(),container2.getStartPortID());
		assertEquals(container1.getDestinationPortID(),container2.getDestinationPortID());
		assertEquals(container1.getCurrentPosition().getLatitude(),container2.getCurrentPosition().getLatitude());
		assertEquals(container1.getCurrentPosition().getlongitude(),container2.getCurrentPosition().getlongitude());
		assertEquals(container1.getCargo(),container2.getCargo());
		assertEquals(container1.getInternalStatus().getTemperature(),container2.getInternalStatus().getTemperature());
		assertEquals(container1.getInternalStatus().getAtmosphere(),container2.getInternalStatus().getAtmosphere());
		assertEquals(container1.getInternalStatus().getHumidity(),container2.getInternalStatus().getHumidity());
		assertTrue(container1.getUpdated().equals(container2.getUpdated()));
		assertTrue(container1.getArriveBy().equals(container2.getArriveBy()));
	}
	
	protected long getDataID(ContainerData data) {
		return data.getID();
	}
}
