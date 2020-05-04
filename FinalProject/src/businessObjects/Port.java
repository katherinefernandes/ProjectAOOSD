package businessObjects;

import java.util.*;
import dataBase.DataBase;
import dataWrappers.Location;

public class Port extends BusinessObject{
	private long ID;
	private String country;
	private String portName;
	private Location position;
	private ArrayList<Long> stationedContainers;
	private ArrayList<Long> arrivingContainers;
	
	public Port(long ID, String country, String portname, float latitude, float longitude) {
		this.ID=ID;
		this.country=country;
		this.portName=portname;
		this.position= new Location(latitude,longitude);
		this.stationedContainers = new ArrayList<Long>();
		this.arrivingContainers = new ArrayList<Long>();
	}
	public String getCountry() {
		return country;
	}
	public String getPortName() {
		return portName;
	}
	public Location getPosition() {
		return position;
	}
	public ArrayList<Long> getStationedContainers(){
		return stationedContainers;
	}
	public ArrayList<Long> getArrivingContainers(){
		return arrivingContainers;
	}
	public void addStationedContainer(long containerID) {
		stationedContainers.add(containerID);
	}
	public void addArrivingContainer(long containerID) {
		arrivingContainers.add(containerID);
	}
	public void removeStationedContainer(long containerID) {
		stationedContainers.remove(containerID);
	}
	public void removeArrivingContainer(long containerID) {
		arrivingContainers.remove(containerID);
	}
	
	public void save() {
		DataBase.save(this);
	}
	public long getID() {
		return ID;
	}
	public List<String> getAllValues(){
		List<String> values = new ArrayList<>();
		values.add(String.valueOf(getID()));
		values.add(String.valueOf(getCountry()));
		values.add(String.valueOf(getPortName()));
		values.add(String.valueOf(getPosition().getLatitude()));
		values.add(String.valueOf(getPosition().getLongitude()));
		for(long containerID : getStationedContainers()) {
			values.add(String.valueOf(containerID));
		}
		for(long containerID : getArrivingContainers()) {
			values.add(String.valueOf(containerID));
		}
		return values;
	}
}
