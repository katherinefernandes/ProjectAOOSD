package dataAccess;

import javax.xml.stream.events.XMLEvent;
import objectsData.PortData;

public class PortAccess extends IdentifiedDataAccess<PortData> {
	
	public PortAccess() {
		super("storage/activeData/ports.xml","Port","Ports");
	}

	@Override
	protected PortData dataFromEvents(DataPointParser dataPoint) {
		int i = 0;
		XMLEvent event;
		i = iterateUntilFound(i,dataPoint,"Country");
		String country = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"PortName");
		String portName = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"Latitude");
		float latitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Longitude");
		float longitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		PortData port = new PortData(dataPoint.getID(), country, portName, latitude, longitude);
		i = iterateUntilFound(i,dataPoint,"StationedContainers");
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
