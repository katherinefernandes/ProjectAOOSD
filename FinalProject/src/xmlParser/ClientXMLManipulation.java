package xmlParser;

import objectsData.*;
import java.util.*;
import javax.xml.stream.events.*;

import dataBase.IdentifiablePersistency;


 public class ClientXMLManipulation extends IdentifiableXMLManipulation<ClientData> implements IdentifiablePersistency<ClientData> {
	public ClientXMLManipulation() {
		super("storage/activeData/clients.xml", "Client","Clients");
	}
	
	@Override
	protected ClientData objectFromDataPoint(DataPointParser dataPoint) {
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
		i = dataPoint.iterateUntilFound(i,"ActiveShipments");
		
		ClientData client = new ClientData(dataPoint.getID(), companyName, countryCode, phoneNumber, email, firstName, middleName, lastName, streetName, city, houseNumber, zipCode);
		
		while(!((event = dataPoint.getEventAtIndex(i).getEvent()).isEndElement() && event.asEndElement().getName().getLocalPart().equals("ActiveShipments"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("JourneyID")) {
				client.addActiveShipment(Long.valueOf(dataPoint.getEventAtIndex(++i).getData()));
			}
			i++;
		}
		return client;
	}
}

