package supportingClasses;

import java.util.List;
import dataBase.DataBase;
import objectsData.PortData;

public class ExtractingPortID {
	
	public static long getPortID(String portname) {
		
		List<PortData> listOfPorts = DataBase.searchPorts(portname);
		if (listOfPorts.size()>0) {
			return listOfPorts.get(0).getID();
		} 
		else {
			return 1l;
		}
		
	}
}
