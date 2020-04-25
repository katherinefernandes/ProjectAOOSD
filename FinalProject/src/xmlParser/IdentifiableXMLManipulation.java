package xmlParser;

import java.util.*;
import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;

public abstract class IdentifiableXMLManipulation<T extends IdentifiableData> extends GeneralXMLManipulation<T> {
	private ActiveIdentifiableData<T> activeData;
	
	protected IdentifiableXMLManipulation(String filename, String dataPointTagName, String collectionTagName) {
		super(filename, dataPointTagName, collectionTagName);
		activeData = new ActiveIdentifiableData<>();
	}
	
	public void newEntry(T newData) {
		activeData.storeNewData(newData);
		if (activeData.size() > 5) {
			flushActiveData();
		}
	}

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
	
	public void deleteEntry(long ID) {
		activeData.removeDataWithID(ID);
		
		io.initializeIO();
		removeDataWithIDFromFile(ID);
		io.finishWriteIO();
	}
	
	public boolean isSavedID(long ID) {
		boolean exists = activeData.activeDataContainsID(ID);
		exists = exists || fileContainsID(ID);
		return exists;
	}
	
	@Override
	protected DataPointParser dataPointFromObject(T data){
		DataPointParser dataPoint = new DataPointParser(data.getTagname(),data.getID());
		dataPoint.createDataPoint(data.getXML());
		return dataPoint;
	}
	
	@Override
	protected void flushActiveData() {
		io.initializeIO();
		zipActiveDataToFile();
		io.finishWriteIO();
	}
	
	@Override
	protected void wipeActiveData() {
		activeData.wipeAllData();
	}
	
	private boolean fileContainsID(long ID) {
		io.initializeIO();
		boolean isFound = searchFileForID(String.valueOf(ID));
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
				io.insertDataPoint(dataPointParser);
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
			io.insertDataPoint(dataPointParser);
		}
		return dataPointParser;
	}

	private void transferFirstActiveDataToFile() {
		io.insertDataPoint(dataPointFromObject(activeData.getDataAtIndex(0)));
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
				matchingEntries.add(objectFromDataPoint(currentDataPoint));
			}
		}
		return matchingEntries;
	}
}