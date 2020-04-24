package XMLParser;

import objectsData.*;
import java.util.*;
import javax.xml.stream.events.*;


public class ClientAccess extends IdentifiedDataAccess<ClientData> {
	public ClientAccess() {
		super("storage/activeData/clients.xml", "Client","Clients");
	}
	
	@Override
	protected ClientData dataFromEvents(DataPointParser dataPoint) {
		int i = 0;
		XMLEvent event;
		StartElement start;
		i = iterateUntilFound(i,dataPoint,"CompanyName");
		String companyName = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"CountryCode");
		int countryCode = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"PhoneBaseNumber");
		long phoneNumber = Long.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"Email");
		String email = dataPoint.getEventAtIndex(++i).getData();
		ArrayList<String> firstName = new ArrayList<>();
		ArrayList<String> middleName = new ArrayList<>();
		ArrayList<String> lastName = new ArrayList<>();
		i = iterateUntilFound(i,dataPoint,"FirstName");
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
		i = iterateUntilFound(i,dataPoint,"StreetName");
		String streetName = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"HouseNumber");
		int houseNumber = Integer.valueOf(dataPoint.getEventAtIndex(++i).getData());
		i = iterateUntilFound(i,dataPoint,"City");
		String city = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"ZipCode");
		String zipCode = dataPoint.getEventAtIndex(++i).getData();
		i = iterateUntilFound(i,dataPoint,"ActiveShipments");
		
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

