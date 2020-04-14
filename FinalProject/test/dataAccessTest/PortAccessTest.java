package dataAccessTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;

import dataAccess.PortAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.PortData;

public class PortAccessTest extends EditableDataAccessTest<PortData,PortAccess>{

	public PortAccessTest(){
		super();
		dataAccess = new PortAccess();
		
		data1 = new PortData(92198289L, "Denmark", "Nordhavn", 55F, 64.2F);
		data1.addArrivingContainer(871872L);
		data1.addStationedContainer(18247182L);
		
		data2 = new PortData(73827291L, "China", "Bejing main port", 100.F,43.2F);
		data2.addStationedContainer(298392831L);
		
		data1_v2 = new PortData(92198289L, "Denmark", "Nordhavn", 55F, 64.2F);
		
		data1_v2.addStationedContainer(871872L);
		
		for(int i = 0; i < 20; i++) {
			long ID = random.nextLong();
			PortData newPort = new PortData(ID,"a","a",1F,1F);
			for(int j = 0; j < random.nextInt(6); j++) {
				if(random.nextBoolean()) {
					newPort.addArrivingContainer(random.nextLong());
				}else {
					newPort.addStationedContainer(random.nextLong());
				}
			}
			sortTestData.add(newPort);
		}
	}
	
	@Test
	public void persistencyTestT() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException {
		persistencyTest(); }
	@Test
	public void editTestT() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException {
		editTest(); }
	
	public void assertEqualData(PortData portData1, PortData portData2) {
		assertEquals(portData1.getID(),portData2.getID());
		assertEquals(portData1.getCountry(),portData2.getCountry());
		assertEquals(portData1.getPortName(),portData2.getPortName());
		assertEquals(portData1.getPosition().getLatitude(),portData2.getPosition().getLatitude());
		assertEquals(portData1.getPosition().getlongitude(),portData2.getPosition().getlongitude());
		Set<Long> stationedContainers1 = new HashSet<Long>();
		stationedContainers1.addAll(portData1.getStationedContainers());
		Set<Long> arrivingContainers1 = new HashSet<>();
		arrivingContainers1.addAll(portData1.getArrivingContainers());
		
		for(Long containerID : portData2.getStationedContainers()) {
			assertTrue(stationedContainers1.contains(containerID));
		}
		for(Long containerID : portData2.getArrivingContainers()) {
			assertTrue(arrivingContainers1.contains(containerID));
		}
	}
	
	protected long getDataID(PortData portData) {
		return portData.getID();
	}
	
}
