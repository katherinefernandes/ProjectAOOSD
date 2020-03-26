package dataAccessTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.*;

import dataAccess.ClientAccess;
import objectsData.ClientData;

public class ClientAccessTest {
	ClientData client1;
	ClientData client2;
	ClientData client1_v2;
	ArrayList<ClientData> sortTestClients;
	ArrayList<Long> toBeDeleted;
	ClientAccess clientAccess;
	Random random;
	
	@Before
	public void init() {
		clientAccess = new ClientAccess();

		ArrayList<String> firstNames1 = new ArrayList<String>();
		firstNames1.add("Rincewind");
		ArrayList<String> middleNames1 = new ArrayList<String>();
		middleNames1.add("S.");
		middleNames1.add("Thompson");
		middleNames1.add("Providence");
		ArrayList<String> lastNames1 = new ArrayList<String>();
		lastNames1.add("Marx");

		client1 = new ClientData(102621L,"Washington cleaning",45,
								123456789,"clean.your.pipes@wash.com",
								firstNames1,middleNames1,lastNames1,
								"Bakerstreet","Derry",42,"1213");
		
		ArrayList<String> firstNames2 = new ArrayList<String>();
		firstNames2.add("Lord");
		firstNames2.add("Thomas");
		ArrayList<String> middleNames2 = new ArrayList<String>();
		middleNames2.add("of");
		middleNames2.add("Rivendell");
		ArrayList<String> lastNames2 = new ArrayList<String>();
		lastNames2.add("the");
		lastNames2.add("Third");

		client2 = new ClientData(2530321L,"Trucking brothers AS",47,
								666663436,"trucker.m.f@gmail.com",
								firstNames2,middleNames2,lastNames2,
								"Elm street","Arkham",33,"2000");
		
		client1_v2 = new ClientData(102621L,"new Washington cleansing",46,
									123456789,"clean.your.pipes@wash.com",
									firstNames1,middleNames1,lastNames1,
									"Bakerstreet","Darry",42,"1216");
		
		for (int i = 0; i < 20; i++) {
			long ID = random.nextLong();
			ArrayList<String> firstName = new ArrayList<>();
			ArrayList<String> middleName = new ArrayList<>();
			ArrayList<String> lastName = new ArrayList<>();
			firstName.add("a");
			middleName.add("a");
			lastName.add("a");
			
			sortTestClients.add(new ClientData(ID,"a",1,1,"a",firstName,middleName,lastName,"a","a",1,"1"));
		}
	}
	
	@AfterEach
	public void CleanUp() {
		
	}
	
	
	public void insertClient(ClientData clientData) {
		clientAccess.newEntry(clientData);
		toBeDeleted.add(clientData.getClientID());
	}
}
