package dataAccess;

import objectsData.*;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public class ContainerAccess extends DataAccess<ContainerData> {
	
	public ContainerAccess() {
		super("storage/activeData/containers.xml");
	}
	
	protected Element elementFromData(ContainerData data) {
		Element newContainer = doc.createElement("Container");
		
		Location position = data.getCurrentPosition();
		Element positionElement = doc.createElement("CurrentPosition");
		InternalState status = data.getInternalStatus();
		Element statusElement = doc.createElement("InternalState");
		
		newElementWithValue(newContainer,"ContainerID", String.valueOf(data.getContainerID()));
		newElementWithValue(newContainer,"ClientID", String.valueOf(data.getClientID()));
		newElementWithValue(newContainer,"JourneyID", String.valueOf(data.getJourneyID()));
		newElementWithValue(newContainer,"StartPortID", String.valueOf(data.getStartPortID()));
		newElementWithValue(newContainer,"DestinationPortID", String.valueOf(data.getDestinationPortID()));
		
		newElementWithValue(positionElement,"Latitude",String.valueOf(position.getLatitude()));
		newElementWithValue(positionElement,"Longitude",String.valueOf(position.getlongitude()));
		newContainer.appendChild(positionElement);

		newElementWithValue(newContainer,"Cargo",data.getCargo());
	
		newElementWithValue(statusElement,"Temperature",String.valueOf(status.getTemperature()));
		newElementWithValue(statusElement,"Atmosphere",String.valueOf(status.getAtmosphere()));
		newElementWithValue(statusElement,"Humidity",String.valueOf(status.getHumidity()));
		newContainer.appendChild(statusElement);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		newElementWithValue(newContainer,"Updated",data.getUpdated().format(formatter ));
		newElementWithValue(newContainer,"ArriveBy",data.getArriveBy().format(formatter));
		
		return newContainer;
	}
	
	protected ContainerData dataFromElement(Element element) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		long containerID = Long.valueOf(NodeMethods.valueFromTagName(element, "ContainerID"));
		long clientID = Long.valueOf(NodeMethods.valueFromTagName(element, "ClientID"));
		long journeyID = Long.valueOf(NodeMethods.valueFromTagName(element, "JourneyID"));
		long startPortID = Long.valueOf(NodeMethods.valueFromTagName(element, "StartPortID"));
		long destinationPortID = Long.valueOf(NodeMethods.valueFromTagName(element, "DestinationPortID"));
		
		Element positionElement = NodeMethods.singleElementFromTagName(element, "CurrentPosition");
		float latitude = Float.valueOf(NodeMethods.valueFromTagName(positionElement, "Latitude"));
		float longitude = Float.valueOf(NodeMethods.valueFromTagName(positionElement, "Longitude"));
		
		String cargo = NodeMethods.valueFromTagName(element, "Cargo");
		
		Element statusElement = NodeMethods.singleElementFromTagName(element, "InternalState");
		float temperature = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Temperature"));
		float atmosphere = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Atmosphere"));
		float humidity = Float.valueOf(NodeMethods.valueFromTagName(statusElement, "Humidity"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime updated = LocalDateTime.parse(NodeMethods.valueFromTagName(element, "Updated"), formatter);
		LocalDateTime arriveBy = LocalDateTime.parse(NodeMethods.valueFromTagName(element, "ArriveBy"), formatter);
		
		return new ContainerData(containerID,clientID,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,temperature,atmosphere,humidity,updated,arriveBy);
	}
}
