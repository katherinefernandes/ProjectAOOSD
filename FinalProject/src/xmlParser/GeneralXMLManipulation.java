package xmlParser;

import java.util.ArrayList;
import java.util.List;

import businessObjects.BusinessObject;
import exceptions.ElementSelectionException;

public abstract class GeneralXMLManipulation<T extends BusinessObject> {
	protected String dataPointTagName;
	protected String collectionTagName;
	protected IO io;
	protected ActiveData<T> activeData;
	
	protected GeneralXMLManipulation(String filePath, String elementsName, String collectionsName) {
		this.io = new XMLIO(filePath);
		this.dataPointTagName = elementsName;
		this.collectionTagName = collectionsName;
		activeData = new ActiveIDSortedData<>();
		Thread shutDownFlush = new Thread(() -> flushActiveData());
		Runtime.getRuntime().addShutdownHook(shutDownFlush);
	}
	
	protected abstract T objectFromDataPoint(DataPointParser dataPoint);

	protected abstract DataPointParser dataPointFromObject(T object);
	
	
	public void newEntry(T newData) {
		activeData.storeNewData(newData);
		if (activeData.size() > 10) {
			flushActiveData();
		}
	}

	public List<T> searchEntries(String searchWord) {
		List<T> matchingEntries = new ArrayList<>();
		flushActiveData();
		matchingEntries.addAll(findMatchingEntriesFromFile(searchWord));
		activeData.storeAllData(matchingEntries);
		return matchingEntries;
	}

	public T getEntry(long ID) throws ElementSelectionException {
		//Search memory
		List<T> matchingEntries = activeData.findMatchingEntriesFromActiveData(String.valueOf(ID));
		matchingEntries.removeIf( object -> object.getID() != ID);
		if(matchingEntries.size() == 1) {
			return matchingEntries.get(0);
		}else if(matchingEntries.size() > 1) {
			throw new ElementSelectionException("More than one element matched with given ID");
		}
		//Search file
		matchingEntries = searchEntries(String.valueOf(ID));
		matchingEntries.removeIf( object -> object.getID() != ID);
		if(matchingEntries.size() == 0) {
			throw new ElementSelectionException("Given element could not be found in database");
		}else if(matchingEntries.size() > 1) {
			throw new ElementSelectionException("More than one element matched with given ID");
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

	protected void flushActiveData() {
		io.initializeIO();
		zipActiveDataToFile();
		io.finishWriteIO();
	}

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
	
	protected List<T> findMatchingEntriesFromFile(String searchWord) {
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
	
	@Override
	public void finalize() {
		flushActiveData();
	}
	
	public void wipe() {
		wipeActiveData();
		io.initializeIO();
		io.transferNext();
		io.transferNext();
		io.writeEvent(EventParser.generateEnd(collectionTagName));
		io.writeEvent(EventParser.generateEndDoc());
		io.finishWriteIO();
	}
}
