package dataAccess;

import objectsData.ClientData;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.w3c.dom.*;

public class TestDataAccess {
	ClientAccess clientAccess;
	ClientData client;
	
	@Before
	public void setup() {
		clientAccess = new ClientAccess();
		
		ArrayList<String> middleNames = new ArrayList<String>();
		middleNames.add("S.");
		middleNames.add("Thompson");
		middleNames.add("Providence");
		
		client = new ClientData(102621L,"Washington cleaning",
								123456789,"clean.your.pipes@wash.com",
								"Rincewind",middleNames,"Marx",
								"Bakerstreet","Derry",42,1213);
	}
	
	@Test
	public void testCreateClient() {
		clientAccess.newEntry(client);
		System.out.print("Automatic file test not implemented. Check file manually and reset with .bat file");
		
	}
	
}
