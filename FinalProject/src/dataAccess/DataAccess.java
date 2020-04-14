package dataAccess;

import objectsData.ObjectData;
import objectsData.XMLField;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.stream.events.*;
import javax.xml.validation.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public abstract class DataAccess<T extends ObjectData> {
	protected Schema schema;
	protected String filePath;
	protected List<T> activeData;
	protected List<XMLEvent> currentDatapoint;
	protected String tagName;
	protected boolean correctPositionFound;
	
	protected XMLEventFactory eventFactory;
	protected XMLEventReader reader;
	protected XMLEventWriter writer;
	protected FileInputStream streamIn;
	protected FileOutputStream streamOut;
	protected File fileIn;
	protected File fileOut;
	
	protected List<XMLEvent> eventsFromData(T data){
		List<XMLField> xmlFields = data.getXML();
		List<XMLEvent> events = new ArrayList<>();
		List<Attribute> IDList = new ArrayList<>();
		Attribute ID = eventFactory.createAttribute(QName.valueOf("ID"), String.valueOf(data.getID()));
		IDList.add(ID);
		StartElement start = eventFactory.createStartElement("", "", data.getTagname(), IDList.iterator(), new ArrayList<Namespace>().iterator());
		events.add(start);
		try {
			for(XMLField field : xmlFields) {
				events.addAll(fieldToEvent(new ArrayList<XMLEvent>(),field));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		EndElement end = eventFactory.createEndElement(QName.valueOf(data.getTagname()),new ArrayList<Namespace>().iterator());
		events.add(end);
		return events ;
	}
	
	protected abstract T dataOfEvents(List<XMLEvent> events, long ID);
	
	DataAccess(String fileName) {
		filePath = fileName;
		nullifyIO();
		eventFactory = XMLEventFactory.newInstance();
		activeData = new ArrayList<>();
		currentDatapoint = new ArrayList<>();
		tagName = "";
		
	}
	
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
		while(reader.hasNext()) {
			XMLEvent event = reader.nextEvent();
			if(event.isStartElement()) {
				StartElement start = event.asStartElement();
				IDattribute = start.getAttributeByName(QName.valueOf("ID"));
				if(IDattribute != null) {
					if(correctPositionFound) {
						matchingEntries.add(dataOfEvents(currentDatapoint,Long.valueOf(IDattribute.getValue())));
					}
					if(!String.valueOf(IDattribute.getValue()).contains(searchWord)) {
						correctPositionFound = false;
					}
					else {
						correctPositionFound = true;
					}
					currentDatapoint = new ArrayList<>();
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
			matchingEntries.add(dataOfEvents(currentDatapoint,Long.valueOf(IDattribute.getValue())));
		}
		} catch (XMLStreamException e) {
			closeIO();
			e.printStackTrace();
		}
		closeIO();
		return matchingEntries;
	}

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
						insertDatapoint(eventsFromData(activeData.get(0)));
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
		insertDatapoint(currentDatapoint);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		writeIO();
	}

	private void insertDatapoint(List<XMLEvent> Datapoint) {
		for(XMLEvent event : Datapoint) {
			try {
				writer.add(event);
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
		}
	}

	public void closeIO(){
		try {
			fileOut.delete();
			writer.close();
			reader.close();
			streamIn.close();
			streamOut.close();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
		nullifyIO();
	}
	
	public void writeIO() {
		try {
			writer.flush();
			writer.close();
			reader.close();
			streamIn.close();
			streamOut.close();
			Files.move(fileOut.toPath(),fileIn.toPath(), StandardCopyOption.REPLACE_EXISTING);
			fileOut.delete();
			nullifyIO();
			//closeIO();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}

	public void initializeIO() {
		try {
			fileIn = new File(filePath);
			fileOut = new File("temp.xml");
			fileOut.createNewFile();
			streamIn = new FileInputStream(fileIn);
			streamOut = new FileOutputStream(fileOut);
			reader = XMLInputFactory.newInstance().createXMLEventReader(streamIn);
			writer = XMLOutputFactory.newInstance().createXMLEventWriter(streamOut);
		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
		correctPositionFound = false;
	}

	public void nullifyIO() {
		fileIn = null;
		fileOut = null;
		XMLEventReader reader = null;
		XMLEventWriter writer = null;
		FileInputStream streamIn = null;
		FileOutputStream streamOut = null;
	}
	
	protected int iterateUntilFound(int index, List<XMLEvent> events, String find) {
		XMLEvent event;
		while(!((event = events.get(index)).isStartElement() && (event.asStartElement()).getName().getLocalPart().equals(find))){
			index++;
		}
		return index;
	}
	
	protected StartElement generateStart(String string) {
		return eventFactory.createStartElement("","",string);
	}
	
	protected Characters generateText(Object string) {
		return eventFactory.createCharacters(String.valueOf(string));
	}
	
	protected EndElement generateEnd(String string) {
		return eventFactory.createEndElement("", "", string);
	}
	
	private List<XMLEvent> fieldToEvent(List<XMLEvent> events, XMLField field) throws Exception{
		switch(field.getValueType()){
		case 0:
			events.add(generateStart(field.getTagName()));
			events.add(generateText(field.getValue()));
			events.add(generateEnd(field.getTagName()));
			return events;
		case 1:
			events.add(generateStart(field.getTagName()));
			for(String value : field.getValues()) {
				events.add(generateStart(field.getValuesName()));
				events.add(generateText(value));
				events.add(generateEnd(field.getValuesName()));
			}
			events.add(generateEnd(field.getTagName()));
			return events;
		case 2:
			events.add(generateStart(field.getTagName()));
			for(XMLField xml : field.getCompound()) {
				fieldToEvent(events,xml);
			}
			events.add(generateEnd(field.getTagName()));
			return events;
		}
		throw new Exception("This should never happen");
	}
}
