package dataAccess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

import objectsData.ClientData;
import objectsData.HistoryData;
import objectsData.InternalState;
import objectsData.Location;

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
		initializeIO();
		try {
		writer.add(reader.nextEvent());
		writer.add(reader.nextEvent());
		saveAllActiveData();
		saveAllSavedData();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		finishWriteIO();
	}

	private void saveAllSavedData() throws XMLStreamException {
		while(reader.hasNext()) {
			writer.add(reader.nextEvent());
		}
	}

	private void saveAllActiveData() {
		while(!activeData.isEmpty()) {
			insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
			activeData.removeDataAtIndex(0);
		}
	}
	
	public void wipeHistory() {
		activeData.wipeAllData();
		initializeIO();
		try {
			writer.add(reader.nextEvent());
			writer.add(reader.nextEvent());
			writer.add(eventFactory.createEndElement("", "", collectionTagName));
			writer.add(eventFactory.createEndDocument());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		finishWriteIO();
	}

	@Override
	protected EventParser createStartTag(HistoryData data) {
		return new EventParser(eventFactory.createStartElement("", "", dataPointTagName));
	}
	
	private List<HistoryData> findMatchingEntriesFromFile(String searchWord){
		List<HistoryData> matchingEntries = new ArrayList<>();
		initializeIO();
		DataPointParser dataPoint = new DataPointParser(dataPointTagName, searchWord);
		try {
		reader.nextEvent();
		reader.nextEvent();
		while(reader.hasNext()) {
			EventParser event = new EventParser(reader.nextEvent());
			dataPoint.handleMatchOnValue(event);
			if(dataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(dataPoint));
			}
		}			
		} catch (XMLStreamException e) {
			finishReadIO();
			e.printStackTrace();
		}
		finishReadIO();
		return matchingEntries;
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
}
