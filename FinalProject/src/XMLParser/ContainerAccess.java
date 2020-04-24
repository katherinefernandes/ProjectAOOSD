package XMLParser;

import objectsData.*;
import java.time.LocalDateTime;

public class ContainerAccess extends IdentifiedDataAccess<ContainerData> {
	
	public ContainerAccess() {
		super("storage/activeData/containers.xml", "Container", "Containers");
	}
	
	@Override
	public ContainerData dataFromEvents(DataPointParser dataPoint) {
		int i = 0;
		i = iterateUntilFound(i,dataPoint,"ClientID");
		long clientID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"JourneyID");
		long journeyID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"StartPortID");
		long startPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"DestinationPortID");
		long destinationPortID = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Latitude");
		float latitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Longitude");
		float longitude = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Cargo");
		String cargo = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"Temperature");
		float temperature = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Atmosphere");
		float atmosphere = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Humidity");
		float humidity = Float.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Updated");
		String updated = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"ArriveBy");
		String arriveBy = dataPoint.getEventAtIndex(++i).getData();	
		
		ContainerData container = new ContainerData(dataPoint.getID(), clientID, journeyID, startPortID, destinationPortID, latitude, longitude, cargo, temperature, atmosphere, humidity, updated, arriveBy);
		
		return container;
	}
}
