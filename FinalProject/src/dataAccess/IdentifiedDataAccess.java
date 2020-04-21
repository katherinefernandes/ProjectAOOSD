package dataAccess;

import java.util.*;

import javax.xml.stream.XMLStreamException;

import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;

public abstract class IdentifiedDataAccess<T extends IdentifiableData> extends DataAccess<T> {
	private ActiveIdentifiableData<T> activeData;
	
	public IdentifiedDataAccess(String filename, String dataPointTagName, String collectionTagName) {
		super(filename, dataPointTagName, collectionTagName);
		activeData = new ActiveIdentifiableData<>();
	}
	
	protected abstract T dataFromEvents(DataPointParser dataPoint);
	
	@Override
	public void newEntry(T newData) {
		activeData.storeNewData(newData);
	}

	@Override
	public List<T> searchEntries(String searchWord) {
		List<T> matchingEntries = activeData.findMatchingEntriesFromActiveData(searchWord);
		matchingEntries.addAll(findMatchingEntriesFromFile(searchWord));
		return matchingEntries;
	}

	public T getEntry(long ID) throws ElementNotFoundException {
		List<T> matchingEntries = searchEntries(String.valueOf(ID));
		if(matchingEntries.size() == 0) {
			throw new ElementNotFoundException("Given element could not be found in database");
		}
		return matchingEntries.get(0);
	}
	
	public void editEntry(T data) {
		//Might implement checks for whether entry exists
		newEntry(data);
	}
	
	public void deleteEntry(long ID) {
		activeData.removeDataWithID(ID);
		
		xmlIO.initializeIO();
		removeDataWithIDFromFile(ID);
		xmlIO.finishWriteIO();
	}
	
	@Override
	public void flushActiveData() {
		xmlIO.initializeIO();
		zipActiveDataToFile();
		xmlIO.finishWriteIO();
	}
	
	@Override
	protected EventParser createStartTag(T data) {
		EventParser startTag = EventParser.generateStart(dataPointTagName);
		startTag.setIDAttribute(data.getID());
		return startTag;
	}

	private void removeDataWithIDFromFile(long ID) {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName,String.valueOf(ID));
		xmlIO.transferNext();
		xmlIO.transferNext();
		while(xmlIO.hasNext()) {
			EventParser event = xmlIO.readEvent();
			dataPointParser.handleMatchOnID(event);
			if(dataPointParser.isCompleteDataPoint() && !dataPointParser.isCompleteMatchingDataPoint()) {
				xmlIO.insertDataPoint(dataPointParser.getDataPoint());
			}
		}
		xmlIO.writeEvent(EventParser.generateEnd(collectionTagName));
		xmlIO.writeEvent(EventParser.generateEndDoc());
	}

	private void zipActiveDataToFile() {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName);
		xmlIO.transferNext();
		xmlIO.transferNext();
		while(xmlIO.hasNext()) {
			dataPointParser = handleNextEvent(dataPointParser);
		}
		while(!activeData.isEmpty()) {
			transferFirstActiveDataToFile();
		}
		xmlIO.writeEvent(EventParser.generateEnd(collectionTagName));
		xmlIO.writeEvent(EventParser.generateEndDoc());
	}

	private DataPointParser handleNextEvent(DataPointParser dataPointParser){
		EventParser event = xmlIO.readEvent();
		dataPointParser.handleMatchOnID(event);
		if(event.isStartOfDataPoint(dataPointTagName)) {
			insertAllLesserActiveData(dataPointParser);
		}else if(event.isEndOfDataPoint(dataPointTagName) && !dataPointParser.isCompleteMatchingDataPoint()) {
			xmlIO.insertDataPoint(dataPointParser.getDataPoint());
		}
		return dataPointParser;
	}

	private void transferFirstActiveDataToFile() {
		xmlIO.insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
		activeData.removeDataAtIndex(0);
	}

	private void insertAllLesserActiveData(DataPointParser dataPointParser) {
		while(!activeData.isEmpty() && activeData.getDataAtIndex(0).getID() < dataPointParser.getID()) {
			transferFirstActiveDataToFile();
		}
		if(!activeData.isEmpty() && activeData.getDataAtIndex(0).getID() == dataPointParser.getID()) {
			transferFirstActiveDataToFile();
			dataPointParser.setIsMatchingEntry(true);
		}
	}
	
	private List<T> findMatchingEntriesFromFile(String searchWord) {
		xmlIO.initializeIO();
		List<T> matchingEntries = searchThroughAllEvents(searchWord);
		xmlIO.finishReadIO();
		return matchingEntries;
	}

	private List<T> searchThroughAllEvents(String searchWord) {
		List<T> matchingEntries = new ArrayList<>();
		DataPointParser currentDataPoint = new DataPointParser(dataPointTagName,searchWord);
		xmlIO.readEvent();
		xmlIO.readEvent();
		while(xmlIO.hasNext()) {
			EventParser event = xmlIO.readEvent();
			currentDataPoint.handleMatchOnIDAndValue(event);
			if(currentDataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(currentDataPoint));
			}
		}
		return matchingEntries;
	}
}
