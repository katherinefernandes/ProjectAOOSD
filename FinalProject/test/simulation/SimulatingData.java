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
	ClientAccess clientDataBase = new ClientAccess();
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
	ClientData client3 = new ClientData(828300261636100l,"Companyname",98,23457890l,"company@email.com",firstname,middlename,lastname,"somestreet","somecity",89,"23890");
	clientDataBase.newEntry(client1);
	clientDataBase.newEntry(client2);
	clientDataBase.newEntry(client3);
	clientDataBase.flushActiveData();
	Security IDgenerator = new Security();
	PortData port1 = new PortData(IDgenerator.generateID(),"Pakistan","Gwadar",25.11f,62.33f);
	PortData port2 = new PortData(IDgenerator.generateID(),"Denmark","Copenhagen",55.70f,12.59f);
	PortAccess portDataBase = new PortAccess();
	ContainerAccess containerDataBase = new ContainerAccess();
	ContainerData container1 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container2 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container3 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container4 = new ContainerData(IDgenerator.generateID(),port1.getID(),25.11f,62.33f);
	ContainerData container5 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	ContainerData container6 = new ContainerData(IDgenerator.generateID(),port2.getID(),55.70f,12.59f);
	ContainerData container7 = new ContainerData(73013416799200l,port2.getID(),55.70f,12.59f);
	ContainerData container8 = new ContainerData(521664805370600l,port2.getID(),55.70f,12.59f);
	containerDataBase.newEntry(container1);
	containerDataBase.newEntry(container2);
	containerDataBase.newEntry(container3);
	containerDataBase.newEntry(container4);
	containerDataBase.newEntry(container5);
	containerDataBase.newEntry(container6);
	containerDataBase.newEntry(container7);
	containerDataBase.newEntry(container8);

	port2.addStationedContainer(container8.getID());
	port2.addStationedContainer(container7.getID());
	port2.addStationedContainer(container6.getID());
	port2.addStationedContainer(container5.getID());
	port1.addStationedContainer(container4.getID());
	port1.addStationedContainer(container3.getID());
	port1.addStationedContainer(container2.getID());
	port1.addStationedContainer(container1.getID());
	portDataBase.newEntry(port2);
	portDataBase.newEntry(port1);
	portDataBase.flushActiveData();
	containerDataBase.flushActiveData();
	
	}
	

}
