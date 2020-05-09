package xmlParser;

import dataBase.IdentifiablePersistency;
import objects.*;

public class ContainerXMLManipulation extends GeneralXMLManipulation<Container> implements IdentifiablePersistency<Container> {
	
	public ContainerXMLManipulation() {
		super("storage/activeData/containers.xml", "Container", "Containers");
	}
	public ContainerXMLManipulation(String filename, String dataPointTagName, String collectionTagName) {
		super(filename, dataPointTagName, collectionTagName);
	}
	
	@Override
	public Container objectFromDataPoint(DataPointParser dataPoint) {
		int i = 0;
		i = dataPoint.iterateUntilFound(i,"ClientID");
		long clientID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"JourneyID");
		long journeyID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"StartPortID");
		long startPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"LastVisitedPortID");
		long lastVisitedPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"DestinationPortID");
		long destinationPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Latitude");
		float latitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Longitude");
		float longitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Cargo");
		String cargo = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"Temperature");
		float temperature = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Atmosphere");
		float atmosphere = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Humidity");
		float humidity = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Updated");
		String updated = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"ArriveBy");
		String arriveBy = dataPoint.getEventAtIndex(++i).getData();	
		
		Container container = new Container(dataPoint.getID(), clientID, journeyID, startPortID, lastVisitedPortID, destinationPortID, latitude, longitude, cargo, temperature, atmosphere, humidity, updated, arriveBy);
		
		return container;
	}

	@Override
	protected DataPointParser dataPointFromObject(Container container) {
		DataPointParser dataPoint = new DataPointParser(dataPointTagName);
		dataPoint.addStartEvent(dataPointTagName, container.getID());
		
		dataPoint.addCompleteElement("ClientID", container.getClientID());
		dataPoint.addCompleteElement("JourneyID", container.getJourneyID());
		dataPoint.addCompleteElement("StartPortID", container.getStartPortID());
		dataPoint.addCompleteElement("LastVisitedPortID", container.getLastVisitedPortID());
		dataPoint.addCompleteElement("DestinationPortID", container.getDestinationPortID());
		
		dataPoint.addStartEvent("CurrentPosition");
		dataPoint.addCompleteElement("Latitude", container.getCurrentPosition().getLatitude());
		dataPoint.addCompleteElement("Longitude", container.getCurrentPosition().getLongitude());
		dataPoint.addEndEvent("CurrentPosition");
		
		dataPoint.addCompleteElement("Cargo", container.getCargo());
		
		dataPoint.addStartEvent("InternalState");
		dataPoint.addCompleteElement("Temperature", container.getInternalStatus().getTemperature());
		dataPoint.addCompleteElement("Atmosphere", container.getInternalStatus().getAtmosphere());
		dataPoint.addCompleteElement("Humidity", container.getInternalStatus().getHumidity());
		dataPoint.addEndEvent("InternalState");
		
		dataPoint.addCompleteElement("Updated", container.getUpdated());
		dataPoint.addCompleteElement("ArriveBy", container.getArriveBy());
	
		dataPoint.addEndEvent(dataPointTagName);
		return dataPoint;
	}
}
