package dataAccess;

import objectsData.*;

import java.io.*;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;


public class ClientAccess extends DataAccess<ClientData> {
	
	
	public ClientAccess() {
		super("storage/activeData/clients.xml");
	}
	
	
	protected Element elementFromData(ClientData data) {
		Element newClient = doc.createElement("Client");
		
		PhoneNumber phoneNumber = data.getPhoneNumber();
		Element phoneNumberElement = doc.createElement("PhoneNumber");
		ReferenceName name = data.getPerson();
		Element nameElement = doc.createElement("RefrencePersonName");
		Address address = data.getAddress();
		Element addressElement = doc.createElement("Address");
		List<Long> activeShipments = data.getActiveShipment();
		Element activeShipmentsElement = doc.createElement("ActiveShipments");
		
		newElementWithValue(newClient, "ClientID", String.valueOf(data.getClientID()));
		newElementWithValue(newClient, "CompanyName", data.getCompanyName());
		
		newElementWithValue(phoneNumberElement, "CountryCode", String.valueOf(phoneNumber.getCountryCode()));
		newElementWithValue(phoneNumberElement, "PhoneBaseNumber", String.valueOf(phoneNumber.getPhone()));
		newClient.appendChild(phoneNumberElement);
		
		newElementWithValue(newClient, "Email", data.getEmail());
	
		for(String firstname : name.getFirstName()) {
			newElementWithValue(nameElement,"FirstName",firstname);
		}	
		for(String middleName : name.getMiddleName()) {
			newElementWithValue(nameElement,"MiddleName",middleName);
		}
		for (String lastName: name.getLastName()) {
			newElementWithValue(nameElement,"LastName",lastName);
		}
		newClient.appendChild(nameElement);
		
		newElementWithValue(addressElement,"StreetName",address.getStreetName());
		newElementWithValue(addressElement,"HouseNumber",String.valueOf(address.getHouseNumber()));
		newElementWithValue(addressElement,"City",address.getCity());
		newElementWithValue(addressElement,"ZipCode",String.valueOf(address.getZipCode()));
		newClient.appendChild(addressElement);
		
		for(long journeyID : activeShipments) {
			newElementWithValue(activeShipmentsElement,"JourneyID",String.valueOf(journeyID));
		}
		newClient.appendChild(activeShipmentsElement);
		
		return newClient;
	}
	
	
	protected ClientData dataFromElement(Element client) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		Element addressElement = NodeMethods.singleElementFromTagName(client, "Address");
		NodeList activeShipmentsElements = NodeMethods.singleElementFromTagName(client, "ActiveShipments").getChildNodes();
		List<String> journeyIDStrings = NodeMethods.getValuesFromChildNodes(activeShipmentsElements);
		
		
		long 			   clientID = Long.valueOf(NodeMethods.valueFromTagName(client, "ClientID"));
		String 			   companyName = NodeMethods.valueFromTagName(client, "CompanyName");
		int 			   countryCode = Integer.valueOf(NodeMethods.valueFromTagName(NodeMethods.singleElementFromTagName(client,"PhoneNumber"), "CountryCode"));
		int 			   phoneNumber = Integer.valueOf(NodeMethods.valueFromTagName(NodeMethods.singleElementFromTagName(client,"PhoneNumber"), "PhoneBaseNumber"));
		String 			   email = NodeMethods.valueFromTagName(client, "Email");
		List<List<String>> names = getNames(client);
		String 			   streetName = NodeMethods.valueFromTagName(addressElement, "StreetName");
		int 			   houseNumber = Integer.valueOf(NodeMethods.valueFromTagName(addressElement, "HouseNumber"));
		String 			   city = NodeMethods.valueFromTagName(addressElement, "City");
		String 			   zipCode = NodeMethods.valueFromTagName(addressElement, "ZipCode");
		
		ClientData clientData = new ClientData(clientID, companyName, countryCode, phoneNumber, email, (ArrayList<String>) names.get(0), (ArrayList<String>) names.get(1), (ArrayList<String>) names.get(2), streetName, city, houseNumber, zipCode);
		
		
		for (int i = 0; i < journeyIDStrings.size(); i++) {
			clientData.addActiveShipment(Long.valueOf(journeyIDStrings.get(i)));
		}
		
		
		
		return clientData;
	}

	
	private List<List<String>> getNames(Element client) throws AmbiguousElementSelectionException, ElementNotFoundException {
		List<List<String>> names = new ArrayList<List<String>>();
		
		Element namesElement = NodeMethods.singleElementFromTagName(client, "RefrencePersonName");
		
		NodeList firstNamesElements = namesElement.getElementsByTagName("FirstName");
		NodeList middleNamesElements = namesElement.getElementsByTagName("MiddleName");
		NodeList lastNamesElements = namesElement.getElementsByTagName("LastName");
		List<NodeList> namesElementsList = new ArrayList<NodeList>();
		namesElementsList.add(firstNamesElements);
		namesElementsList.add(middleNamesElements);
		namesElementsList.add(lastNamesElements);
		
		for(int i = 0; i < 3; i++) {
			NodeList namesElements = namesElementsList.get(i);
			names.add(NodeMethods.getValuesFromChildNodes(namesElements));
		}
		return names;
	}

}

