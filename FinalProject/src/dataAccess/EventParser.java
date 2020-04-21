package dataAccess;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.events.*;


public class EventParser {
	private XMLEvent event;
	private static XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	
	public EventParser(XMLEvent event){
		this.event = event;
	}
	
	public XMLEvent getEvent() {
		return event;
	}
	
	public String getEventName() {
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
	
	public boolean isStartOfDataPoint(String dataPointTagName) {
		return event.isStartElement() && getEventName().equals(dataPointTagName);
	}
	
	public boolean isEndOfDataPoint(String dataPointTagName) {
		return event.isEndElement() && getEventName().equals(dataPointTagName);
	}
	
	public boolean isDataField() {
		return event.isCharacters();
	}
	
	public void setIDAttribute(long ID) {
		if(event.isStartElement()) {
			Attribute IDAttribute = eventFactory.createAttribute("ID", String.valueOf(ID));
			String elementName = getEventName();
			List<Attribute> IDList = new ArrayList<>();
			IDList.add(IDAttribute);
			event = eventFactory.createStartElement("", "", elementName, IDList.iterator(), new ArrayList<Namespace>().iterator());
		}
		else {
			throw new Error("Can not add ID to non start element");
		}
	}
	
	public Attribute getIDAttribute() {
		return event.asStartElement().getAttributeByName(QName.valueOf("ID"));
	}
	
	public String getData() {
		return event.asCharacters().getData();
	}
	
	public static EventParser generateStart(String string) {
		return new EventParser(eventFactory.createStartElement("","",string));
	}
	
	public static EventParser generateText(Object string) {
		return new EventParser(eventFactory.createCharacters(String.valueOf(string)));
	}
	
	public static EventParser generateEnd(String string) {
		return new EventParser(eventFactory.createEndElement("", "", string));
	}
	
	public static EventParser generateEndDoc() {
		return new EventParser(eventFactory.createEndDocument());
	}
}
