package supportingClasses;

import java.util.List;

import objectsData.PortData;
import xmlParser.PortXMLManipulation;

public class ExtractingPortID {
	
	private PortXMLManipulation databasePort;
	
	public ExtractingPortID() {
		databasePort =new PortXMLManipulation();
	}
	
	public long getPortID(String portname) {
		
		List<PortData> listOfPorts = databasePort.searchEntries(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}
}
