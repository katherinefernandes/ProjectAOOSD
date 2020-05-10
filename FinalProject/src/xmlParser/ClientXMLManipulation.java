package xmlParser;

import java.util.*;
import javax.xml.stream.events.*;

import dataBase.IdentifiablePersistency;
import objects.*;

/**
 * This class implements the database for clients.
 * It implements the singleton pattern, and is supposed to be used through the
 * IdentifiablePersistency interface.
 * It is one of the four entry points to the xmlParser package.
 * @author simon
 *
 */
public class ClientXMLManipulation extends GeneralXMLManipulation<Client> implements IdentifiablePersistency<Client> {
	private static ClientXMLManipulation selfInstance;
	
	public static ClientXMLManipulation getInstance() {
		if(selfInstance == null) {
			selfInstance = new ClientXMLManipulation();
		}
		return selfInstance;
	}
	
	private ClientXMLManipulation() {
		super("storage/activeData/clients.xml", "Client","Clients");
	}
	
	@Override
	protected Client objectFromDataPoint(DataPointParser dataPoint) {
		int i = 0;
		XMLEvent event;
		StartElement start;
		i = dataPoint.iterateUntilFound(i,"CompanyName");
		String companyName = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"CountryCode");
		int countryCode = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"PhoneBaseNumber");
		long phoneNumber = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"Email");
		String email = dataPoint.getEventAtIndex(++i).getData();
		ArrayList<String> firstName = new ArrayList<>();
		ArrayList<String> middleName = new ArrayList<>();
		ArrayList<String> lastName = new ArrayList<>();
		i = dataPoint.iterateUntilFound(i,"FirstName");
		while(!(((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement()) && event.asEndElement().getName().getLocalPart().equals("RefrencePersonName"))) {
			if(event.isStartElement()) {
				start = event.asStartElement();
				if(start.getName().getLocalPart().equals("FirstName")) {
					firstName.add(dataPoint.getEventAtIndex(++i).getData());
				}
				else if(start.getName().getLocalPart().equals("MiddleName")) {
					middleName.add(dataPoint.getEventAtIndex(++i).getData());
				}
				else if(start.getName().getLocalPart().equals("LastName")) {
					lastName.add(dataPoint.getEventAtIndex(++i).getData());
				}
			}
			i++;
		}
		i = dataPoint.iterateUntilFound(i,"StreetName");
		String streetName = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"HouseNumber");
		int houseNumber = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = dataPoint.iterateUntilFound(i,"City");
		String city = dataPoint.getEventAtIndex(++i).getData();
		i = dataPoint.iterateUntilFound(i,"ZipCode");
		String zipCode = dataPoint.getEventAtIndex(++i).getData();		
		
		Client client = new Client(dataPoint.getID(), companyName, countryCode, phoneNumber, email, firstName, middleName, lastName, streetName, city, houseNumber, zipCode);
		
		i = dataPoint.iterateUntilFound(i,"ActiveShipments");
		while(!((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement() && event.asEndElement().getName().getLocalPart().equals("ActiveShipments"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("JourneyID")) {
				client.addActiveShipment(Long.valueOf(dataPoint.getEventAtIndex(++i).getData()));
			}
			i++;
		}
		i = dataPoint.iterateUntilFound(i,"FinishedShipments");
		while(!((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement() && event.asEndElement().getName().getLocalPart().equals("FinishedShipments"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("JourneyID")) {
				client.setFinishedShipment(Long.valueOf(dataPoint.getEventAtIndex(++i).getData()));
			}
			i++;
		}
		return client;
	}

	@Override
	protected DataPointParser dataPointFromObject(Client client) {
		DataPointParser dataPoint = new DataPointParser(dataPointTagName);
		dataPoint.addStartEvent(dataPointTagName, client.getID());
		dataPoint.addCompleteElement("CompanyName",client.getCompanyName());
		
		dataPoint.addStartEvent("PhoneNumber");
		dataPoint.addCompleteElement("CountryCode", client.getPhoneNumber().getCountryCode());
		dataPoint.addCompleteElement("PhoneBaseNumber", client.getPhoneNumber().getPhone());
		dataPoint.addEndEvent("PhoneNumber");
		
		dataPoint.addCompleteElement("Email",client.getEmail());
		
		dataPoint.addStartEvent("RefrencePersonName");
		for(String name : client.getPerson().getFirstName()) {
			dataPoint.addCompleteElement("FirstName",name);
		}
		for(String name : client.getPerson().getMiddleName()) {
			dataPoint.addCompleteElement("MiddleName",name);
		}
		for(String name : client.getPerson().getLastName()) {
			dataPoint.addCompleteElement("LastName",name);
		}
		dataPoint.addEndEvent("RefrencePersonName");
		
		dataPoint.addStartEvent("Address");
		dataPoint.addCompleteElement("StreetName", client.getAddress().getStreetName());
		dataPoint.addCompleteElement("HouseNumber", client.getAddress().getHouseNumber());
		dataPoint.addCompleteElement("City", client.getAddress().getCity());
		dataPoint.addCompleteElement("ZipCode", client.getAddress().getZipCode());
		dataPoint.addEndEvent("Address");
		
		dataPoint.addStartEvent("ActiveShipments");
		for(long ID : client.getActiveShipments()) {
			dataPoint.addCompleteElement("JourneyID",ID);
		}
		dataPoint.addEndEvent("ActiveShipments");
		
		dataPoint.addStartEvent("FinishedShipments");
		for(long ID : client.getFinishedShipments()) {
			dataPoint.addCompleteElement("JourneyID",ID);
		}
		dataPoint.addEndEvent("FinishedShipments");
		
		dataPoint.addEndEvent(dataPointTagName);
		return dataPoint;
	}
}

