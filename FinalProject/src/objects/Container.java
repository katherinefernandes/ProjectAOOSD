package objects;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import dataWrappers.InternalStatus;
import dataWrappers.Location;
import exceptions.ElementSelectionException;
import supportingClasses.UpdateDestinationPort;

/**
 * This class contains all the information required for a container
 * @author Mamuna and Simon
 *
 */
public class Container extends BusinessObject {
	private long ID;
	private long clientID = 0L;
	private long journeyID = 0L;
	private long startPortID = 0L;
	private long lastVisitedPortID = 0L;
	private long destinationPortID = 0L;
	private Location currentPosition = new Location(0F,0F);
	private String cargo = " ";
	private InternalStatus internalStatus = new InternalStatus(0F,0F,0F);
	private String updated = LocalDateTime.of(2000, 1, 1, 0, 0).toString();
	private String arriveBy = LocalDateTime.of(2000, 1, 1, 0, 0).toString();


	public Container(long containerID) {
		ID=containerID;
	}
	public Container(long containerID, Port startPort) {
		this(containerID);
		startPortID = startPort.getID();
		lastVisitedPortID = startPort.getID();
		destinationPortID = startPort.getID();
		currentPosition =startPort.getPosition();
	}
	
	public Container(long containerID, long clientID, long journeyID,long startPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, String arriveBy) {
		this(containerID);
		this.ID = containerID;
		this.clientID=clientID;
		this.journeyID=journeyID;
		this.startPortID=startPortID;
		this.lastVisitedPortID = startPortID;
		this.destinationPortID=destinationPortID;
		this.currentPosition= new Location(latitude,longitude);
		this.cargo=cargo;
		this.internalStatus=new InternalStatus(atmosphere, temperature, humidity);
		this.arriveBy=arriveBy;
	}
	public Container(long containerID, long clientId, long journeyID,long startPortID, long lastVisitedPortID, long destinationPortID, float latitude, float longitude, String cargo, float temperature, float atmosphere, float humidity, String updated, String arriveby) {
		this(containerID,clientId,journeyID,startPortID,destinationPortID,latitude,longitude,cargo,temperature,atmosphere,humidity,arriveby);
		this.lastVisitedPortID = lastVisitedPortID;
		this.updated = updated;
	}
	
	public void setClientID(long clientID) {
		this.clientID=clientID;
	}
	public void setJourneyID(long journeyID) {
		this.journeyID=journeyID;
	}
	public void setStartPortID(long portID) {
		startPortID=portID;
	}
	public void setDestinationPortID(long portID) {
		destinationPortID=portID;
	}
	public void setLastVisitedPort(long portID) {
		lastVisitedPortID = portID;
	}
	public void setCurrentPosition(float latitude, float longitude) {
		currentPosition.setLatitude(latitude);
		currentPosition.setLongitude(longitude);
	}
	public void setInternalStatus(float atmosphere, float temperature, float humidity) {
		internalStatus.setAtmosphere(atmosphere);
		internalStatus.setTemperature(temperature);
		internalStatus.setHumidity(humidity);
	}
	public void setCargo(String cargo) {
		this.cargo=cargo;
	}
	public void setUpdated(String time) {
		this.updated = time;
	}
	public void setArriveBy(String arriveBy) {
		this.arriveBy=arriveBy;
	}
	public void useContainerAgain(long clientID, long journeyID,long startPortID, long destinationPortID, String cargo, float temperature, float atmosphere, float humidity, String arriveby) {
		useContainerAgain(clientID, journeyID, startPortID, destinationPortID, cargo, temperature, atmosphere, humidity, arriveby, LocalDateTime.now().toString());
	}
	public void useContainerAgain(long clientID, long journeyID,long startPortID, long destinationPortID, String cargo, float temperature, float atmosphere, float humidity, String arriveby, String updated) {
		setClientID(clientID);
		setJourneyID(journeyID);
		setStartPortID(startPortID);
		setDestinationPortID(destinationPortID);
		setCargo(cargo);
		setInternalStatus(atmosphere, temperature, humidity);
		setArriveBy(arriveby);
		setUpdated(updated);
	}
	public Location getCurrentPosition() {
		return currentPosition;
	}
	public String getUpdated() {
		return updated;
	}
	public String getArriveBy() {
		return arriveBy;
	}
	public long getJourneyID() {
		return journeyID;
	} 
	public long getClientID() {
		return clientID;
	}
	public long getDestinationPortID() {
		return destinationPortID;
	}
	public long getLastVisitedPortID() {
		return lastVisitedPortID;
	}
	public long getStartPortID() {
		return startPortID;
	}
	public String getCargo() {
		return this.cargo;
	}
	public InternalStatus getInternalStatus() {
		return this.internalStatus;
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
		values.add(String.valueOf(getClientID()));
		values.add(String.valueOf(getJourneyID()));
		values.add(String.valueOf(getStartPortID()));
		values.add(String.valueOf(getLastVisitedPortID()));
		values.add(String.valueOf(getDestinationPortID()));
		values.add(String.valueOf(getCurrentPosition().getLatitude()));
		values.add(String.valueOf(getCurrentPosition().getLongitude()));
		values.add(String.valueOf(cargo));
		values.add(String.valueOf(getInternalStatus().getTemperature()));
		values.add(String.valueOf(getInternalStatus().getAtmosphere()));
		values.add(String.valueOf(getInternalStatus().getHumidity()));
		values.add(String.valueOf(getUpdated()));
		values.add(String.valueOf(getArriveBy()));
		return values;
	}
	
	/**
	 * This method will invoke the client to update its journey information
	 * and reset the container information
	 * @param container
	 * @author Mamuna Azam
	 */
	public void containerHasReachedDestination() {
		    System.out.println("Trying to update client");
			try {
				Client client = DataBase.getClient(clientID);
				client.updateJourneyInformation(this.journeyID);
			} catch (ElementSelectionException e) {
				throw new Error("Client was not found, which means the container was not registered properly",e);
			}
			DataBase.saveToHistory(this);
			new UpdateDestinationPort().updateAtTheEndOfAJourney(destinationPortID, ID);
			useContainerAgain(0000000l, 0, destinationPortID, destinationPortID, "none", 0, 0, 0, "1-1-2020");
	}
	
	
	
	
	
	
	
}
