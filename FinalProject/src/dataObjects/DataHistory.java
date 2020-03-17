package dataObjects;

import java.time.LocalDateTime;
import java.util.Date;

public class DataHistory {
	private LocalDateTime time;
	private Date date;
	private int ContainerId;
	private String contains;
	private InternalStatus status;
	private int journeyId;
	private String location;
	public DataHistory(int cont, String contains, InternalStatus status, int jou, String location) {
		this.time=LocalDateTime.now();
		this.date=new Date();
		this.ContainerId=cont;
		this.contains=contains;
		this.status=status;
		this.journeyId=jou;
		this.location=location;
		
	}
	public InternalStatus getStatus() {
		return status;
	}
	public String getLocation() {
		return location;
	}
	public String getContains() {
		return contains;
	}
	
	
}
