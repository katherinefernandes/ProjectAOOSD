package dataAccess;



import java.util.List;

import javax.xml.stream.events.*;

import org.w3c.dom.*;
import objectsData.HistoryData;
import objectsData.InternalState;
import objectsData.Location;

public class HistoryAccess extends DataAccess<HistoryData> {
	public HistoryAccess() {
		super("storage/activeData/history.xml");
	}
	

	@Override
	protected HistoryData dataOfEvents(List<XMLEvent> events, long ID) {
		return null;
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
