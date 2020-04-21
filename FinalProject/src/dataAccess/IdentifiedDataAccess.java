package dataAccess;

import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

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
		
		initializeIO();
		removeDataWithIDFromFile(ID);
		finishWriteIO();
	}
	
	@Override
	public void flushActiveData() {
		initializeIO();
		zipActiveDataToFile();
		finishWriteIO();
	}

	private void removeDataWithIDFromFile(long ID) {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName,String.valueOf(ID));
		try {
		writer.add(reader.nextEvent());
		writer.add(reader.nextEvent());
		while(reader.hasNext()) {
			EventParser event = new EventParser(reader.nextEvent());
			dataPointParser.handleMatchOnID(event);
			if(dataPointParser.isCompleteDataPoint() && !dataPointParser.isCompleteMatchingDataPoint()) {
				insertDataPoint(dataPointParser.getDataPoint());
			}
		}
		writer.add((XMLEvent) eventFactory.createEndElement("", "", collectionTagName));
		writer.add((XMLEvent) eventFactory.createEndDocument());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private void zipActiveDataToFile() {
		DataPointParser dataPointParser = new DataPointParser(dataPointTagName);
		try {
		writer.add(reader.nextEvent());
		writer.add(reader.nextEvent());
		while(reader.hasNext()) {
			dataPointParser = handleNextEvent(dataPointParser);
		}
		while(!activeData.isEmpty()) {
			transferFirstActiveDataToFile();
		}
		writer.add((XMLEvent) eventFactory.createEndElement("", "", collectionTagName));
		writer.add((XMLEvent) eventFactory.createEndDocument());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	private DataPointParser handleNextEvent(DataPointParser dataPointParser) throws XMLStreamException {
		EventParser event = new EventParser(reader.nextEvent());
		dataPointParser.handleMatchOnID(event);
		if(event.isStartOfDataPoint(dataPointTagName)) {
			insertAllLesserActiveData(dataPointParser);
		}else if(event.isEndOfDataPoint(dataPointTagName) && !dataPointParser.isCompleteMatchingDataPoint()) {
			insertDataPoint(dataPointParser.getDataPoint());
		}
		return dataPointParser;
	}

	private void transferFirstActiveDataToFile() {
		insertDataPoint(eventsFromData(activeData.getDataAtIndex(0)));
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
	
	@Override
	protected EventParser createStartTag(T data) {
		List<Attribute> IDList = new ArrayList<>();
		Attribute ID = eventFactory.createAttribute(QName.valueOf("ID"), String.valueOf(data.getID()));
		IDList.add(ID);
		return new EventParser(eventFactory.createStartElement("", "", dataPointTagName, IDList.iterator(), new ArrayList<Namespace>().iterator()));
	}
	
	private List<T> findMatchingEntriesFromFile(String searchWord) {
		initializeIO();
		List<T> matchingEntries = searchThroughAllEvents(searchWord);
		finishReadIO();
		return matchingEntries;
	}

	private List<T> searchThroughAllEvents(String searchWord) {
		List<T> matchingEntries = new ArrayList<>();
		DataPointParser currentDataPoint = new DataPointParser(dataPointTagName,searchWord);
		try {
		reader.nextEvent();
		reader.nextEvent();
		while(reader.hasNext()) {
			EventParser event = new EventParser(reader.nextEvent());
			currentDataPoint.handleMatchOnIDAndValue(event);
			if(currentDataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(dataFromEvents(currentDataPoint));
			}
		}
		} catch (XMLStreamException e) {
			finishReadIO();
			e.printStackTrace();
		}
		return matchingEntries;
	}
}
