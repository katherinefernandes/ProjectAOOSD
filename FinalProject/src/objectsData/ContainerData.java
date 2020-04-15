package objectsData;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	// new codeeee
	//overloaded constructor
	public ContainerData(long containerID, long portID, float latitude, float longitude) {
		this.tagName = "Container";
		this.containerID=containerID;
		this.clientID=0l;
		this.journeyID=0l;
		this.startPortID=portID;
		this.destinationPortID=portID;
		this.currentPosition= new Location(latitude,longitude);
		this.cargo="none";
		this.status=new InternalState(1f,35f,75f);
		this.updated=LocalDateTime.now(); 
		this.arriveBy=LocalDateTime.now(); 
		setXMLFields();
	}
	public void setClientID(long clientID) {
		this.clientID=clientID;
		int index = indexOfTagname(xmlFields, "ClientID");
		try {
			xmlFields.get(index).setValue(String.valueOf(clientID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setJourneyID(long journeyID) {
		this.journeyID=journeyID;
		int index = indexOfTagname(xmlFields, "JourneyID");
		try {
			xmlFields.get(index).setValue(String.valueOf(journeyID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setStartPortID(long portID) {
		this.startPortID=portID;
		int index = indexOfTagname(xmlFields, "StartPortID");
		try {
			xmlFields.get(index).setValue(String.valueOf(portID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setDestinationPortID(long portID) {
		this.destinationPortID=portID;
		int index = indexOfTagname(xmlFields, "DestinationPortID");
		try {
			xmlFields.get(index).setValue(String.valueOf(portID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	////
	

	public ContainerData(long containerID, long clientID, long journeyID,long startPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, LocalDateTime arriveBy) {
		this.tagName = "Container";
		this.containerID=containerID;
		this.clientID=clientID;
		this.journeyID=journeyID;
		this.startPortID=startPortID;
		this.destinationPortID=destinationPortID;
		this.currentPosition= new Location(latitude,longitude);
		this.cargo=cargo;
		this.status=new InternalState(atmosphere, temperature, humidity);
		this.updated=LocalDateTime.now(); 
		this.arriveBy=arriveBy;
		setXMLFields();
	}
	
	//Overloaded constructor added by Simon to handle values of updated that are not right now, for example when getting a container from the xml files. new code from here -
	public ContainerData(long containerID, long clientId, long journeyID,long startPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, LocalDateTime updated, LocalDateTime arriveby) {
		this(containerID,clientId,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,temperature,atmosphere,humidity,arriveby);
		setUpdated(updated);
		
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
		setXMLFields();
	}
	
	public void setCurrentPosition(float lat, float lon) {
		this.currentPosition.setLatitude(lat);
		this.currentPosition.setlongitude(lon);
		int index = indexOfTagname(xmlFields,"CurrentPosition");
		List<XMLField> positionXML = new ArrayList<>();
		positionXML.add(new XMLField("Latitude",String.valueOf(lat)));
		positionXML.add(new XMLField("Longitude",String.valueOf(lon)));
		
		try {
			xmlFields.get(index).setCompound(positionXML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setUpdated(LocalDateTime.now());
	}
	public void setStatus(float a, float t, float h) {
		this.status.setAtmosphere(a);
		this.status.setHumidity(h);
		this.status.setTemperature(t);
		int index = indexOfTagname(xmlFields,"InternalState");
		List<XMLField> statusXML = new ArrayList<>();
		statusXML.add(new XMLField("Temperature",String.valueOf(t)));
		statusXML.add(new XMLField("Atmosphere",String.valueOf(a)));
		statusXML.add(new XMLField("Humidity",String.valueOf(h)));
		try {
			xmlFields.get(index).setCompound(statusXML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setUpdated(LocalDateTime.now());
	}
	
	public void setUpdated(LocalDateTime time) {
		this.updated = time;
		int index = indexOfTagname(xmlFields,"Updated");
		try {
			xmlFields.get(index).setValue(time.truncatedTo(ChronoUnit.SECONDS).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public long getID() {
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
	private void setXMLFields() {
		XMLField clientIDXML = new XMLField("ClientID",String.valueOf(clientID));
		XMLField journeyIDXML = new XMLField("JourneyID",String.valueOf(journeyID));
		XMLField startPortIDXML = new XMLField("StartPortID",String.valueOf(startPortID));
		XMLField destinationPortIDXML = new XMLField("DestinationPortID",String.valueOf(destinationPortID));
		List<XMLField> positionList = new ArrayList<>();
		positionList.add(new XMLField("Latitude",String.valueOf(currentPosition.getLatitude())));
		positionList.add(new XMLField("Longitude",String.valueOf(currentPosition.getlongitude())));
		XMLField positionXML = new XMLField("CurrentPosition",positionList);
		XMLField cargoXML = new XMLField("Cargo",cargo);
		List<XMLField> statusList = new ArrayList<>();
		statusList.add(new XMLField("Temperature",String.valueOf(status.getTemperature())));
		statusList.add(new XMLField("Atmosphere",String.valueOf(status.getAtmosphere())));
		statusList.add(new XMLField("Humidity",String.valueOf(status.getHumidity())));
		XMLField statusXML = new XMLField("InternalState",statusList);
		XMLField updatedXML = new XMLField("Updated",updated.truncatedTo(ChronoUnit.SECONDS).toString());
		XMLField arriveByXML = new XMLField("ArriveBy",arriveBy.truncatedTo(ChronoUnit.SECONDS).toString());
		
		XMLField[] array = {clientIDXML,journeyIDXML,startPortIDXML,destinationPortIDXML,positionXML,cargoXML,statusXML,updatedXML,arriveByXML};
		xmlFields = Arrays.asList(array);
	}
	public void setCargo(String cargo) {
		// TODO Auto-generated method stub
		this.cargo=cargo;
		int index = indexOfTagname(xmlFields, "Cargo");
		try {
			xmlFields.get(index).setValue(String.valueOf(cargo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setArriveBy(LocalDateTime arriveBy2) {
		// TODO Auto-generated method stub
		this.arriveBy=arriveBy2;
		int index = indexOfTagname(xmlFields, "ArriveBy");
		try {
			xmlFields.get(index).setValue(arriveBy2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
