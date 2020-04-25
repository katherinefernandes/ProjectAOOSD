package objectsData;

import java.util.*;

import dataBase.DataBase;
import xmlParser.XMLField;

public class PortData extends IdentifiableData{
	private String country;
	private String portName;
	private Location position;
	private ArrayList<Long> stationedContainers;
	private ArrayList<Long> arrivingContainers;
	
	public PortData(long pid, String country, String portname, float lat, float lon) {
		this.tagName = "Port";
		this.ID=pid;
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
	public void updateStationedContainers(long containerID) {
		// TODO Auto-generated method stub
		this.stationedContainers.remove(containerID);
		List<String> values = new ArrayList<>();
		for(long container : stationedContainers) {
			values.add(String.valueOf(container));
		}
		int index = indexOfTagname(xmlFields,"StationedContainers");
		try {
			xmlFields.get(index).setValues(values, "ContainerID");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateArrivingContainers(long containerID) {
		this.arrivingContainers.remove(containerID);
		List<String> values = new ArrayList<>();
		for(long container : arrivingContainers) {
			values.add(String.valueOf(container));
		}
		int index = indexOfTagname(xmlFields,"ArrivingContainers");
		try {
			xmlFields.get(index).setValues(values, "ContainerID");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void save() {
		DataBase.save(this);
	}
}
