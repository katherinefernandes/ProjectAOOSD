package dataAccess;

import java.util.*;

import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.Location;
import objectsData.PortData;

public class PortAccess extends IdentifiedDataAccess<PortData> {
	
	public PortAccess() {
		super("storage/activeData/ports.xml","Port","Ports");
	}

	@Override
	protected PortData dataFromEvents(List<XMLEvent> events, long ID) {
		int i = 0;
		XMLEvent event;
		StartElement start;
		i = iterateUntilFound(i,events,"Country");
		String country = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"PortName");
		String portName = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"Latitude");
		float latitude = Float.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Longitude");
		float longitude = Float.valueOf(events.get(++i).asCharacters().getData());
		PortData port = new PortData(ID, country, portName, latitude, longitude);
		i = iterateUntilFound(i,events,"StationedContainers");
		while(!((event = events.get(i)).isEndElement() && 
				event.asEndElement().getName().getLocalPart().equals("StationedContainers"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("ContainerID")) {
				port.addStationedContainer(Long.valueOf(events.get(++i).asCharacters().getData()));
			}
			i++;
		}
		while(!((event = events.get(i)).isEndElement() && 
				event.asEndElement().getName().getLocalPart().equals("ArrivingContainers"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("ContainerID")) {
				port.addArrivingContainer(Long.valueOf(events.get(++i).asCharacters().getData()));
			}
			i++;
		}
		return port;
	}
	
	/*
	protected Element elementFromData(PortData data) {
		Element newPort = doc.createElement("Port");
		
		Location position = data.getPosition();
		Element positionElement = doc.createElement("Position");
		List<Long> stationedContainers = data.getStationedContainers();
		Element stationedElement = doc.createElement("StationedContainers");
		List<Long> arrivingContainers = data.getArrivingContainers();
		Element arrivingElement = doc.createElement("ArrivingContainers");
		
		newElementWithValue(newPort,"PortID",String.valueOf(data.getPortID()));
		newElementWithValue(newPort,"Country",data.getCountry());
		newElementWithValue(newPort,"PortName",data.getPortName());
		newElementWithValue(positionElement,"Latitude",String.valueOf(position.getLatitude()));
		newElementWithValue(positionElement,"Longitude",String.valueOf(position.getlongitude()));
		newPort.appendChild(positionElement);
		
		for(Long containerID : stationedContainers) {
			newElementWithValue(stationedElement,"ContainerID",String.valueOf(containerID));
		}
		for(Long containerID : arrivingContainers) {
			newElementWithValue(arrivingElement,"ContainerID",String.valueOf(containerID));
		}
		newPort.appendChild(stationedElement);
		newPort.appendChild(arrivingElement);
		
		return newPort;
	}
	
	protected PortData dataFromElement(Element element) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		long portID = Long.valueOf(NodeMethods.valueFromTagName(element, "PortID"));
		String country = NodeMethods.valueFromTagName(element, "Country");
		String portName = NodeMethods.valueFromTagName(element, "PortName");
		Element positionElement = NodeMethods.singleElementFromTagName(element, "Position");
		float latitude = Float.valueOf(NodeMethods.valueFromTagName(positionElement, "Latitude"));
		float longitude = Float.valueOf(NodeMethods.valueFromTagName(positionElement, "Longitude"));
		
		PortData port = new PortData(portID,country,portName,latitude,longitude);
		
		NodeList stationedElements = NodeMethods.singleElementFromTagName(element, "StationedContainers").getChildNodes();
		NodeList arrivingElements = NodeMethods.singleElementFromTagName(element, "ArrivingContainers").getChildNodes();
		
		for(String containerString : NodeMethods.getValuesFromChildNodes(stationedElements)) {
			port.addStationedContainer(Long.valueOf(containerString));
		}
		for(String containerString : NodeMethods.getValuesFromChildNodes(arrivingElements)) {
			port.addArrivingContainer(Long.valueOf(containerString));
		}
		
		return port;
	}*/
}
