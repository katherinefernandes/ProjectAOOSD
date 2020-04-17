package dataAccess;

import objectsData.ObjectData;
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
	protected Schema schema;
	protected String filePath;
	protected String elementsName;
	protected String collectionsName;
	
	protected XMLEventFactory eventFactory;
	protected XMLEventReader reader;
	protected XMLEventWriter writer;
	protected FileInputStream streamIn;
	protected FileOutputStream streamOut;
	protected File fileIn;
	protected File fileOut;
	
	
	public DataAccess(String filePath, String elementsName, String collectionsName) {
		this.filePath = filePath;
		this.elementsName = elementsName;
		this.collectionsName = collectionsName;
		eventFactory = XMLEventFactory.newInstance();
	}
	
	
	public abstract void newEntry(T data);
	
	public abstract List<T> searchEntries(String searchWord);

	public abstract void flushActiveData();
	
	protected abstract StartElement createStartTag(T data);
	
	protected List<XMLEvent> eventsFromData(T data){
		List<XMLEvent> events = new ArrayList<>();
		addStartElement(data, events);
		addAllFieldsAsEvents(data.getXML(), events);
		addEndElement(data, events);
		return events;
	}
	
	protected void finishReadIO() {
		fileOut.delete();
		closeIO();
	}

	protected void closeIO(){
		try {
			writer.close();
			reader.close();
			streamIn.close();
			streamOut.close();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	protected void finishWriteIO() {
		try {
			writer.flush();
			closeIO();
			Files.move(fileOut.toPath(),fileIn.toPath(), StandardCopyOption.REPLACE_EXISTING);
			fileOut.delete();
		} catch (IOException | XMLStreamException e) {
			e.printStackTrace();
		}
	}

	protected void initializeIO() {
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
	}
	
	protected int iterateUntilFound(int index, List<XMLEvent> events, String find) {
		XMLEvent event;
		while(!((event = events.get(index)).isStartElement() && getEventName(event).equals(find))){
			index++;
		}
		return index;
	}
	
	protected void insertDatapoint(List<XMLEvent> Datapoint) {
		try {
		for(XMLEvent event : Datapoint) {
				writer.add(event);
			} 
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	protected List<XMLEvent> fieldToEvent(List<XMLEvent> events, XMLField field){
		try {
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		throw new Error("Invalid field type");
	}
	
	protected String getEventName(XMLEvent event) {
		if(event.isStartElement()) {
			return event.asStartElement().getName().getLocalPart();
		}
		else if(event.isEndElement()) {
			return event.asEndElement().getName().getLocalPart();
		}
		else {
			throw new Error("Can only get name from start and end elements");
		}
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
	
	private void addStartElement(T data, List<XMLEvent> events) {
		events.add(createStartTag(data));
	}
	
	private void addAllFieldsAsEvents(List<XMLField> xmlFields, List<XMLEvent> events) {
		try {
			for(XMLField field : xmlFields) {
				events.addAll(fieldToEvent(new ArrayList<XMLEvent>(),field));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addEndElement(T data, List<XMLEvent> events) {
		events.add(generateEnd(data.getTagname()));
	}

}
