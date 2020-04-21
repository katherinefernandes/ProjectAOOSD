package simulation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dataAccess.ClientAccess;
import dataAccess.ContainerAccess;
import dataAccess.PortAccess;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.Security;
import supportingClasses.parseInput;

public class SimulatingData {

	public static void main(String[] args) {
		ClientAccess clientDataBase = new ClientAccess();
		ArrayList<String> firstname = new ArrayList<String>();
		ArrayList<String> middlename = new ArrayList<String>();
		ArrayList<String> lastname = new ArrayList<String>();
		
		
		firstname.add("muna");
		lastname.add("azam");
		ClientData client4 = new ClientData(555555555555l,"White notebook", 45, 85665565l, "whitenotebook@wn.com", firstname, middlename, lastname, "fysikvej", "kongens lyngby", 303, "2700");
		ClientData client1 = new ClientData(897841664500l,"random",45,23879091l,"random@random.com",firstname,middlename,lastname,"g-11/2","islamabad",58,"1400");
		firstname.clear();
		firstname.add("firstsecondname");
		middlename.add("middlename");
		ClientData client2 = new ClientData(36836570081685l,"company",92,23789,"email@eh.com",firstname,middlename,lastname,"g11/2","Islamabad",59,"2620");
		ClientData client3 = new ClientData(828300261636100l,"Companyname",98,23457890l,"company@email.com",firstname,middlename,lastname,"somestreet","somecity",89,"23890");
		clientDataBase.newEntry(client1);
		clientDataBase.newEntry(client2);
		clientDataBase.newEntry(client3);
		clientDataBase.newEntry(client4);
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
		ContainerData container9 = new ContainerData(10849147913500l,897841664500l,IDgenerator.generateID(),port1.getID(),port2.getID(),26.11f,74.33f,"snacks",36.0f,1.0f,78.0f,parseInput.getDate("23-06-2020"));
		ContainerData container11 = new ContainerData(10849147913512l,897841664500l,IDgenerator.generateID(),port1.getID(),port2.getID(),26.11f,74.33f,"snacks",36.0f,1.0f,78.0f,parseInput.getDate("23-06-2020"));
		ContainerData container10 = new ContainerData(12708737034600l,14618447211200l,17027135462300l,port2.getID(),port1.getID(),33.11f,78.89f,"fish",0.0f,1.0f,20.0f,parseInput.getDate("23-06-2020"));
		ClientData client5 = new ClientData(14618447211200l,"client4",45,40472098l,"client4@client.com",firstname,middlename,lastname,"randomstreet","somecity",98,"23909");
		client5.addActiveShipment(container10.getJourneyID());
		port1.addArrivingContainer(container10.getID());
		clientDataBase.newEntry(client5);
		clientDataBase.flushActiveData();
		containerDataBase.newEntry(container11);
		containerDataBase.newEntry(container9);
		containerDataBase.newEntry(container1);
		containerDataBase.newEntry(container2);
		containerDataBase.newEntry(container3);
		containerDataBase.newEntry(container4);
		containerDataBase.newEntry(container5);
		containerDataBase.newEntry(container6);
		containerDataBase.newEntry(container7);
		containerDataBase.newEntry(container8);
		containerDataBase.newEntry(container10);
		port2.addStationedContainer(container8.getID());
		port2.addStationedContainer(container7.getID());
		port2.addStationedContainer(container6.getID());
		port2.addStationedContainer(container5.getID());
		port1.addStationedContainer(container4.getID());
		port1.addStationedContainer(container3.getID());
		port1.addStationedContainer(container2.getID());
		port1.addStationedContainer(container1.getID());
		PortData port3 = new PortData(IDgenerator.generateID(),"Singapore","Keppel",1.26f,103.83f);
		portDataBase.newEntry(port2);
		portDataBase.newEntry(port1);
		portDataBase.newEntry(port3);
		portDataBase.flushActiveData();
		containerDataBase.flushActiveData();
	
	}
	

}
