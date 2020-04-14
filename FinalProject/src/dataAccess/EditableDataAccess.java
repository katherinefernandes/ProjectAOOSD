package dataAccess;

import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

import exceptions.ElementNotFoundException;
import objectsData.ObjectData;

public abstract class EditableDataAccess<T extends ObjectData> extends DataAccess<T> {
	
	public EditableDataAccess(String filename) {
		super(filename);
	}
	
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
			writer.add(event);
		}
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeIO();
	}
}
