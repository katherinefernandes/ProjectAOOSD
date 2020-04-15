package objectsData;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HistoryData extends ObjectData {
	private  LocalDateTime timeStamp ;
	private long containerID;
	private long journeyID;
	private long clientID;
	private long destinationPortID;
	private long startPortID;
	private String cargo;
	private InternalState status;
	private Location location;
 
	public HistoryData (long cid, long jid, long clid, long dpid, long stid, String cargo, float temp, float atm, float humidity, float lat,float longitude) {
		this.tagName = "DataPoint";
		this.timeStamp = LocalDateTime.now();
		this.containerID = cid;
		this.journeyID = jid;
		this.clientID = clid;
		this.destinationPortID = dpid;
		this.startPortID = stid;
		this.cargo = cargo;
		this.status = new InternalState(atm, temp, humidity);
		this.location = new Location(lat,longitude);
		XMLField timeStampXML = new XMLField("TimeStamp",timeStamp.truncatedTo(ChronoUnit.SECONDS).toString());
		XMLField containerIDXML = new XMLField("ContainerID",String.valueOf(containerID));
		XMLField journeyIDXML = new XMLField("JourneyID",String.valueOf(journeyID));
		XMLField clientIDXML = new XMLField("ClientID",String.valueOf(clientID));
		XMLField destinationPortIDXML = new XMLField("DestinationPortID",String.valueOf(destinationPortID));
		XMLField startPortIDXML = new XMLField("StartPortID",String.valueOf(startPortID));
		XMLField cargoXML = new XMLField("Cargo",cargo);
		List<XMLField> stateList = new ArrayList<>();
		stateList.add(new XMLField("Temperature",String.valueOf(temp)));
		stateList.add(new XMLField("Atmosphere",String.valueOf(atm)));
		stateList.add(new XMLField("Humidity",String.valueOf(humidity)));
		XMLField internalStateXML = new XMLField("InternalState",stateList);
		List<XMLField> locationList = new ArrayList<>();
		locationList.add(new XMLField("Latitude", String.valueOf(lat)));
		locationList.add(new XMLField("Longitude", String.valueOf(longitude)));
		XMLField locationXML = new XMLField("Location",locationList);
		
		XMLField[] array = {timeStampXML,containerIDXML,journeyIDXML,clientIDXML,destinationPortIDXML,startPortIDXML,cargoXML,internalStateXML,locationXML};
		xmlFields = Arrays.asList(array);
	}
	
	//Overloaded constructor added by Simon to handle values of updated that are not right now, for example when getting a datapoint from the xml files. new code from here -
	public HistoryData (LocalDateTime timeStamp, long cid, long jid, long clid, long dpid, long stid, String cargo, float temp, float atm, float humidity, float lat,float longitude) {
		this(cid, jid, clid, dpid, stid, cargo, temp, atm, humidity, lat, longitude);
		this.timeStamp = timeStamp;
		int index = indexOfTagname(xmlFields,"TimeStamp");
		try {
			xmlFields.get(index).setValue(timeStamp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//- to here
	
	public LocalDateTime getTimeStamp() {
		return this.timeStamp;
	}
	public long getID() {
		return timeStamp.toEpochSecond(ZoneOffset.UTC);
	}
	public long getContainerID() {
		return this.containerID;
	}
	public long getJourneyID() {
		return this.journeyID;
	}
	public long getClientID() {
		return this.clientID;
	}
	public long getDestinationPortID() {
		return this.destinationPortID;
	}
	public long getStartPortID() {
		return this.startPortID;
	}
	
	public String getCargo() {
		return this.cargo;
	}
	public InternalState getInternalStatus() {
		return this.status;
	}
	public Location getLocation() {
		return this.location;
	}
	
	
	
}
