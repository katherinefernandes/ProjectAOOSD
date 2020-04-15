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
	clientDataBase.newEntry(client1);
	clientDataBase.newEntry(client2);
	clientDataBase.flushActiveData();
	}
	

}
