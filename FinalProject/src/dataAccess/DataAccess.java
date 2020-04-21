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
	protected Schema schema;
	protected String filePath;
	protected String dataPointTagName;
	protected String collectionTagName;
	
	protected XMLEventReader reader;
	protected XMLEventWriter writer;
	protected FileInputStream streamIn;
	protected FileOutputStream streamOut;
	protected File fileIn;
	protected File fileOut;
	
	
	public DataAccess(String filePath, String elementsName, String collectionsName) {
		this.filePath = filePath;
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
	
	protected int iterateUntilFound(int index, DataPointParser dataPoint, String find) {
		XMLEvent event;
		while(!((event = dataPoint.getEventAtIndex(index).getEvent()).isStartElement() && event.asStartElement().getName().getLocalPart().equals(find))){
			index++;
		}
		return index;
	}
	
	protected void insertDataPoint(List<EventParser> dataPoint) {
		try {
		for(EventParser event : dataPoint) {
				writer.add(event.getEvent());
			} 
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
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
