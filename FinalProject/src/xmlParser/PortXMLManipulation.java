package xmlParser;

import javax.xml.stream.events.XMLEvent;

import dataBase.IdentifiablePersistency;
import objectsData.PortData;

 public class PortXMLManipulation extends IdentifiableXMLManipulation<PortData> implements IdentifiablePersistency<PortData> {
	
	public PortXMLManipulation() {
		super("storage/activeData/ports.xml","Port","Ports");
	}

	@Override
	protected PortData objectFromDataPoint(DataPointParser dataPoint) {
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
		PortData port = new PortData(dataPoint.getID(), country, portName, latitude, longitude);
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
}
