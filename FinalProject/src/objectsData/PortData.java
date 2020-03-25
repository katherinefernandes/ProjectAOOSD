package objectsData;

import java.util.ArrayList;

public class PortData extends ObjectData{
	private long portID;
	private String country;
	private String portName;
	private Location position;
	private ArrayList<Long> stationedContainers;
	private ArrayList<Long> arrivingContainers;
	
	public PortData(long pid, String country, String portname, float lat, float lon) {
		this.portID=pid;
		this.country=country;
		this.portName=portname;
		this.position= new Location(lat,lon);
		this.stationedContainers = new ArrayList<Long>();
		this.arrivingContainers = new ArrayList<Long>();
	}
	public long getPortID() {
		return this.portID;
	}
	public String getCountry() {
		return this.country;
	}
	public String getPortName() {
		return this.portName;
	}
	public Location getPosition() {
		return this.position;
	}
	public ArrayList<Long> getStationedContainers(){
		return this.stationedContainers;
	}
	public ArrayList<Long> getArrivingContainers(){
		return this.arrivingContainers;
	}
	public void addStationedContainer(long containerID) {
		this.stationedContainers.add(containerID);
	}
	public void addArrivingContainer(long containerID) {
		this.arrivingContainers.add(containerID);
	}
}
