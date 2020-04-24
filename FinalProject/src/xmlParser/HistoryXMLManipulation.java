package xmlParser;

import java.time.LocalDateTime;
import java.util.*;

import javax.xml.stream.XMLStreamException;

import objectsData.HistoryData;

public class HistoryXMLManipulation extends GeneralXMLManipulation<HistoryData> {
	private ActiveData<HistoryData> activeData;
	public HistoryXMLManipulation() {
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
		io.initializeIO();
		io.transferNext();
		io.transferNext();
		saveAllActiveData();
		saveAllSavedData();
		io.finishWriteIO();
	}
	
	public void wipeHistory() {
		activeData.wipeAllData();
		io.initializeIO();
		io.transferNext();
		io.transferNext();
		io.writeEvent(EventParser.generateEnd(collectionTagName));
		io.writeEvent(EventParser.generateEndDoc());
		io.finishWriteIO();
	}

	private void saveAllSavedData() {
		while(io.hasNext()) {
			io.transferNext();
		}
	}

	@Override
	protected EventParser createStartTag(HistoryData data) {
		return EventParser.generateStart(dataPointTagName);
	}
	
	private HistoryData dataFromEvents(DataPointParser dataPoint) {
		int i = 0;
		i = dataPoint.iterateUntilFound(i,"TimeStamp");
		LocalDateTime timeStamp = LocalDateTime.parse(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"ContainerID");
		long containerID = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"JourneyID");
		long journeyID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"ClientID");
		long clientID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"DestinationPortID");
		long destinationPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"StartPortID");
		long startPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Cargo");
		String cargo = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"Temperature");
		float temperature = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Atmosphere");
		float atmosphere = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Humidity");
		float humidity = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Latitude");
		float latitude = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Longitude");
		float longitude = Float.parseFloat(dataPoint.getEventAtIndex(++i).getData());
		
		HistoryData historyData = new HistoryData(timeStamp, containerID, journeyID, clientID, destinationPortID, startPortID, cargo, temperature, atmosphere, humidity, latitude, longitude);
		
		return historyData;
	}
	
	private void saveAllActiveData() {
		while(!activeData.isEmpty()) {
			io.insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
			activeData.removeDataAtIndex(0);
		}
	}
	
	private List<HistoryData> findMatchingEntriesFromFile(String searchWord){
		List<HistoryData> matchingEntries = new ArrayList<>();
		DataPointParser dataPoint = new DataPointParser(dataPointTagName, searchWord);
		io.initializeIO();
		io.readEvent();
		io.readEvent();
		while(io.hasNext()) {
			EventParser event = io.readEvent();
			dataPoint.handleMatchOnValue(event);
			if(dataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(dataPoint));
			}
		}	
		io.finishReadIO();
		return matchingEntries;
	}
}
