package objectsData;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
		this.timeStamp = LocalDateTime.now();
		this.containerID = cid;
		this.journeyID = jid;
		this.clientID = clid;
		this.destinationPortID = dpid;
		this.startPortID = stid;
		this.cargo = cargo;
		this.status = new InternalState(atm, temp, humidity);
		this.location = new Location(lat,longitude);
	}
	
	//Overloaded constructor added by Simon to handle values of updated that are not right now, for example when getting a datapoint from the xml files. new code from here -
	public HistoryData (LocalDateTime timeStamp, long cid, long jid, long clid, long dpid, long stid, String cargo, float temp, float atm, float humidity, float lat,float longitude) {
		this(cid, jid, clid, dpid, stid, cargo, temp, atm, humidity, lat, longitude);
		this.timeStamp = timeStamp;
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
