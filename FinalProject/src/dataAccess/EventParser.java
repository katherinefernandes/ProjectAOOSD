package dataAccess;

import javax.xml.namespace.QName;
import javax.xml.stream.events.*;

class EventParser {
	private XMLEvent event;
	
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
	
	public Attribute getIDAttribute() {
		return event.asStartElement().getAttributeByName(QName.valueOf("ID"));
	}
	
	public String getData() {
		return event.asCharacters().getData();
	}
}
