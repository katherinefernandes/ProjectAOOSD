package dataAccess;

import objectsData.ObjectDataInterface;
import objectsData.XMLField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import javax.xml.validation.*;

public abstract class DataAccess<T extends ObjectDataInterface> {
	protected String dataPointTagName;
	protected String collectionTagName;
	protected XMLIO xmlIO; //TODO abstract class IO
	
	
	public DataAccess(String filePath, String elementsName, String collectionsName) {
		this.xmlIO = new XMLIO(filePath);
		this.dataPointTagName = elementsName;
		this.collectionTagName = collectionsName;
	}
	
	
	public abstract void newEntry(T data);
	
	public abstract List<T> searchEntries(String searchWord);

	public abstract void flushActiveData();
	
	protected abstract EventParser createStartTag(T data);
	
	protected List<EventParser> eventsFromData(T data){
		List<EventParser> events = new ArrayList<>();
		addStartElement(data, events);
		addAllFieldsAsEvents(data.getXML(), events);
		addEndElement(data, events);
		return events;
	}

	protected int iterateUntilFound(int index, DataPointParser dataPoint, String find) {
		XMLEvent event;
		while(!((event = dataPoint.getEventAtIndex(index).getEvent()).isStartElement() && event.asStartElement().getName().getLocalPart().equals(find))){
			index++;
		}
		return index;
	}
	
	private void addStartElement(T data, List<EventParser> events) {
		events.add(createStartTag(data));
	}
	
	private void addAllFieldsAsEvents(List<XMLField> xmlFields, List<EventParser> events) {
		try {
			for(XMLField field : xmlFields) {
				events.addAll(field.fieldToEvent(new ArrayList<EventParser>()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addEndElement(T data, List<EventParser> events) {
		events.add(EventParser.generateEnd(data.getTagname()));
	}

}
