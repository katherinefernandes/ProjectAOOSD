package xmlParser;

import java.util.*;

import javax.xml.stream.XMLStreamException;

import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;

public abstract class IdentifiableXMLManipulation<T extends IdentifiableData> extends GeneralXMLManipulation<T> {
	private ActiveIdentifiableData<T> activeData;
	
	public IdentifiableXMLManipulation(String filename, String dataPointTagName, String collectionTagName) {
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
		
		io.initializeIO();
		removeDataWithIDFromFile(ID);
		io.finishWriteIO();
	}
	
	public boolean IDExists(String ID) {
		boolean exists = activeData.IDIsInActiveData(ID);
		exists = exists || IDIsInFile(ID);
		return exists;
	}
	
	@Override
	public void flushActiveData() {
		io.initializeIO();
		zipActiveDataToFile();
		io.finishWriteIO();
	}
	
	@Override
	protected EventParser createStartTag(T data) {
		EventParser startTag = EventParser.generateStart(dataPointTagName);
		startTag.setIDAttribute(data.getID());
		return startTag;
	}
	
	private boolean IDIsInFile(String ID) {
		io.initializeIO();
		boolean isFound = searchFileForID(ID);
		io.finishReadIO();
		return isFound;
	}
	
	private boolean searchFileForID(String ID) {
		DataPointParser dataPoint = new DataPointParser(dataPointTagName,ID);
		io.readEvent();
		io.readEvent();
		while(io.hasNext()) {
			dataPoint.handleMatchOnID(io.readEvent());
			if(dataPoint.isCompleteMatchingDataPoint()) {
				return true;
			}
		}
		return false;
	}

	private void removeDataWithIDFromFile(long ID) {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName,String.valueOf(ID));
		io.transferNext();
		io.transferNext();
		while(io.hasNext()) {
			EventParser event = io.readEvent();
			dataPointParser.handleMatchOnID(event);
			if(dataPointParser.isCompleteDataPoint() && !dataPointParser.isCompleteMatchingDataPoint()) {
				io.insertDataPoint(dataPointParser.getDataPoint());
			}
		}
		io.writeEvent(EventParser.generateEnd(collectionTagName));
		io.writeEvent(EventParser.generateEndDoc());
	}

	private void zipActiveDataToFile() {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName);
		io.transferNext();
		io.transferNext();
		while(io.hasNext()) {
			dataPointParser = handleNextEvent(dataPointParser);
		}
		while(!activeData.isEmpty()) {
			transferFirstActiveDataToFile();
		}
		io.writeEvent(EventParser.generateEnd(collectionTagName));
		io.writeEvent(EventParser.generateEndDoc());
	}

	private DataPointParser handleNextEvent(DataPointParser dataPointParser){
		EventParser event = io.readEvent();
		dataPointParser.handleMatchOnID(event);
		if(event.isStartOfDataPoint(dataPointTagName)) {
			insertAllLesserActiveData(dataPointParser);
		}else if(event.isEndOfDataPoint(dataPointTagName) && !dataPointParser.isCompleteMatchingDataPoint()) {
			io.insertDataPoint(dataPointParser.getDataPoint());
		}
		return dataPointParser;
	}

	private void transferFirstActiveDataToFile() {
		io.insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
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
		io.initializeIO();
		List<T> matchingEntries = searchThroughAllEvents(searchWord);
		io.finishReadIO();
		return matchingEntries;
	}

	private List<T> searchThroughAllEvents(String searchWord) {
		List<T> matchingEntries = new ArrayList<>();
		DataPointParser currentDataPoint = new DataPointParser(dataPointTagName,searchWord);
		io.readEvent();
		io.readEvent();
		while(io.hasNext()) {
			EventParser event = io.readEvent();
			currentDataPoint.handleMatchOnIDAndValue(event);
			if(currentDataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(currentDataPoint));
			}
		}
		return matchingEntries;
	}
}
