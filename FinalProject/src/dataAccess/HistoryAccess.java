package dataAccess;



import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.w3c.dom.*;

import objectsData.HistoryData;

public class HistoryAccess extends DataAccess<HistoryData> {
	public HistoryAccess() {
		super("storage/activeData/history.xml");
	}
	
	public Element elementFromData(HistoryData data) {
		Element newDataPoint = doc.createElement("DataPoint");
		newElementWithValue(newDataPoint,"TimeStamp",String.valueOf(data.getTimeStamp().toEpochSecond(ZoneOffset.UTC)));
		newElementWithValue(newDataPoint,"ContainerID",String.valueOf(data.getContainerID()));
		newElementWithValue(newDataPoint,"JourneyID",String.valueOf(data.getJourneyID()));
		newElementWithValue(newDataPoint,"DestinationPortID",String.valueOf(data.getDestinationPortID()));
		newElementWithValue(newDataPoint,"StartPortID",String.valueOf(data.getStartPortID()));
		newElementWithValue(newDataPoint,"Cargo",data.getCargo());
		Element statusElement = doc.createElement("InternalState");
		return null;
	}
	
	
	/*public void newEntry(HistoryData data) {
		Element newEntry = elementFromData(data);
		LocalDateTime timeStamp = data.getTimeStamp();
		Element root = doc.getDocumentElement();
		NodeList elements = root.getChildNodes();
		if(elements.getLength() == 0 ||  timeStamp > elementTimeStamp(elements.item(elements.getLength() - 1))) {
			root.appendChild(newEntry);
			transform();
			return;
		}
		int index = 0;
		LocalDateTime ldt = LocalDateTime.ofEpochSecond(20000L,0,ZoneOffset.UTC);
		while(timeStamp < elementTimeStamp(elements.item(index))) {
			index += 1;
		}
		
		
	}*/
	
	//elementFromData()
	//elementTimeStamp
}
