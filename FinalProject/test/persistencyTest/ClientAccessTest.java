package persistencyTest;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import dataBase.DataBase;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;

public class ClientAccessTest extends IdentifiableDataAccessTest<ClientData>{
	
	public ClientAccessTest() {
		super();

		ArrayList<String> firstNames1 = new ArrayList<String>();
		firstNames1.add("Rincewind");
		ArrayList<String> middleNames1 = new ArrayList<String>();
		middleNames1.add("S.");
		middleNames1.add("Thompson");
		middleNames1.add("Providence");
		ArrayList<String> lastNames1 = new ArrayList<String>();
		lastNames1.add("Marx");

		data1 = new ClientData(555555555557L,"Washington cleaning",45,
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

		data2 = new ClientData(2530321L,"Trucking brothers AS",47,
								666663436,"trucker.m.f@gmail.com",
								firstNames2,middleNames2,lastNames2,
								"Elm street","Arkham",33,"2000");
		
		data1_v2 = new ClientData(555555555557L,"new Washington cleansing",46,
									123456789,"clean.your.pipes@wash.com",
									firstNames1,middleNames1,lastNames1,
									"Bakerstreet","Darry",42,"1216");
		data1.addActiveShipment(1766465L);
		data1.addActiveShipment(8923892L);
		data1.addActiveShipment(10390101L);
		
		for (int i = 0; i < 20; i++) {
			long ID = Math.abs(random.nextLong());
			ArrayList<String> firstName = new ArrayList<>();
			ArrayList<String> middleName = new ArrayList<>();
			ArrayList<String> lastName = new ArrayList<>();
			firstName.add("a");
			middleName.add("a");
			lastName.add("a");
			
			sortTestData.add(new ClientData(ID,"a",1,1,"a",firstName,middleName,lastName,"a","a",1,"1"));
		}
	}
	
	@Test
	public void persistencyTestT() throws NumberFormatException, ElementNotFoundException {
		persistencyTest(); }
	@Test
	public void editTestT() throws NumberFormatException, ElementNotFoundException {
		editTest(); }
	
	@Override
	protected void delete(long ID) {
		DataBase.deleteClient(ID);
	}
	@Override
	protected ClientData getObject(long ID) throws ElementNotFoundException {
		return DataBase.getClient(ID);
	}
	@Override
	protected void assertEqualData(ClientData clientY, ClientData clientX) {
		assertEquals(clientY.getID(),clientX.getID());
		assertEquals(clientY.getCompanyName(),clientX.getCompanyName());
		assertEquals(clientY.getPhoneNumber().getCountryCode(),clientX.getPhoneNumber().getCountryCode());
		assertEquals(clientY.getPhoneNumber().getPhone(),clientX.getPhoneNumber().getPhone());
		assertEquals(clientY.getEmail(),clientX.getEmail());
		assertEquals(clientY.getPerson().getFirstName(),clientX.getPerson().getFirstName());
		assertEquals(clientY.getPerson().getMiddleName(),clientX.getPerson().getMiddleName());
		assertEquals(clientY.getPerson().getLastName(),clientX.getPerson().getLastName());
		assertEquals(clientY.getAddress().getStreetName(),clientX.getAddress().getStreetName());
		assertEquals(clientY.getAddress().getCity(),clientX.getAddress().getCity());
		assertEquals(clientY.getAddress().getHouseNumber(),clientX.getAddress().getHouseNumber());
		assertEquals(clientY.getAddress().getZipCode(),clientX.getAddress().getZipCode());
		List<Long> journeyIDsX = clientX.getActiveShipment();
		List<Long> journeyIDsY = clientY.getActiveShipment();
		assertEquals(journeyIDsX,journeyIDsY);
	}
	
	protected long getDataID(ClientData clientData) {
		return clientData.getID();
	}
}
