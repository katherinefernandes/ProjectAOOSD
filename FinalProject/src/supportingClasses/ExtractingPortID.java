package supportingClasses;

import java.util.List;

import businessObjects.Port;
import dataBase.DataBase;

public class ExtractingPortID {
	
	
	/**
	 * For the given port name, this method returns the port ID
	 * @param portname
	 * @return either port ID or 1l if the port if not found in the database
	 */
	public static long getPortID(String portname) {
		
		List<Port> listOfPorts = DataBase.searchPorts(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}
}
