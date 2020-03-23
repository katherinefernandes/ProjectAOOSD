package objectsData;

import java.time.LocalDateTime;
import java.util.Date;

public class HistoryData extends ObjectData {
	private LocalDateTime time;
	private Date date;
	private int ContainerId;
	private String contains;
	private InternalStatusData status;
	private int journeyId;
	private String location;
	public HistoryData(int cont, String contains, InternalStatusData status, int jou, String location) {
		this.time=LocalDateTime.now();
		this.date=new Date();
		this.ContainerId=cont;
		this.contains=contains;
		this.status=status;
		this.journeyId=jou;
		this.location=location;
		
	}
	public InternalStatusData getStatus() {
		return status;
	}
	public String getLocation() {
		return location;
	}
	public String getContains() {
		return contains;
	}
	
	
}
