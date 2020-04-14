package simulation;

import dataAccess.PortAccess;
import exceptions.AmbiguousElementSelectionException;
import objectsData.PortData;

public class CreatingPorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PortAccess portDataBase = new PortAccess();
		PortData port1 = new PortData(36941951971611l,"Denmark","Copenhagen",56.26f,9.50f);
		port1.addStationedContainer(36941951964596l);
		port1.addStationedContainer(503224331097700l);
		port1.addStationedContainer(503427604984200l);
		PortData port2 = new PortData(517776015757700l,"Pakistan","Gwadar",30.37f, 69.34f);
		port2.addStationedContainer(517776015753100l);
		port2.addStationedContainer(521664805370600l);
		portDataBase.newEntry(port1);
		portDataBase.newEntry(port2);
		
		
		
		
	}

}
