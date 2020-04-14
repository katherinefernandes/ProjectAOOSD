package objectsData;

import java.util.*;

public class PortData extends ObjectData{
	private long portID;
	private String country;
	private String portName;
	private Location position;
	private ArrayList<Long> stationedContainers;
	private ArrayList<Long> arrivingContainers;
	
	public PortData(long pid, String country, String portname, float lat, float lon) {
		this.tagName = "Port";
		this.portID=pid;
		this.country=country;
		this.portName=portname;
		this.position= new Location(lat,lon);
		this.stationedContainers = new ArrayList<Long>();
		this.arrivingContainers = new ArrayList<Long>();
		XMLField countryXML = new XMLField("Country",country);
		XMLField portNameXML = new XMLField("PortName",portName);
		List<XMLField> positionList = new ArrayList<>();
		positionList.add(new XMLField("Latitude",String.valueOf(lat)));
		positionList.add(new XMLField("Longitude",String.valueOf(lon)));
		XMLField positionXML = new XMLField("Position",positionList);
		XMLField stationedContainersXML = new XMLField("StationedContainers","ContainerID",new ArrayList<String>());
		XMLField arrivingContainersXML = new XMLField("ArrivingContainers","ContainerID",new ArrayList<String>());
		
		XMLField[] array = {countryXML,portNameXML,positionXML,stationedContainersXML,arrivingContainersXML};
		xmlFields = Arrays.asList(array);
	}
	public long getID() {
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
		int index = indexOfTagname(xmlFields,"StationedContainers");
		try {
			xmlFields.get(index).addValue(String.valueOf(containerID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addArrivingContainer(long containerID) {
		this.arrivingContainers.add(containerID);
		int index = indexOfTagname(xmlFields,"ArrivingContainers");
		try {
			xmlFields.get(index).addValue(String.valueOf(containerID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
