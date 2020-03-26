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
	
	public void newEntry(ClientData data) {
		Element root = doc.getDocumentElement();
		
		Element newClient = elementFromData(data);
		
		NodeList clients = root.getChildNodes();
		long clientIDValue = data.getClientID();
		
		if( nodeMethods.needsToBeInsertedAtEnd(clients, clientIDValue)) {
			root.appendChild(newClient);
		}
		else {
			insertElement(newClient, root);
		}
		
		transform();
	}
	

	public void editEntry(ClientData data) throws ElementNotFoundException{
		Element root = doc.getDocumentElement();
		Element oldClient;
		Element newClient = elementFromData(data);
		
		oldClient = getElementFromID(nodeMethods.getElementID(newClient), root);
		root.replaceChild(newClient, oldClient);
		
		transform();
	}
	
	
	public void deleteEntry(long ID) throws DOMException, ElementNotFoundException {
		Element root = doc.getDocumentElement();
		
		root.removeChild(getElementFromID(ID, root));
		
		transform();
	}

	
	public ClientData getEntry(long ID) throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		Element client = getElementFromID(ID, doc.getDocumentElement());
		ClientData clientData = dataFromElement(client);
		return clientData;
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
		newElementWithValue(phoneNumberElement, "PhoneNumberBase", String.valueOf(phoneNumber.getPhone()));
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
		Element addressElement = nodeMethods.singleElementFromTagName(client, "Address");
		NodeList activeShipmentsElements = nodeMethods.singleElementFromTagName(client, "ActiveShipments").getChildNodes();
		List<String> journeyIDStrings = nodeMethods.getValuesFromChildNodes(activeShipmentsElements);
		
		
		long 			   clientID = Integer.valueOf(nodeMethods.valueFromTagName(client, "ClientID"));
		String 			   companyName = nodeMethods.valueFromTagName(client, "CompanyName");
		int 			   countryCode = Integer.valueOf(nodeMethods.valueFromTagName(nodeMethods.singleElementFromTagName(client,"PhoneNumber"), "CountryCode"));
		int 			   phoneNumber = Integer.valueOf(nodeMethods.valueFromTagName(nodeMethods.singleElementFromTagName(client,"PhoneNumber"), "PhoneBaseNumber"));
		String 			   email = nodeMethods.valueFromTagName(client, "Email");
		List<List<String>> names = getNames(client);
		String 			   streetName = nodeMethods.valueFromTagName(addressElement, "StreetName");
		int 			   houseNumber = Integer.valueOf(nodeMethods.valueFromTagName(addressElement, "HouseNumber"));
		String 			   city = nodeMethods.valueFromTagName(addressElement, "City");
		String 			   zipCode = nodeMethods.valueFromTagName(addressElement, "ZipCode");
		List<Long> 		   journeyIDs = new ArrayList<>();
		
		
		for (int i = 0; i < journeyIDStrings.size(); i++) {
			journeyIDs.add(Long.valueOf(journeyIDStrings.get(i)));
		}
		
		ClientData clientData = new ClientData(clientID, companyName, countryCode, phoneNumber, email, (ArrayList<String>) names.get(0), (ArrayList<String>) names.get(1), (ArrayList<String>) names.get(2), streetName, city, houseNumber, zipCode);
		
		
		return clientData;
	}

	
	private List<List<String>> getNames(Element client) throws AmbiguousElementSelectionException, ElementNotFoundException {
		List<List<String>> names = new ArrayList<List<String>>();
		
		Element namesElement = nodeMethods.singleElementFromTagName(client, "RefrencePersonName");
		
		NodeList firstNamesElements = namesElement.getElementsByTagName("FirstName");
		NodeList middleNamesElements = namesElement.getElementsByTagName("MiddleName");
		NodeList lastNamesElements = namesElement.getElementsByTagName("LastName");
		List<NodeList> namesElementsList = new ArrayList<NodeList>(3);
		namesElementsList.set(0, firstNamesElements);
		namesElementsList.set(1, middleNamesElements);
		namesElementsList.set(2, lastNamesElements);
		
		for(int i = 0; i < 3; i++) {
			NodeList namesElements = namesElementsList.get(i);
			names.add(nodeMethods.getValuesFromChildNodes(namesElements));
		}
		return names;
	}

}

