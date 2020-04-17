package dataAccess;

import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;
import objectsData.ObjectData;

public abstract class IdentifiedDataAccess<T extends IdentifiableData> extends DataAccess<T> {
	private ActiveIdentifiableData<T> activeData;
	
	public IdentifiedDataAccess(String filename, String elementsName, String collectionName) {
		super(filename, elementsName, collectionName);
		activeData = new ActiveIdentifiableData<>();
	}
	
	protected abstract T dataFromEvents(List<XMLEvent> events, long ID);
	
	@Override
	public void newEntry(T newData) {
		activeData.storeNewData(newData);
	}


	@Override
	public List<T> searchEntries(String searchWord) {
		List<T> matchingEntries = activeData.searchThroughData(searchWord);
		
		initializeIO();
		boolean correctPositionFound = false;
		List<XMLEvent> currentDatapoint = new ArrayList<>();
		try {
		Attribute IDattribute = null;
		long currentID = 0L;
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				IDattribute = start.getAttributeByName(QName.valueOf("ID"));
				if(IDattribute != null) {
					if(correctPositionFound) {
						matchingEntries.add(dataFromEvents(currentDatapoint,currentID));
					}
					
					correctPositionFound = searchWordIsInID(searchWord, IDattribute);
					
					currentDatapoint = new ArrayList<>();
					currentID = Long.valueOf(IDattribute.getValue());
				}
			}
			if(event.isCharacters()) {
				Characters chars = event.asCharacters();
				if(chars.getData().contains(searchWord)) {
					correctPositionFound = true;
				}
			}
			currentDatapoint.add(event);
		}
		if(correctPositionFound) {
			matchingEntries.add(dataFromEvents(currentDatapoint,currentID));
		}
		} catch (XMLStreamException e) {
			finishReadIO();
			e.printStackTrace();
		}
		finishReadIO();
		return matchingEntries;
	}

	private boolean searchWordIsInID(String searchWord, Attribute IDattribute) {
		return IDattribute.getValue().contains(searchWord);
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
		boolean correctPositionFound = false;
		
		try {
		XMLEvent event = null;
		while(reader.hasNext()) {
			event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				Attribute IDattr = start.getAttributeByName(QName.valueOf("ID"));
				if(IDattr != null) {
					if(Long.valueOf(IDattr.getValue()) == ID) {
						correctPositionFound = true;
					}else {
						correctPositionFound = false;
					}
				}
			}
			if(!correctPositionFound) {
				writer.add(event);
			}
		}
		if(correctPositionFound) { //If this was true then the last element was deleted as well as end tag
			writer.add((XMLEvent) eventFactory.createEndElement("", "", collectionsName));
			writer.add((XMLEvent) eventFactory.createEndDocument());
		}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		finishWriteIO();
	}
	
	@Override
	public void flushActiveData() {
		initializeIO();
		boolean overwrite = false;
		List<XMLEvent> currentDatapoint = new ArrayList<>();
		
		try {
		writer.add(reader.nextEvent());
		writer.add(reader.nextEvent());
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				Attribute ID = start.getAttributeByName(QName.valueOf("ID"));
				if(ID != null) {
					overwrite = false;
					while(!activeData.isEmpty() && Long.valueOf(ID.getValue()) > activeData.getDataAtIndex(0).getID()) {						
						insertDatapoint(eventsFromData(activeData.getDataAtIndex(0)));
						activeData.removeDataAtIndex(0);
					}
					if(!activeData.isEmpty() && Long.valueOf(ID.getValue()) == activeData.getDataAtIndex(0).getID()) {
						insertDatapoint(eventsFromData(activeData.getDataAtIndex(0)));
						activeData.removeDataAtIndex(0);
						overwrite = true;
					}
				}
			}
			currentDatapoint.add(event);
			if(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals(elementsName)){
				if(!overwrite) {
					insertDatapoint(currentDatapoint);
				}
				currentDatapoint = new ArrayList<>();
			}
			
		}
		while(!activeData.isEmpty()) {
			insertDatapoint(eventsFromData(activeData.getDataAtIndex(0)));
			activeData.removeDataAtIndex(0);
		}
		insertDatapoint(currentDatapoint);
		
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		finishWriteIO();
	}
	
	@Override
	protected StartElement createStartTag(T data) {
		List<Attribute> IDList = new ArrayList<>();
		Attribute ID = eventFactory.createAttribute(QName.valueOf("ID"), String.valueOf(data.getID()));
		IDList.add(ID);
		return eventFactory.createStartElement("", "", elementsName, IDList.iterator(), new ArrayList<Namespace>().iterator());
	}
}
