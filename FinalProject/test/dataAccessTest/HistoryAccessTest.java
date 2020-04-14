package dataAccessTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

import dataAccess.HistoryAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.HistoryData;

public class HistoryAccessTest extends DataAccessTest<HistoryData, HistoryAccess> {
	
	public HistoryAccessTest() {
		super();
		dataAccess = new HistoryAccess();
		data1 = new HistoryData(LocalDateTime.of(2020, 3, 4, 14, 29, 14), 124321L, 123819L, 9173284L, 12839L, 1923819L, "Fish", 24.F, 104.F, 90F, 112.F, 33.F);
		data2 = new HistoryData(LocalDateTime.of(2020, 3, 1, 13, 12, 14), 124321L, 123819L, 9173284L, 12839L, 1923819L, "crab", 24.F, 104.F, 90F, 112.F, 33.F);
		data1_v2 = new HistoryData(LocalDateTime.of(2020, 3, 4, 14, 29, 14), 124321L, 123819L, 9173284L, 12839L, 1923819L, "Fish", 24.F, 104.F, 90F, 112.F, 33.F);

		for(int i = 0; i < 40; i++) {
			LocalDateTime timeStamp = LocalDateTime.of(2020, random.nextInt(12) + 1,
					random.nextInt(28) + 1, random.nextInt(24), random.nextInt(60), random.nextInt(60));
			long containerID = random.nextLong();
			long journeyID = random.nextLong();
			long clientID = random.nextLong();
			long destinationPortID = random.nextLong();
			long startPortID = random.nextLong();
			String cargo = String.valueOf(random.nextLong());
			float temperature = random.nextFloat() * 40;
			float atmosphere = random.nextFloat() * 40 + 80;
			float humidity = random.nextFloat() * 100;
			float latitude = random.nextFloat() * 180 - 90;
			float longitude = random.nextFloat() * 360 - 180;
			HistoryData dataPoint = new HistoryData(timeStamp,containerID,journeyID,clientID,
					destinationPortID,startPortID,cargo,temperature,atmosphere,humidity,latitude,longitude);
			sortTestData.add(dataPoint);
		}
	}
	
	
	
	public void assertEqualData(HistoryData history1, HistoryData history2) {
		assertTrue(history1.getTimeStamp().equals(history2.getTimeStamp()));
		assertEquals(history1.getContainerID(),history2.getContainerID());
		assertEquals(history1.getJourneyID(),history2.getJourneyID());
		assertEquals(history1.getClientID(),history2.getClientID());
		assertEquals(history1.getDestinationPortID(),history2.getDestinationPortID());
		assertEquals(history1.getStartPortID(),history2.getStartPortID());
		assertEquals(history1.getCargo(),history2.getCargo());
		assertEquals(history1.getInternalStatus().getTemperature(),history2.getInternalStatus().getTemperature());
		assertEquals(history1.getInternalStatus().getAtmosphere(),history2.getInternalStatus().getAtmosphere());
		assertEquals(history1.getInternalStatus().getHumidity(),history2.getInternalStatus().getHumidity());
		assertEquals(history1.getLocation().getLatitude(),history2.getLocation().getLatitude());
		assertEquals(history1.getLocation().getlongitude(),history2.getLocation().getlongitude());
	}
	
	protected long getDataID(HistoryData data) {
		return data.getTimeStamp().toEpochSecond(ZoneOffset.UTC);
	}
	
}
