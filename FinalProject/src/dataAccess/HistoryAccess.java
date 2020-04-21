package dataAccess;

import java.time.LocalDateTime;
import java.util.*;

import javax.xml.stream.XMLStreamException;

import objectsData.HistoryData;

public class HistoryAccess extends DataAccess<HistoryData> {
	private ActiveData<HistoryData> activeData;
	public HistoryAccess() {
		super("storage/activeData/history.xml","DataPoint","History");
		activeData = new ActiveData<>();
	}

	@Override
	public void newEntry(HistoryData data) {
		activeData.storeNewData(data);
	}

	@Override
	public List<HistoryData> searchEntries(String searchWord) {
		List<HistoryData> matchingEntries = activeData.findMatchingEntriesFromActiveData(searchWord);
		matchingEntries.addAll(findMatchingEntriesFromFile(searchWord));
		return matchingEntries;
	}

	@Override
	public void flushActiveData() {
		xmlIO.initializeIO();
		xmlIO.transferNext();
		xmlIO.transferNext();
		saveAllActiveData();
		saveAllSavedData();
		xmlIO.finishWriteIO();
	}
	
	public void wipeHistory() {
		activeData.wipeAllData();
		xmlIO.initializeIO();
		xmlIO.transferNext();
		xmlIO.transferNext();
		xmlIO.writeEvent(EventParser.generateEnd(collectionTagName));
		xmlIO.writeEvent(EventParser.generateEndDoc());
		xmlIO.finishWriteIO();
	}

	private void saveAllSavedData() {
		while(xmlIO.hasNext()) {
			xmlIO.transferNext();
		}
	}

	@Override
	protected EventParser createStartTag(HistoryData data) {
		return EventParser.generateStart(dataPointTagName);
	}
	
	private HistoryData dataFromEvents(DataPointParser dataPoint) {
		int i = 0;
		i = iterateUntilFound(i,dataPoint,"TimeStamp");
		LocalDateTime timeStamp = LocalDateTime.parse(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"ContainerID");
		long containerID = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"JourneyID");
		long journeyID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"ClientID");
		long clientID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"DestinationPortID");
		long destinationPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"StartPortID");
		long startPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Cargo");
		String cargo = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"Temperature");
		float temperature = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Atmosphere");
		float atmosphere = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Humidity");
		float humidity = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Latitude");
		float latitude = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Longitude");
		float longitude = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		
		HistoryData historyData = new HistoryData(timeStamp, containerID, journeyID, clientID, destinationPortID, startPortID, cargo, temperature, atmosphere, humidity, latitude, longitude);
		
		return historyData;
	}
	
	private void saveAllActiveData() {
		while(!activeData.isEmpty()) {
			xmlIO.insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
			activeData.removeDataAtIndex(0);
		}
	}
	
	private List<HistoryData> findMatchingEntriesFromFile(String searchWord){
		List<HistoryData> matchingEntries = new ArrayList<>();
		DataPointParser dataPoint = new DataPointParser(dataPointTagName, searchWord);
		xmlIO.initializeIO();
		xmlIO.readEvent();
		xmlIO.readEvent();
		while(xmlIO.hasNext()) {
			EventParser event = xmlIO.readEvent();
			dataPoint.handleMatchOnValue(event);
			if(dataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(dataPoint));
			}
		}	
		xmlIO.finishReadIO();
		return matchingEntries;
	}
}
