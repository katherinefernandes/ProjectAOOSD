package dataAccess;

import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

import exceptions.ElementNotFoundException;
import objectsData.ObjectData;

public abstract class IdentifiedDataAccess<T extends ObjectData> extends DataAccess<T> {
	
	public IdentifiedDataAccess(String filename, String elementsName, String collectionName) {
		super(filename, elementsName, collectionName);
	}
	
	protected abstract T dataOfEvents(List<XMLEvent> events, long ID);
	
	@Override
	public void newEntry(T newData) {
		long newID = newData.getID();
		for(int i = 0; i < activeData.size(); i++) {
			long currentID = activeData.get(i).getID();
			if (newID <= currentID) {
				activeData.add(i, newData);
				if (newID == currentID) {
					activeData.remove(i + 1);
				}
				return;
			}
		}
		activeData.add(newData);
	}
	
	@Override
	public List<T> searchEntries(String searchWord) {
		List<T> matchingEntries = new ArrayList<>();
		for(T data : activeData) {
			for(String value : data.dumpValues()) {
				if(value.contains(searchWord)) {
					matchingEntries.add(data);
					break;
				}
			}
		}
		
		initializeIO();
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
						matchingEntries.add(dataOfEvents(currentDatapoint,currentID));
					}
					if(!String.valueOf(IDattribute.getValue()).contains(searchWord)) {
						correctPositionFound = false;
					}
					else {
						correctPositionFound = true;
					}
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
			matchingEntries.add(dataOfEvents(currentDatapoint,currentID));
		}
		} catch (XMLStreamException e) {
			closeIO();
			e.printStackTrace();
		}
		closeIO();
		return matchingEntries;
	}
	
	//TODO has become deprecated, to be deleted
	public T getEntry(long ID) throws ElementNotFoundException {
		for(T data : activeData) {
			long dataID = data.getID();
			if(dataID == ID) {
				return data;
			}
			if(dataID > ID) {
				break;
			}
		}
		
		initializeIO();
		try {
		correctPositionFound = false;
		long IDvalue = 0L;
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				Attribute IDattribute = start.getAttributeByName(QName.valueOf("ID"));
				if(IDattribute != null) {
					if(correctPositionFound) {
						closeIO();
						return dataOfEvents(currentDatapoint, IDvalue); 
					}
					IDvalue = Long.valueOf(IDattribute.getValue());
					
					if(ID < IDvalue) {
						break;
					}
					if(ID == IDvalue) {
						correctPositionFound = true;
					}
					
					currentDatapoint = new ArrayList<>();
				}
			}
			currentDatapoint.add(event);
		}
		if(correctPositionFound) {
			closeIO();
			return dataOfEvents(currentDatapoint, IDvalue); 
		}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		closeIO();
		throw new ElementNotFoundException("Element with given ID was not found");
	}
	
	public void editEntry(T data) {
		newEntry(data);
	}
	
	public void deleteEntry(long ID) {
		for(int i = 0; i < activeData.size(); i++) {
			long currentID = activeData.get(i).getID();
			if(currentID == ID) {
				activeData.remove(i);
				break;
			}
			if(currentID > ID) {
				break;
			}
		}
		
		initializeIO();
		
		try {
		correctPositionFound = false;
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
			writer.add(eventFactory.createEndElement("", "", collectionsName));
			writer.add(eventFactory.createEndDocument());
		}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		writeIO();
	}
	
	@Override
	public void flushActiveData() {
		initializeIO();
		
		try {
		boolean overwrite = false;
		writer.add(reader.nextEvent());
		writer.add(reader.nextEvent());
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				Attribute ID = start.getAttributeByName(QName.valueOf("ID"));
				if(ID != null) {
					overwrite = false;
					insertDatapoint(currentDatapoint);
					while(activeData.size() > 0 && Long.valueOf(ID.getValue()) > activeData.get(0).getID()) {						
						insertDatapoint(eventsFromData(activeData.get(activeData.size()-1)));
						activeData.remove(0);
					}
					if(activeData.size() > 0 && Long.valueOf(ID.getValue()) == activeData.get(0).getID()) {
						insertDatapoint(eventsFromData(activeData.get(0)));
						activeData.remove(0);
						overwrite = true;
					}
					currentDatapoint = new ArrayList<>();
				}
			}
			if(!overwrite) {
				currentDatapoint.add(event);
			}
		}
		if(activeData.size() > 0) {
			for(T dataPoint : activeData) {
				insertDatapoint(eventsFromData(dataPoint));
			}
			activeData = new ArrayList<>();
		}
		if(overwrite) {
			currentDatapoint.add(eventFactory.createEndElement("", "", collectionsName));
			currentDatapoint.add(eventFactory.createEndDocument());
		}
		insertDatapoint(currentDatapoint);
		
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		writeIO();
	}
	
	@Override
	protected StartElement createStartTag(T data) {
		List<Attribute> IDList = new ArrayList<>();
		Attribute ID = eventFactory.createAttribute(QName.valueOf("ID"), String.valueOf(data.getID()));
		IDList.add(ID);
		return eventFactory.createStartElement("", "", elementsName, IDList.iterator(), new ArrayList<Namespace>().iterator());
	}
}
