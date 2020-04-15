package simulation;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.Security;

public class SimulatingData {

	public static void main(String[] args) {
	/*ClientAccess clientDataBase = new ClientAccess();
	ArrayList<String> firstname = new ArrayList<String>();
	ArrayList<String> middlename = new ArrayList<String>();
	ArrayList<String> lastname = new ArrayList<String>();
	firstname.add("muna");
	lastname.add("azam");
	ClientData client1 = new ClientData(897841664500l,"random",45,23879091l,"random@random.com",firstname,middlename,lastname,"g-11/2","islamabad",58,"1400");
	firstname.clear();
	firstname.add("firstsecondname");
	middlename.add("middlename");
	ClientData client2 = new ClientData(36836570081685l,"company",92,23789,"email@eh.com",firstname,middlename,lastname,"g11/2","Islamabad",59,"2620");
	clientDataBase.newEntry(client1);
	clientDataBase.newEntry(client2);
	clientDataBase.flushActiveData();
	Security IDgenerator = new Security();
	PortData port1 = new PortData(IDgenerator.generateID(),"Pakistan","Gwadar",25.11f,62.33f);
	PortData port2 = new PortData(IDgenerator.generateID(),"Denmark","Copenhagen",55.70f,12.59f);
	PortAccess portDataBase = new PortAccess();
	portDataBase.newEntry(port1);
	portDataBase.newEntry(port2);
	portDataBase.flushActiveData();
	ContainerAccess containerDataBase = new ContainerAccess();
	ContainerData container1 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container2 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container3 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container4 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container5 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	ContainerData container6 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	ContainerData container7 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	ContainerData container8 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	containerDataBase.newEntry(container1);
	containerDataBase.newEntry(container2);
	containerDataBase.newEntry(container3);
	containerDataBase.newEntry(container4);
	containerDataBase.newEntry(container5);
	containerDataBase.newEntry(container6);
	containerDataBase.newEntry(container7);
	containerDataBase.newEntry(container8);
	containerDataBase.flushActiveData();
	try {
		PortData port3 = portDataBase.getEntry(port1.getID());
		port3.addStationedContainer(container1.getID());
		port3.addStationedContainer(container2.getID());
		port3.addStationedContainer(container3.getID());
		port3.addStationedContainer(container4.getID());
		portDataBase.editEntry(port3);
		portDataBase.flushActiveData();
		
	} catch (ElementNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		PortData port4 = portDataBase.getEntry(port2.getID());
		port4.addStationedContainer(container5.getID());
		port4.addStationedContainer(container6.getID());
		port4.addStationedContainer(container7.getID());
		port4.addStationedContainer(container8.getID());
		portDataBase.editEntry(port4);
		portDataBase.flushActiveData();
		
	} catch (ElementNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	PortData port1 = new PortData(747867434574400l,"Pakistan","Gwadar",25.11f,62.33f);
	PortData port2 = new PortData(747867452174100l,"Denmark","Copenhagen",55.70f,12.59f);
	PortAccess portDataBase = new PortAccess();
	port2.addStationedContainer(747868092327300l);
	port2.addStationedContainer(747868090565000l);
	port2.addStationedContainer(747868090793200l);
	port2.addStationedContainer(747868092129700l);
	port1.addStationedContainer(747868089277800l);
	port1.addStationedContainer(747868023659900l);
	port1.addStationedContainer(747868089097800l);
	port1.addStationedContainer(747868089523200l);
	portDataBase.newEntry(port2);
	portDataBase.newEntry(port1);
	portDataBase.flushActiveData();
	
	
	}
	

}
