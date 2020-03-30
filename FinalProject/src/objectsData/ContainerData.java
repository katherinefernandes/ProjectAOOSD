package objectsData;

import java.time.LocalDateTime;

public class ContainerData extends ObjectData {
	private long containerID;
	private long clientID;
	private long journeyID;
	private long startPortID;
	private long destinationPortID;
	private Location currentPosition;
	private String cargo;
	private InternalState status;
	private LocalDateTime updated;
	private LocalDateTime arriveBy;
	
	public ContainerData(long containerID, long clientId, long journeyID,long startPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, LocalDateTime arriveby) {
	
		this.containerID=containerID;
		this.clientID=clientId;
		this.journeyID=journeyID;
		this.startPortID=startPortID;
		this.destinationPortID=destinationPortID;
		this.currentPosition= new Location(latitude,longitude);
		this.cargo=cargo;
		this.status=new InternalState(atmosphere, temperature, humidity);
		this.updated=LocalDateTime.now(); 
		this.arriveBy=arriveby;
		
	}
	
	//Overloaded constructor added by Simon to handle values of updated that are not right now, for example when getting a container from the xml files. new code from here -
	public ContainerData(long containerID, long clientId, long journeyID,long startPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, LocalDateTime updated, LocalDateTime arriveby) {
		this(containerID,clientId,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,temperature,atmosphere,humidity,arriveby);
		this.updated = updated;
	}//- to here
	
	public void useContainerAgain(long clid, long jid,long spid, long dpid, float lat, float lon, String cargo, float t, float a, float h, LocalDateTime arriveby) {
		this.clientID=clid;
		this.journeyID=jid;
		this.startPortID=spid;
		this.destinationPortID=dpid;
		this.currentPosition= new Location(lat,lon);
		this.cargo=cargo;
		this.status=new InternalState(a, t, h);
		this.updated=LocalDateTime.now();
		this.arriveBy=arriveby;
	}
	
	public void setCurrentPosition(float lat, float lon) {
		this.currentPosition.setLatitude(lat);
		this.currentPosition.setlongitude(lon);
		this.updated=LocalDateTime.now();
	}
	public void setStatus(float a, float t, float h) {
		this.status.setAtmosphere(a);
		this.status.setHumidity(h);
		this.status.setTemperature(t);
		this.updated=LocalDateTime.now();
	}
	
	
	public Location getCurrentPosition() {
		return this.currentPosition;
	}
	public LocalDateTime getUpdated() {
		return this.updated;
	}
	public LocalDateTime getArriveBy() {
		return this.arriveBy;
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
}
