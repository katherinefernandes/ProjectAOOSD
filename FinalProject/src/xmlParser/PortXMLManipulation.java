package xmlParser;

import javax.xml.stream.events.XMLEvent;

import dataBase.IdentifiablePersistency;
import objects.Port;

public class PortXMLManipulation extends GeneralXMLManipulation<Port> implements IdentifiablePersistency<Port> {
	private static PortXMLManipulation selfInstance;
	
	public static PortXMLManipulation getInstance() {
		if(selfInstance == null) {
			selfInstance = new PortXMLManipulation();
		}
		return selfInstance;
	}
	
	private PortXMLManipulation() {
		super("storage/activeData/ports.xml","Port","Ports");
	}

	@Override
	protected Port objectFromDataPoint(DataPointParser dataPoint) {
		int i = 0;
		XMLEvent event;
		i = dataPoint.iterateUntilFound(i,"Country");
		String country = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"PortName");
		String portName = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"Latitude");
		float latitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Longitude");
		float longitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		Port port = new Port(dataPoint.getID(), country, portName, latitude, longitude);
		i = dataPoint.iterateUntilFound(i,"StationedContainers");
		while(!((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement() && 
				event.asEndElement().getName().getLocalPart().equals("StationedContainers"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("ContainerID")) {
				port.addStationedContainer(Long.valueOf(dataPoint.getEventAtIndex(++i).getData()));
			}
			i++;
		}
		while(!((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement() && 
				event.asEndElement().getName().getLocalPart().equals("ArrivingContainers"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("ContainerID")) {
				port.addArrivingContainer(Long.valueOf(dataPoint.getEventAtIndex(++i).getData()));
			}
			i++;
		}
		return port;
	}

	@Override
	protected DataPointParser dataPointFromObject(Port port) {
		DataPointParser dataPoint = new DataPointParser(dataPointTagName);
		dataPoint.addStartEvent(dataPointTagName, port.getID());
		
		dataPoint.addCompleteElement("Country", port.getCountry());
		dataPoint.addCompleteElement("PortName", port.getPortName());
		
		dataPoint.addStartEvent("Position");
		dataPoint.addCompleteElement("Latitude", port.getPosition().getLatitude());
		dataPoint.addCompleteElement("Longitude", port.getPosition().getLongitude());
		dataPoint.addEndEvent("Position");
		
		dataPoint.addStartEvent("StationedContainers");
		for(long ID : port.getStationedContainers()) {
			dataPoint.addCompleteElement("ContainerID",ID);
		}
		dataPoint.addEndEvent("StationedContainers");
		
		dataPoint.addStartEvent("ArrivingContainers");
		for(long ID : port.getArrivingContainers()) {
			dataPoint.addCompleteElement("ContainerID",ID);
		}
		dataPoint.addEndEvent("ArrivingContainers");
		
		
		dataPoint.addEndEvent(dataPointTagName);
		return dataPoint;
	}
}
