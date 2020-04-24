package XMLParser;

import java.util.*;
import javax.xml.stream.events.*;

public class DataPointParser {
	private Long ID;
	private List<EventParser> dataPoint;
	private String dataPointTagName;
	
	private String searchWord;
	private boolean isMatchingEntry;
	
	public DataPointParser(String dataPointTagName) {
		this.dataPointTagName = dataPointTagName;
		dataPoint = new ArrayList<>();
	}
	
	public DataPointParser(String dataPointTagName, String searchWord) {
		this(dataPointTagName);
		this.searchWord = searchWord;
	}
	
	public EventParser getEventAtIndex(int index) {
		return dataPoint.get(index);
	}
	
	public void setIsMatchingEntry(boolean isMatchingEntry) {
		this.isMatchingEntry = isMatchingEntry;
	}
	
	public List<EventParser> getDataPoint(){
		return dataPoint;
	}
	
	public long getID() {
		return ID;
		
	}
	
	public void handleMatchOnIDAndValue(EventParser event) {
		if(event.isStartOfDataPoint(dataPointTagName)) {
			handleMatchOnID(event);
		}else if(event.isDataField()) {
			handleMatchOnValue(event);
		}else {
			dataPoint.add(event);
		}
	}
	
	public void handleMatchOnID(EventParser event) {
		if(event.isStartOfDataPoint(dataPointTagName)) {
			Attribute IDAttribute = event.getIDAttribute();
			startNewDataPoint(Long.valueOf(IDAttribute.getValue()));
			if(searchWord != null) {
				isMatchingEntry = searchWordIsInID(IDAttribute);
			}
		}
		dataPoint.add(event);
	}
	
	
	public void startNewDataPoint(long ID) {
		this.ID = ID;
		isMatchingEntry = false;
		dataPoint = new ArrayList<>();
	}
	
	public void handleMatchOnValue(EventParser event) {
		if(event.isDataField()) {
			isMatchingEntry = checkIfMatching(event);
		}
		dataPoint.add(event);
	}

	private boolean checkIfMatching(EventParser event) {
		return isMatchingEntry || event.getData().contains(searchWord);
	}
	
	public boolean isCompleteMatchingDataPoint() {
		return isMatchingEntry && isCompleteDataPoint();
	}
	
	public boolean isCompleteDataPoint() {
		EventParser lastElement = dataPoint.get(dataPoint.size()-1);
		return lastElement.isEndOfDataPoint(dataPointTagName);
	}
	
	private boolean searchWordIsInID(Attribute IDattribute) {
		return IDattribute.getValue().contains(searchWord);
	}
}