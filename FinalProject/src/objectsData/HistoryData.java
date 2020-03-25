package objectsData;

import java.time.LocalDateTime;

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
	public LocalDateTime getTimeStamp() {
		return this.timeStamp;
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
