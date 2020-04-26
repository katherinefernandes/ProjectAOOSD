package supportingClasses;

import java.util.List;

import businessObjects.Port;
import dataBase.DataBase;

public class ExtractingPortID {
	
	public long getPortID(String portname) {
		
		List<Port> listOfPorts = DataBase.searchPorts(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}
}
