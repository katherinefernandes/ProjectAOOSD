package objectsData;

import java.util.Date;

public class ContainerData implements ObjectData {
	private int ContainerId;
	private int ClientId;
	private String Contains;
	private int JourneyId;
	private String StartLocation;
	private String CurrentLocation;
	private String Destination;
	private InternalStatusData Current = new InternalStatusData(1,25,79);
	private Date deadline;
	public String getStartLocation() {
		return StartLocation;
	}
	public String getDestination() {
		return Destination;
	}
	public Date getDeadline() {
		return deadline;
	}
	public int getContainerId() {
		return this.ContainerId;
	}
	public int getClientId() {
		return this.ClientId;
	}
	public int getJourneyId() {
		return this.JourneyId;
	}
	public String getContains() {
		return this.Contains;
	}
	public void setCurrentLocation(String location) {
		this.CurrentLocation=location;
	}
	public String getCurrentLocation() {
		return CurrentLocation;
	}
	public InternalStatusData getInternalStatus() {
		return Current;
	}
	public void setInternalStatus(InternalStatusData status) {
		this.Current=status;
	}
	public ContainerData(int cont,int cli, String contains, int jou, String stl, String des, Date deadline) {
		
		this.ContainerId=cont;
		this.ClientId=cli;
		this.Contains=contains;
		this.JourneyId=jou;
		this.StartLocation=stl;
		this.CurrentLocation=stl;
		this.Destination=des;
		this.deadline=deadline;
		
	}
	
	
	
	
}
