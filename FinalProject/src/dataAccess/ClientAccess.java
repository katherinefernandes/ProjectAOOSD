package dataAccess;

import objectsData.*;

import java.io.*;
import java.util.*;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.events.*;

import exceptions.ElementNotFoundException;


public class ClientAccess extends IdentifiedDataAccess<ClientData> {
	public ClientAccess() {
		super("storage/activeData/clients.xml", "Client","Clients");
	}
	
	@Override
	protected ClientData dataFromEvents(List<XMLEvent> events, long ID) {
		int i = 0;
		XMLEvent event;
		StartElement start;
		i = iterateUntilFound(i,events,"CompanyName");
		String companyName = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"CountryCode");
		int countryCode = Integer.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"PhoneBaseNumber");
		long phoneNumber = Long.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"Email");
		String email = events.get(++i).asCharacters().getData();
		ArrayList<String> firstName = new ArrayList<>();
		ArrayList<String> middleName = new ArrayList<>();
		ArrayList<String> lastName = new ArrayList<>();
		i = iterateUntilFound(i,events,"FirstName");
		while(!(((event = events.get(i)).isEndElement()) && event.asEndElement().getName().getLocalPart().equals("RefrencePersonName"))) {
			if(event.isStartElement()) {
				start = event.asStartElement();
				if(start.getName().getLocalPart().equals("FirstName")) {
					firstName.add(events.get(++i).asCharacters().getData());
				}
				else if(start.getName().getLocalPart().equals("MiddleName")) {
					middleName.add(events.get(++i).asCharacters().getData());
				}
				else if(start.getName().getLocalPart().equals("LastName")) {
					lastName.add(events.get(++i).asCharacters().getData());
				}
			}
			i++;
		}
		i = iterateUntilFound(i,events,"StreetName");
		String streetName = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"HouseNumber");
		int houseNumber = Integer.valueOf(events.get(++i).asCharacters().getData());
		i = iterateUntilFound(i,events,"City");
		String city = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"ZipCode");
		String zipCode = events.get(++i).asCharacters().getData();
		i = iterateUntilFound(i,events,"ActiveShipments");
		
		ClientData client = new ClientData(ID, companyName, countryCode, phoneNumber, email, firstName, middleName, lastName, streetName, city, houseNumber, zipCode);
		
		while(!((event = events.get(i)).isEndElement() && event.asEndElement().getName().getLocalPart().equals("ActiveShipments"))) {
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("JourneyID")) {
				client.addActiveShipment(Long.valueOf(events.get(++i).asCharacters().getData()));
			}
			i++;
		}
		return client;
	}
	

	/*
	@Override
	public List<XMLEvent> eventsFromData(ClientData data){
		List<XMLEvent> events = new ArrayList<>();
		List<Attribute> ID = new ArrayList<>();
		ID.add(eventFactory.createAttribute("ID", String.valueOf(data.getID())));
		StartElement clientEvent = eventFactory.createStartElement("", "", "Client", ID.iterator(), new ArrayList<Namespace>().iterator());
		events.add(clientEvent);
		events.add(generateStart("CompanyName"));
		events.add(generateText(data.getCompanyName()));
		events.add(generateEnd("CompanyName"));
		events.add(generateStart("PhoneNumber"));
		events.add(generateStart("ContryCode"));
		events.add(generateText(data.getPhoneNumber().getCountryCode()));
		events.add(generateEnd("CountryCode"));
		events.add(generateStart("PhoneBaseNumber"));
		events.add(generateText(data.getPhoneNumber().getPhone()));
		events.add(generateEnd("PhoneBaseNumber"));
		events.add(generateEnd("PhoneNumber"));
		events.add(generateStart("Email"));
		events.add(generateText(data.getEmail()));
		events.add(generateEnd("Email"));
		events.add(generateStart("RefrencePersonName"));
		ReferenceName name = data.getPerson();
		for(String firstName : name.getFirstName()) {
			events.add(generateStart("FirstName"));
			events.add(generateText(firstName));
			events.add(generateEnd("FirstName"));
		}
		for(String middleName : name.getFirstName()) {
			events.add(generateStart("MiddleName"));
			events.add(generateText(middleName));
			events.add(generateEnd("MiddleName"));
		}
		for(String lastName : name.getFirstName()) {
			events.add(generateStart("LastName"));
			events.add(generateText(lastName));
			events.add(generateEnd("LastName"));
		}
		events.add(generateEnd("RefrencePersonName"));
		events.add(generateStart("Address"));
		events.add(generateStart("StreetName"));
		events.add(generateText(data.getAddress().getStreetName()));
		events.add(generateEnd("StreetName"));
		events.add(generateStart("HouseNumber"));
		events.add(generateText(data.getAddress().getHouseNumber()));
		events.add(generateEnd("HouseNumber"));
		events.add(generateStart("City"));
		events.add(generateText(data.getAddress().getCity()));
		events.add(generateEnd("City"));
		events.add(generateStart("ZipCode"));
		events.add(generateText(data.getAddress().getZipCode()));
		events.add(generateEnd("ZipCode"));
		events.add(generateEnd("Address"));
		events.add(generateStart("ActiveShipments"));
		for(long journeyID : data.getActiveShipment()) {
			events.add(generateStart("JourneyID"));
			events.add(generateText(journeyID));
			events.add(generateEnd("JourneyID"));
		}
		events.add(generateEnd("ActiveShipments"));
		events.add(generateEnd("Client"));
		
		return events;
	}

	@Override
	protected ClientData dataOfEvents(List<XMLEvent> events) {
		
		return null;
	}*/

}

