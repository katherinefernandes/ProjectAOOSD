package dataAccessTest;

import java.time.LocalDateTime;

import dataAccess.HistoryAccess;
import objectsData.HistoryData;

public class HistoryAccessTest extends DataAccessTest<HistoryData, HistoryAccess> {
	
	public HistoryAccessTest() {
		super();
		dataAccess = new HistoryAccess();
		data1 = new HistoryData(LocalDateTime.of(2020, 3, 4, 14, 29, 14), 124321L, 123819L, 9173284L, 12839L, 1923819L, "Fish", 24.F, 104.F, 90F, 112.F, 33.F);

		for(int i = 0; i < 40; i++) {
			LocalDateTime timeStamp = LocalDateTime.of(2020, random.nextInt(12) + 1,
					random.nextInt(30) + 1, random.nextInt(24), random.nextInt(60), random.nextInt(60));
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
	
	
}
