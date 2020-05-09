package xmlParser;

import java.util.*;
import javax.xml.stream.events.*;

class DataPointParser {
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
	
	public DataPointParser(String dataPointTagName, long ID) {
		this(dataPointTagName);
		this.ID = ID;
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
	
	public int iterateUntilFound(int index, String find) {
		XMLEvent event;
		while(!((event = getEventAtIndex(index).getEvent()).isStartElement() && event.asStartElement().getName().getLocalPart().equals(find))){
			index++;
		}
		return index;
	}
	
	public void addStartEvent(String tagName) {
		dataPoint.add(EventParser.generateStart(tagName));
	}
	
	public void addStartEvent(String tagName, long ID) {
		EventParser event = EventParser.generateStart(tagName);
		event.setIDAttribute(ID);
		dataPoint.add(event);
	}
	
	public void addTextEvent(String text) {
		if(text != null) {
			dataPoint.add(EventParser.generateText(text));
		}
	}
	
	public void addEndEvent(String tagName) {
		dataPoint.add(EventParser.generateEnd(tagName));
	}
	
	public void addCompleteElement(String tagName, Object value) {
		dataPoint.add(EventParser.generateStart(tagName));
		if(value != null) {
			dataPoint.add(EventParser.generateText(String.valueOf(value)));
		}
		dataPoint.add(EventParser.generateEnd(tagName));
	}
	
	private boolean searchWordIsInID(Attribute IDattribute) {
		return IDattribute.getValue().contains(searchWord);
	}
}
