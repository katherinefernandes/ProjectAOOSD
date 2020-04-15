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
	protected String elementsName;
	protected String collectionsName;
	protected List<T> activeData;
	protected List<XMLEvent> currentDatapoint;
	protected boolean correctPositionFound;
	
	protected XMLEventFactory eventFactory;
	protected XMLEventReader reader;
	protected XMLEventWriter writer;
	protected FileInputStream streamIn;
	protected FileOutputStream streamOut;
	protected File fileIn;
	protected File fileOut;
	
	
	public DataAccess(String fileName, String elementsName, String collectionsName) {
		filePath = fileName;
		this.elementsName = elementsName;
		this.collectionsName = collectionsName;
		nullifyIO();
		eventFactory = XMLEventFactory.newInstance();
		activeData = new ArrayList<>();
		currentDatapoint = new ArrayList<>();
		
	}
	
	
	public abstract void newEntry(T data);
	
	public abstract List<T> searchEntries(String searchWord);

	public abstract void flushActiveData();
	
	protected abstract StartElement createStartTag(T data);
	
	protected List<XMLEvent> eventsFromData(T data){
		List<XMLField> xmlFields = data.getXML();
		List<XMLEvent> events = new ArrayList<>();
		StartElement start = createStartTag(data);
		events.add(start);
		try {
			for(XMLField field : xmlFields) {
				events.addAll(fieldToEvent(new ArrayList<XMLEvent>(),field));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		EndElement end = eventFactory.createEndElement(QName.valueOf(elementsName),new ArrayList<Namespace>().iterator());
		events.add(end);
		return events ;
	}

	protected void closeIO(){
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
	
	protected void writeIO() {
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
		correctPositionFound = false;
	}

	protected void nullifyIO() {
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
	
	protected void insertDatapoint(List<XMLEvent> Datapoint) {
		for(XMLEvent event : Datapoint) {
			try {
				writer.add(event);
			} catch (XMLStreamException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected List<XMLEvent> fieldToEvent(List<XMLEvent> events, XMLField field) throws Exception{
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
