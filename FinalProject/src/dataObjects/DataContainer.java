package dataObjects;

import java.util.Date;

public class DataContainer {
	private int ContainerId;
	private int ClientId;
	private String Contains;
	private int JourneyId;
	private String StartLocation;
	private String CurrentLocation;
	private String Destination;
	private InternalStatus Current = new InternalStatus(1,25,79);
	private Date deadline;
	
	public DataContainer(int cont,int cli, String contains, int jou, String stl, String des, Date deadline) {
		
		this.ContainerId=cont;
		this.ClientId=cli;
		this.Contains=contains;
		this.JourneyId=jou;
		this.StartLocation=stl;
		this.CurrentLocation=stl;
		this.Destination=des;
		this.deadline=deadline;
		
	}
	public void setCurrentLocation(String location) {
		this.CurrentLocation=location;
	}
	public String getCurrentLocation() {
		return CurrentLocation;
	}
	public InternalStatus getIntenalStatus() {
		return Current;
	}
	
	
	
}
