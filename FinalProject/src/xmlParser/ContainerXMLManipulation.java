package xmlParser;

import objectsData.*;
import dataBase.IdentifiablePersistency;

 public class ContainerXMLManipulation extends IdentifiableXMLManipulation<ContainerData> implements IdentifiablePersistency<ContainerData> {
	
	public ContainerXMLManipulation() {
		super("storage/activeData/containers.xml", "Container", "Containers");
	}
	
	@Override
	public ContainerData objectFromDataPoint(DataPointParser dataPoint) {
		int i = 0;
		i = dataPoint.iterateUntilFound(i,"ClientID");
		long clientID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"JourneyID");
		long journeyID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"StartPortID");
		long startPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
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
		
		ContainerData container = new ContainerData(dataPoint.getID(), clientID, journeyID, startPortID, destinationPortID, latitude, longitude, cargo, temperature, atmosphere, humidity, updated, arriveBy);
		
		return container;
	}
}
