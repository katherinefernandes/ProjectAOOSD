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
	public HistoryAccess() {
		super("storage/activeData/history.xml","DataPoint","History");
	}

	@Override
	public void newEntry(HistoryData data) {
		activeData.add(data);
	}

	@Override
	public List<HistoryData> searchEntries(String searchWord) {
		correctPositionFound = false;
		List<HistoryData> matchingEntries = new ArrayList<>();
		for(HistoryData dataPoint : activeData) {
			for(String value : dataPoint.dumpValues()) {
				correctPositionFound = correctPositionFound || value.contains(searchWord);
			}
			if(correctPositionFound) {
				matchingEntries.add(dataPoint);
			}
			correctPositionFound = false;
		}
		
		initializeIO();
		
		try {
			
		reader.nextEvent();
		reader.nextEvent();
		currentDatapoint = new ArrayList<>();
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isEndElement()) {
				EndElement end = event.asEndElement();
				if(end.getName().getLocalPart().equals(elementsName)) {
					if(correctPositionFound) {
						matchingEntries.add(dataOfEvents(currentDatapoint));
					}
					currentDatapoint = new ArrayList<>();
					correctPositionFound = false;
				}
				if(end.getName().getLocalPart().equals(collectionsName)) {
					if(correctPositionFound) {
						matchingEntries.add(dataOfEvents(currentDatapoint));
					}
					break;
				}
			}
			if(event.isCharacters()) {
				Characters chars = event.asCharacters();
				correctPositionFound = correctPositionFound || chars.getData().contains(searchWord);
			}
			currentDatapoint.add(event);
		}			
		} catch (XMLStreamException e) {
			closeIO();
			e.printStackTrace();
		}
			
		closeIO();
		return matchingEntries;
	}

	@Override
	public void flushActiveData() {
		initializeIO();
		try {
			writer.add(reader.nextEvent());
			writer.add(reader.nextEvent());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		for(HistoryData dataPoint : activeData) {
			insertDatapoint(eventsFromData(dataPoint));
		}
		try {
			while(reader.hasNext()) {
				writer.add(reader.nextEvent());
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		writeIO();
	}

	@Override
	protected StartElement createStartTag(HistoryData data) {
		return eventFactory.createStartElement("", "", elementsName);
	}
	
	private HistoryData dataOfEvents(List<XMLEvent> events) {
		int i = 0;
		i = iterateUntilFound(i,events,"TimeStamp");
		LocalDateTime timeStamp = LocalDateTime.parse(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"ContainerID");
		long containerID = Integer.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"JourneyID");
		long journeyID = Long.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"ClientID");
		long clientID = Long.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"DestinationPortID");
		long destinationPortID = Long.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"StartPortID");
		long startPortID = Long.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Cargo");
		String cargo = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"Temperature");
		float temperature = Float.parseFloat(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Atmosphere");
		float atmosphere = Float.parseFloat(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Humidity");
		float humidity = Float.parseFloat(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Latitude");
		float latitude = Float.parseFloat(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Longitude");
		float longitude = Float.parseFloat(events.get(++i).asCharacters().getData());
		
		HistoryData historyData = new HistoryData(timeStamp, containerID, journeyID, clientID, destinationPortID, startPortID, cargo, temperature, atmosphere, humidity, latitude, longitude);
		
		return historyData;
	}

	public void wipeHistory() {
		initializeIO();
		try {
			writer.add(reader.nextEvent());
			writer.add(reader.nextEvent());
			writer.add(eventFactory.createEndElement("", "", collectionsName));
			writer.add(eventFactory.createEndDocument());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		writeIO();
	}
}
