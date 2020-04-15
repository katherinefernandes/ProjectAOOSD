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
		XMLEvent event;
		StartElement start;
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
	
	
	/*
	public Element elementFromData(HistoryData data) {
		Element newDataPoint = doc.createElement("DataPoint");
		newElementWithValue(newDataPoint,"TimeStamp",String.valueOf(data.getTimeStamp().toEpochSecond(ZoneOffset.UTC)));
		newElementWithValue(newDataPoint,"ContainerID",String.valueOf(data.getContainerID()));
		newElementWithValue(newDataPoint,"JourneyID",String.valueOf(data.getJourneyID()));
		newElementWithValue(newDataPoint,"ClientID",String.valueOf(data.getClientID()));
		newElementWithValue(newDataPoint,"DestinationPortID",String.valueOf(data.getDestinationPortID()));
		newElementWithValue(newDataPoint,"StartPortID",String.valueOf(data.getStartPortID()));
		newElementWithValue(newDataPoint,"Cargo",data.getCargo());
		
		Element statusElement = doc.createElement("InternalState");
		InternalState status = data.getInternalStatus();
		newElementWithValue(statusElement,"Temperature",String.valueOf(status.getTemperature()));
		newElementWithValue(statusElement,"Atmosphere",String.valueOf(status.getAtmosphere()));
		newElementWithValue(statusElement,"Humidity",String.valueOf(status.getHumidity()));
		newDataPoint.appendChild(statusElement);
		
		Element locationElement = doc.createElement("Location");
		Location location = data.getLocation();
		newElementWithValue(locationElement,"Latitude",String.valueOf(location.getLatitude()));
		newElementWithValue(locationElement,"Longitude",String.valueOf(location.getlongitude()));
		newDataPoint.appendChild(locationElement);
		
		return newDataPoint;
	}
	
	public HistoryData dataFromElement(Element element) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		LocalDateTime timeStamp = LocalDateTime.ofEpochSecond(Long.valueOf(NodeMethods.valueFromTagName(element, "TimeStamp")), 0, ZoneOffset.UTC);
		long containerID = Long.valueOf(NodeMethods.valueFromTagName(element, "ContainerID"));
		long journeyID = Long.valueOf(NodeMethods.valueFromTagName(element, "JourneyID"));
		long clientID = Long.valueOf(NodeMethods.valueFromTagName(element, "ClientID"));
		long destinationPortID = Long.valueOf(NodeMethods.valueFromTagName(element, "DestinationPortID"));
		long startPortID = Long.valueOf(NodeMethods.valueFromTagName(element, "StartPortID"));
		String cargo = NodeMethods.valueFromTagName(element, "Cargo");
		Element statusElement = NodeMethods.singleElementFromTagName(element, "InternalState");
		float temperature = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Temperature"));
		float atmosphere = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Atmosphere"));
		float humidity = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Humidity"));
		Element locationElement = NodeMethods.singleElementFromTagName(element, "Location");
		float latitude = Float.valueOf(NodeMethods.valueFromTagName(locationElement, "Latitude"));
		float longitude = Float.valueOf(NodeMethods.valueFromTagName(locationElement, "Longitude"));
		
		
		return new HistoryData(timeStamp,containerID,journeyID,clientID,destinationPortID,startPortID,cargo,temperature,atmosphere,humidity,latitude,longitude);
	}
	
	public void newEntry(HistoryData data) {
		Element newEntry = elementFromData(data);
		LocalDateTime timeStamp = data.getTimeStamp();
		Element root = doc.getDocumentElement();
		NodeList elements = root.getChildNodes();
		if(elements.getLength() == 0 ||  timeStamp > elementTimeStamp(elements.item(elements.getLength() - 1))) {
			root.appendChild(newEntry);
			transform();
			return;
		}
		int index = 0;
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(20000L,0,ZoneOffset.UTC);
		while(timeStamp < elementTimeStamp(elements.item(index))) {
			index += 1;
		}
		
		
	}*/
	
	//elementFromData()
	//elementTimeStamp
}
